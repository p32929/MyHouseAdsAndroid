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
                new MyAds(R.mipmap.ic_launcher, "Hello1", "https://www.google.com/"),
                new MyAds(R.mipmap.ic_launcher, "Hello2", "https://www.google.com/"),
                new MyAds(R.mipmap.ic_launcher, "Hello3", "https://www.google.com/")
        );
        myAdsAdder.addAd(this, linearLayout);
    }
}
