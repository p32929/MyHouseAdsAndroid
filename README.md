## MyHouseAdsAndroid
A library for cross promoting own apps within own apps - for Android

A newer and better version of this library can be found here: https://github.com/p32929/HouseAds2

[![](https://badgen.net/github/release/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/release/p32929/MyHouseAdsAndroid/stable)]() [![](https://badgen.net/github/tag/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/watchers/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/checks/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/status/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/stars/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/forks/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/issues/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/open-issues/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/closed-issues/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/label-issues/p32929/MyHouseAdsAndroid/help-wanted/open)]() [![](https://badgen.net/github/prs/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/open-prs/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/closed-prs/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/merged-prs/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/commits/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/last-commit/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/branches/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/releases/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/tags/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/license/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/contributors/p32929/MyHouseAdsAndroid)]() [![](https://badgen.net/github/dependents-pkg/p32929/MyHouseAdsAndroid)]() 

## Share
Sharing with your friends is just one click away from here

[![facebook](https://image.flaticon.com/icons/png/32/124/124010.png)](https://www.facebook.com/sharer/sharer.php?u=https://github.com/p32929/MyHouseAdsAndroid)
[![twitter](https://image.flaticon.com/icons/png/32/124/124021.png)](https://twitter.com/intent/tweet?source=https://github.com/p32929/MyHouseAdsAndroid)
[![tumblr](https://image.flaticon.com/icons/png/32/124/124012.png)](https://www.tumblr.com/share?v=3&u=https://github.com/p32929/MyHouseAdsAndroid)
[![pocket](https://image.flaticon.com/icons/png/32/732/732238.png)](https://getpocket.com/save?url=https://github.com/p32929/MyHouseAdsAndroid)
[![pinterest](https://image.flaticon.com/icons/png/32/124/124039.png)](https://pinterest.com/pin/create/button/?url=https://github.com/p32929/MyHouseAdsAndroid)
[![reddit](https://image.flaticon.com/icons/png/32/2111/2111589.png)](https://www.reddit.com/submit?url=https://github.com/p32929/MyHouseAdsAndroid)
[![linkedin](https://image.flaticon.com/icons/png/32/1409/1409945.png)](https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/p32929/MyHouseAdsAndroid)
[![whatsapp](https://image.flaticon.com/icons/png/32/733/733585.png)](https://api.whatsapp.com/send?text=https://github.com/p32929/MyHouseAdsAndroid)

## Support
If you like my works and want to support me/my works, feel free to support or donate. My payment details can be found here: https://p32929.github.io/SendMoney2Me/

## Screenshots:
### Banner Ad:

![Screenshot_2019-06-15-19-47-55](https://user-images.githubusercontent.com/6418354/59552318-2daaf600-8fa7-11e9-84eb-1c322fb51344.png)

### Interstitial ad on any button press:

![Screenshot_2019-06-17-10-09-33](https://user-images.githubusercontent.com/6418354/59578030-16275680-90e8-11e9-8e05-7f4b0c75e6df.png)

### Interstitial ad on back press:

![Screenshot_2019-06-17-10-07-54](https://user-images.githubusercontent.com/6418354/59577985-e24c3100-90e7-11e9-828f-1dc0a1a7e389.png)

## Installation
Add it in your root build.gradle at the end of repositories:
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```
dependencies {
     implementation 'com.github.p32929:MyHouseAdsAndroid:1.0.2'
}
```

## How to use
### Code Example:

Adding ads data:
```
MyAdsAdder myAdsAdder = new MyAdsAdder(
                this, linearLayout,
                "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/HouseAdsJson/house_ads.json"
);
```

or
```
MyAdsAdder myAdsAdder = new MyAdsAdder(
                this, linearLayout,
                new MyAd(R.drawable.cgpa, "CGPA Calculator", "https://play.google.com/store/apps/details?id=p32929.cgpa_calculator2"),
                new MyAd(R.drawable.desplash, "Desplash - Automatic Unsplash Wallpapers", "https://play.google.com/store/apps/details?id=p32929.desplash"),
                new MyAd(R.drawable.postman, "The Great REST API Client", "https://play.google.com/store/apps/details?id=p32929.greatpostman"),
                new MyAd(R.drawable.sleepy, "Sleepy - Phone Addiction Conroller", "https://play.google.com/store/apps/details?id=p32929.lazyphone"),
                new MyAd(R.drawable.gpd, "Google Play APK Downloader", "https://github.com/p32929/EasyGooglePlayDownloader/releases/download/1.0.0.8/EasyGooglePlayDownloader-1.0.0.8.apk")
);
```

To show interstitial ads anywhere:

```
myAdsAdder.showInterAd(this, false);
```

To show interstitial ads on back press:

```
@Override
public void onBackPressed() {
    if (!myAdsAdder.showInterAd(this, true)) {
        super.onBackPressed();
    }
}
```

## License
```
MIT License

Copyright (c) 2019 Fayaz Bin Salam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
