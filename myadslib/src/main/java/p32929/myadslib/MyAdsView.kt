package p32929.myadslib

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/** The banner: icon, short text and a "Get" button. Tapping anywhere opens the link. */
class MyAdsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs) {

    private val icon: ImageView
    private val text: TextView
    private var url: String? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.my_ads, this, true)
        icon = findViewById(R.id.appIcon)
        text = findViewById(R.id.adText)
        val p = Palette(context)
        background = rounded(p.surface, context.dp(20))
        text.setTextColor(p.text)
        findViewById<TextView>(R.id.adLabel).apply {
            setTextColor(p.primary)
        }
        findViewById<TextView>(R.id.adButton).apply {
            setTextColor(p.onPrimary)
            background = rounded(p.primary, context.dp(50))
        }
        icon.clipRound(context.dp(12))
        setOnClickListener { url?.let { context.openLink(it) } }
    }

    fun setValues(appIcon: Int, adText: String, url: String) = setValues(MyAd(appIcon, adText, url))

    fun setValues(appIconStr: String, adText: String, url: String) = setValues(MyAd(appIconStr, adText, url))

    fun setValues(ad: MyAd) {
        Icons.show(ad, icon)
        text.text = ad.appDescription
        url = ad.url
        contentDescription = ad.appDescription
    }
}
