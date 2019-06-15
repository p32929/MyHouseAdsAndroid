package p32929.myadslibapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import p32929.myadslib.MyAds;
import p32929.myadslib.MyAdsAdder;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    MyAdsAdder myAdsAdder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.layout);
        myAdsAdder = new MyAdsAdder(
                new MyAds(R.drawable.cgpa, "CGPA Calculator", "https://play.google.com/store/apps/details?id=p32929.cgpa_calculator2"),
                new MyAds(R.drawable.desplash, "Automatic Unsplash Wallpapers", "https://play.google.com/store/apps/details?id=p32929.desplash"),
                new MyAds(R.drawable.postman, "The Great REST API Client", "https://play.google.com/store/apps/details?id=p32929.greatpostman"),
                new MyAds(R.drawable.sleepy, "Best Phone Addiction Conroller", "https://play.google.com/store/apps/details?id=p32929.lazyphone"),
                new MyAds(R.drawable.sleepy, "Google Play APK Downloader", "https://github.com/p32929/EasyGooglePlayDownloader/releases/download/1.0.0.8/EasyGooglePlayDownloader-1.0.0.8.apk")
        );
        myAdsAdder.addAd(this, linearLayout);
    }
}
