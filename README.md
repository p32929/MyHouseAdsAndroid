## MyHouseAdsAndroid
A library for cross promoting own apps within own apps - for Android

## Screenshots:
### Banner Ad:

![Screenshot_2019-06-15-19-47-55](https://user-images.githubusercontent.com/6418354/59552318-2daaf600-8fa7-11e9-84eb-1c322fb51344.png)

### Interstitial ad on any button press:

![Screenshot_2019-06-15-19-47-59](https://user-images.githubusercontent.com/6418354/59552339-60ed8500-8fa7-11e9-8228-259d6fc07207.png)

### Interstitial ad on back press:

![Screenshot_2019-06-15-19-48-02](https://user-images.githubusercontent.com/6418354/59552344-6fd43780-8fa7-11e9-988e-f09648973286.png)

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
     implementation 'com.github.p32929:MyHouseAdsAndroid:1.0.1'
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