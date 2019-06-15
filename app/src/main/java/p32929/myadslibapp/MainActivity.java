package p32929.myadslibapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

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
}
