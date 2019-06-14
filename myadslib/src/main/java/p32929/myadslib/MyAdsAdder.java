package p32929.myadslib;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Random;

public class MyAdsAdder {
    MyAds myAds[];

    public MyAdsAdder(MyAds... myAds) {
        this.myAds = myAds;
    }

    private void addAd(Context context, LinearLayout linearLayout) {
        Random rand = new Random();
        int i = rand.nextInt(myAds.length);

    }
}
