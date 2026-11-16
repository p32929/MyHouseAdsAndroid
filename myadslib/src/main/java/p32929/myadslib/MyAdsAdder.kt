package p32929.myadslib

import android.content.Context
import android.util.Log
import android.widget.LinearLayout

/**
 * Shows your own apps as a banner (added to [linearLayout]) and as an interstitial.
 * Each time an ad is shown, the next app in the list is used, so they take turns.
 */
class MyAdsAdder {
    private val prefs: android.content.SharedPreferences
    private var myAds: Array<out MyAd>? = null

    /** Ads from code. Pass null as [linearLayout] if you only want interstitials. */
    constructor(context: Context, linearLayout: LinearLayout?, vararg myAds: MyAd) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        onAds(context, linearLayout, myAds)
    }

    /** Ads from a JSON file at [url]. Same format as version 1. */
    constructor(context: Context, linearLayout: LinearLayout?, url: String) {
        prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        Bg.run({ Bg.parseAds(String(Bg.download(url))) }) { ads ->
            if (ads.isNullOrEmpty()) Log.w(TAG, "Could not load house ads from $url")
            else onAds(context, linearLayout, ads)
        }
    }

    /**
     * Shows the next app as an interstitial. Returns false if no ads are loaded yet,
     * so in onBackPressed you can fall back to the normal back action.
     * With [finish] true, the close button says "Exit" and closes the activity.
     */
    fun showInterAd(context: Context, finish: Boolean): Boolean {
        val ad = next() ?: return false
        MyAdsInter(context, ad, finish)
        return true
    }

    private fun onAds(context: Context, linearLayout: LinearLayout?, ads: Array<out MyAd>) {
        if (ads.isEmpty()) return
        myAds = ads
        if (linearLayout != null) {
            val ad = next() ?: return
            linearLayout.addView(MyAdsView(context).apply { setValues(ad) })
        }
    }

    private fun next(): MyAd? {
        val ads = myAds?.takeIf { it.isNotEmpty() } ?: return null
        val i = prefs.getInt(KEY, 0).mod(ads.size)
        prefs.edit().putInt(KEY, (i + 1) % ads.size).apply()
        return ads[i]
    }

    private companion object {
        const val PREFS = "MyAds"
        const val KEY = "theNumber"
        const val TAG = "MyHouseAds"
    }
}
