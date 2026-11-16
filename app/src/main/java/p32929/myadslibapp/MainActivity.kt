package p32929.myadslibapp

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import p32929.myadslib.MyAd
import p32929.myadslib.MyAdsAdder

class MainActivity : AppCompatActivity() {

    private lateinit var ads: MyAdsAdder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adsLayout = findViewById<LinearLayout>(R.id.adsLayout)

        // From a JSON file you host (same format as docs/sample-ads.json):
        // ads = MyAdsAdder(this, adsLayout, "https://raw.githubusercontent.com/p32929/MyHouseAdsAndroid/master/docs/sample-ads.json")

        // Or straight from code:
        ads = MyAdsAdder(
            this, adsLayout,
            MyAd("$ICONS/put-phone-down/icon.png", "Put Phone Down - lock your phone and rest", "$STORE/put-phone-down"),
            MyAd("$ICONS/the-great-postman/icon.png", "The Great Postman - REST API client", "$STORE/the-great-postman"),
            MyAd("$ICONS/desplash/icon.png", "Desplash - fresh HD wallpapers", "$STORE/desplash"),
            MyAd("$ICONS/cgpa-calculator/icon.png", "CGPA Calculator - fast and offline", "$STORE/cgpa-calculator"),
            MyAd("$ICONS/animal-lover/icon-new.png", "Animal Lover - 580+ animals to explore", "$STORE/animal-lover"),
        )

        findViewById<android.view.View>(R.id.showInter).setOnClickListener { ads.showInterAd(this, false) }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!ads.showInterAd(this@MainActivity, true)) {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

    private companion object {
        const val ICONS = "https://raw.githubusercontent.com/p32929/p32929_openstore/main/screenshots"
        const val STORE = "https://openstore.pfay.workers.dev/app/p32929"
    }
}
