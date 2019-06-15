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
                new MyAds(R.drawable.cgpa, "CGPA Calculator", "https://www.google.com/"),
                new MyAds(R.drawable.desplash, "Automatic Unsplash Wallpapers", "https://www.google.com/"),
                new MyAds(R.drawable.postman, "The Great REST API Client", "https://www.google.com/"),
                new MyAds(R.drawable.sleepy, "Best Phone Addiction Conroller", "https://www.google.com/")
        );
        myAdsAdder.addAd(this, linearLayout);
    }
}
