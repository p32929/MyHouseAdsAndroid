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

    public MyAdsAdder(final Context context, final LinearLayout linearLayout, String url) {
        new JsonObjectGetter(context, url, new JsonObjectGetListener() {
            @Override
            public void onSuccess(MyAd[] myAds) {
                MyAdsAdder.this.myAds = myAds;
                randomNumber = random.nextInt(myAds.length);
                MyAdsView myAdsView = new MyAdsView(context);
                myAdsView.setValues(
                        myAds[randomNumber].getAppIconStr(), myAds[randomNumber].getAppDescription(), myAds[randomNumber].getUrl()
                );
                linearLayout.addView(myAdsView);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
            }
        }).execute();
    }

    public boolean showInterAd(Context context, boolean finish) {
        if (myAds != null) {
            randomNumber = random.nextInt(myAds.length);
            myAdsInter = new MyAdsInter(context, myAds[randomNumber], finish);
            return true;
        }
        return false;
    }
}
