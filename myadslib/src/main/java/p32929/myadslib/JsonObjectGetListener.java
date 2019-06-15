package p32929.myadslib;

public interface JsonObjectGetListener {
    void onSuccess(MyAd[] myAds);

    void onError(String error);
}
