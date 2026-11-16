package p32929.myadslib

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.util.TypedValue
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

internal object Bg {
    private val pool = Executors.newFixedThreadPool(2)
    private val main = Handler(Looper.getMainLooper())

    fun <T> run(work: () -> T?, done: (T?) -> Unit) {
        pool.execute {
            val result = try { work() } catch (e: Exception) { null }
            main.post { done(result) }
        }
    }

    fun download(url: String): ByteArray {
        val c = URL(url).openConnection() as HttpURLConnection
        c.connectTimeout = 10_000
        c.readTimeout = 15_000
        try {
            if (c.responseCode !in 200..299) error("HTTP ${c.responseCode}")
            return c.inputStream.use { it.readBytes() }
        } finally {
            c.disconnect()
        }
    }

    /** Same JSON as v1: [{ "appIconStr", "appDescription", "url" }, ...]. Broken items are skipped. */
    fun parseAds(json: String): Array<MyAd> {
        val arr = JSONArray(json)
        return (0 until arr.length()).mapNotNull { i ->
            val o = arr.optJSONObject(i) ?: return@mapNotNull null
            val url = o.optString("url")
            if (url.isBlank()) null else MyAd(o.optString("appIconStr"), o.optString("appDescription"), url)
        }.toTypedArray()
    }
}

internal object Icons {
    private val cache = LruCache<String, Bitmap>(32)

    /** Icons are shown at 96dp at most, so shrink big images to about 256px. */
    private fun decode(bytes: ByteArray): Bitmap? {
        val o = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size, o)
        var sample = 1
        while (maxOf(o.outWidth, o.outHeight) / (sample * 2) >= 256) sample *= 2
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size, BitmapFactory.Options().apply { inSampleSize = sample })
    }

    fun show(ad: MyAd, view: ImageView) {
        val src = ad.appIconStr
        if (src.isNullOrBlank()) {
            if (ad.appIcon != 0) view.setImageResource(ad.appIcon) else view.setImageResource(android.R.drawable.sym_def_app_icon)
            return
        }
        view.tag = src
        cache.get(src)?.let { view.setImageBitmap(it); return }
        if (ad.appIcon != 0) view.setImageResource(ad.appIcon) else view.setImageResource(android.R.drawable.sym_def_app_icon)
        Bg.run({ decode(Bg.download(src)) }) { bmp ->
            if (bmp != null) {
                cache.put(src, bmp)
                if (view.tag == src) view.setImageBitmap(bmp)
            }
        }
    }
}

/** Colors taken from the host app's theme, so ads match light and dark mode. */
internal class Palette(context: Context) {
    val background = context.attrColor(android.R.attr.colorBackground, Color.WHITE)
    val primary = context.attrColor(androidx.appcompat.R.attr.colorPrimary, Color.parseColor("#6750A4"))
    val text = context.attrColor(android.R.attr.textColorPrimary, Color.BLACK)
    val textSecondary = context.attrColor(android.R.attr.textColorSecondary, Color.DKGRAY)
    val surface = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(primary, 0x1F), background)
    val onPrimary = if (ColorUtils.calculateLuminance(primary) > 0.5) Color.BLACK else Color.WHITE

    private fun Context.attrColor(attr: Int, fallback: Int): Int {
        val tv = TypedValue()
        if (!theme.resolveAttribute(attr, tv, true)) return fallback
        return if (tv.resourceId != 0) ContextCompat.getColor(this, tv.resourceId) else tv.data
    }
}

internal fun Context.dp(v: Int) = (v * resources.displayMetrics.density).toInt()

internal fun rounded(color: Int, radiusPx: Int) = GradientDrawable().apply {
    setColor(color)
    cornerRadius = radiusPx.toFloat()
}

internal fun View.clipRound(radiusPx: Int) {
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) =
            outline.setRoundRect(0, 0, view.width, view.height, radiusPx.toFloat())
    }
    clipToOutline = true
}

internal fun Context.openLink(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    if (this !is Activity) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // ponytail: no browser installed, nothing useful to do
    }
}
