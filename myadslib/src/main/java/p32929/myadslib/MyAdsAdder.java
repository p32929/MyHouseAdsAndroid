package p32929.myadslib;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Random;

public class MyAdsAdder {
    MyAds myAds[];

    public MyAdsAdder(MyAds... myAds) {
        this.myAds = myAds;
    }

    public void addAd(Context context, LinearLayout linearLayout) {
        Random random = new Random();
        int randomNumber = random.nextInt(myAds.length);
        MyAdsView myAdsView = new MyAdsView(context);
        myAdsView.setValues(
                myAds[randomNumber].getAppIcon(), myAds[randomNumber].getAppDescription(), myAds[randomNumber].getUrl()
        );
        linearLayout.addView(myAdsView);
    }
}
