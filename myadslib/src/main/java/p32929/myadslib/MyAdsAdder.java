package p32929.myadslib;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Random;

public class MyAdsAdder {
    private MyAd myAds[];
    private Random random = new Random();
    private int randomNumber;
    MyAdsInter myAdsInter;

    public MyAdsAdder(MyAd... myAds) {
        this.myAds = myAds;
    }

    public void addAd(Context context, LinearLayout linearLayout) {
        randomNumber = random.nextInt(myAds.length);
        MyAdsView myAdsView = new MyAdsView(context);
        myAdsView.setValues(
                myAds[randomNumber].getAppIcon(), myAds[randomNumber].getAppDescription(), myAds[randomNumber].getUrl()
        );
        linearLayout.addView(myAdsView);
    }

    public void showInterAd(Context context) {
        randomNumber = random.nextInt(myAds.length);
        myAdsInter = new MyAdsInter(context, myAds[randomNumber]);
    }
}
