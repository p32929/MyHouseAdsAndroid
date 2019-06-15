package p32929.myadslibapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import p32929.myadslib.JsonObjectGetListener;
import p32929.myadslib.MyAd;
import p32929.myadslib.MyAdsAdder;

public class MainActivity extends AppCompatActivity implements JsonObjectGetListener {

    LinearLayout linearLayout;
    MyAdsAdder myAdsAdder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.layout);

        myAdsAdder = new MyAdsAdder(
                this, linearLayout,
                "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/HouseAdsJson/house_ads.json"
        );
    }

    public void showInter(View view) {
        myAdsAdder.showInterAd(this, false);
    }

    @Override
    public void onBackPressed() {
        if (!myAdsAdder.showInterAd(this, true)) {
            super.onBackPressed();
        }
    }

    @Override
    public void onSuccess(MyAd[] myAds) {
        Toast.makeText(this, "Suc Ac", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {
        myAdsAdder = new MyAdsAdder(
                this, linearLayout,
                new MyAd(R.drawable.cgpa, "CGPA Calculator", "https://play.google.com/store/apps/details?id=p32929.cgpa_calculator2"),
                new MyAd(R.drawable.desplash, "Desplash - Automatic Unsplash Wallpapers", "https://play.google.com/store/apps/details?id=p32929.desplash"),
                new MyAd(R.drawable.postman, "The Great REST API Client", "https://play.google.com/store/apps/details?id=p32929.greatpostman"),
                new MyAd(R.drawable.sleepy, "Sleepy - Phone Addiction Conroller", "https://play.google.com/store/apps/details?id=p32929.lazyphone"),
                new MyAd(R.drawable.gpd, "Google Play APK Downloader", "https://github.com/p32929/EasyGooglePlayDownloader/releases/download/1.0.0.8/EasyGooglePlayDownloader-1.0.0.8.apk")
        );
    }
}
