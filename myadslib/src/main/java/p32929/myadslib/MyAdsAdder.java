package p32929.myadslib;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MyAdsAdder {
    private MyAd myAds[];
    private Random random = new Random();
    private int randomNumber;
    MyAdsInter myAdsInter;

    public MyAdsAdder(final Context context, final LinearLayout linearLayout, MyAd... myAds) {
        this.myAds = myAds;
        randomNumber = random.nextInt(myAds.length);
        MyAdsView myAdsView = new MyAdsView(context);
        myAdsView.setValues(
                myAds[randomNumber].getAppIcon(), myAds[randomNumber].getAppDescription(), myAds[randomNumber].getUrl()
        );
        linearLayout.addView(myAdsView);
    }

    public MyAdsAdder(final Context context, String url, final LinearLayout linearLayout) {
        JsonObjectGetter jsonObjectGetter = new JsonObjectGetter(context, url, new JsonObjectGetListener() {
            @Override
            public void onUpdateAvailable(MyAd[] myAds) {
                MyAdsAdder.this.myAds = myAds;
                randomNumber = random.nextInt(myAds.length);
                MyAdsView myAdsView = new MyAdsView(context);
                myAdsView.setValues(
                        myAds[randomNumber].getAppIcon(), myAds[randomNumber].getAppDescription(), myAds[randomNumber].getUrl()
                );
                linearLayout.addView(myAdsView);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
            }
        });
        jsonObjectGetter.execute();
    }

    public void showInterAd(Context context, boolean finish) {
        randomNumber = random.nextInt(myAds.length);
        myAdsInter = new MyAdsInter(context, myAds[randomNumber], finish);
    }
}
