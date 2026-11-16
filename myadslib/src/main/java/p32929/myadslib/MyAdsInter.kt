package p32929.myadslib

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView

/** The interstitial: a centered card with a big icon, the text, "Get it" and "Later" (or "Exit"). */
class MyAdsInter(context: Context, myAd: MyAd, finish: Boolean) {

    init {
        val activity = context as? Activity
        if (activity != null && !activity.isFinishing) show(activity, myAd, finish)
    }

    private fun show(activity: Activity, ad: MyAd, finish: Boolean) {
        val p = Palette(activity)
        val view = LayoutInflater.from(activity).inflate(R.layout.my_inter_ads, null)
        val dialog = Dialog(activity).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(view)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        view.background = rounded(p.background, activity.dp(28))

        view.findViewById<TextView>(R.id.adLabel).setTextColor(p.primary)
        view.findViewById<ImageView>(R.id.appIcon).apply {
            clipRound(activity.dp(24))
            Icons.show(ad, this)
        }
        view.findViewById<TextView>(R.id.adText).apply {
            text = ad.appDescription
            setTextColor(p.text)
        }
        view.findViewById<TextView>(R.id.adButton).apply {
            setTextColor(p.onPrimary)
            background = rounded(p.primary, activity.dp(50))
            setOnClickListener {
                dialog.dismiss()
                activity.openLink(ad.url)
            }
        }
        view.findViewById<TextView>(R.id.adClose).apply {
            setText(if (finish) R.string.myads_exit else R.string.myads_later)
            setTextColor(p.primary)
            setOnClickListener {
                dialog.dismiss()
                if (finish) activity.finish()
            }
        }
        dialog.show()
        val width = (activity.resources.displayMetrics.widthPixels * 0.86f).toInt()
        dialog.window?.setLayout(minOf(width, activity.dp(420)), ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}
