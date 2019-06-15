package p32929.myadslib;

import p32929.myadslib.MyAd;

public interface JsonObjectGetListener {
    void onUpdateAvailable(MyAd[] myAds);

    void onError(String error);
}
