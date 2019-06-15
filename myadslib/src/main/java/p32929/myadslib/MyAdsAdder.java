package p32929.myadslib;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MyAdsAdder {
    private MyAd myAds[];
    private int aNumber = 0;
    MyAdsInter myAdsInter;

    //
    private String theNumber = "theNumber";
    private SharedPreferences sharedPreferences;

    public MyAdsAdder(final Context context, final LinearLayout linearLayout, MyAd... myAds) {
        this.myAds = myAds;
        spInit(context);

        MyAdsView myAdsView = new MyAdsView(context);
        myAdsView.setValues(
                myAds[aNumber].getAppIcon(), myAds[aNumber].getAppDescription(), myAds[aNumber].getUrl()
        );
        linearLayout.addView(myAdsView);
        setaNumber();
    }

    public MyAdsAdder(final Context context, final LinearLayout linearLayout, String url) {
        spInit(context);
        new JsonObjectGetter(context, url, new JsonObjectGetListener() {
            @Override
            public void onSuccess(MyAd[] myAds) {
                MyAdsAdder.this.myAds = myAds;
                MyAdsView myAdsView = new MyAdsView(context);
                myAdsView.setValues(
                        myAds[aNumber].getAppIconStr(), myAds[aNumber].getAppDescription(), myAds[aNumber].getUrl()
                );
                linearLayout.addView(myAdsView);
                setaNumber();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
            }
        }).execute();
    }

    public boolean showInterAd(Context context, boolean finish) {
        if (myAds != null) {
            myAdsInter = new MyAdsInter(context, myAds[aNumber], finish);
            setaNumber();
            return true;
        }
        return false;
    }

    private void spInit(Context context) {
        FayazSP.init(context);
        aNumber = FayazSP.getInt(theNumber, 0);
    }

    private void setaNumber() {
        aNumber++;
        if (aNumber == myAds.length) {
            aNumber = 0;
        }
        FayazSP.put(theNumber, aNumber);
    }
}
