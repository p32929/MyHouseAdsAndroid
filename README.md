# MyHouseAdsAndroid

A library (V1) for cross-promoting your own Android apps inside your own Android apps — banner and interstitial house ads, loaded from a JSON file you host or from a hardcoded list. No ad network involved.

A newer and better version of this library can be found here: https://github.com/p32929/HouseAds2

## Features

- **Banner and interstitial house ads** — your apps, your icons, your Play Store links
- **Two ways to feed it** — a JSON URL you control, or `MyAd` objects straight in code
- **Interstitial on back press** — one override, and it falls through to normal back when there's nothing to show
- **No third-party ad SDK** and no revenue share

## Screenshots:
### Banner Ad:

![Screenshot_2019-06-15-19-47-55](https://user-images.githubusercontent.com/6418354/59552318-2daaf600-8fa7-11e9-84eb-1c322fb51344.png)

### Interstitial ad on any button press:

![Screenshot_2019-06-17-10-09-33](https://user-images.githubusercontent.com/6418354/59578030-16275680-90e8-11e9-8e05-7f4b0c75e6df.png)

### Interstitial ad on back press:

![Screenshot_2019-06-17-10-07-54](https://user-images.githubusercontent.com/6418354/59577985-e24c3100-90e7-11e9-828f-1dc0a1a7e389.png)

## Installation
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```gradle
dependencies {
     implementation 'com.github.p32929:MyHouseAdsAndroid:1.0.2'
}
```

## How to use
### Code Example:

Adding ads data:
```java
MyAdsAdder myAdsAdder = new MyAdsAdder(
                this, linearLayout,
                "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/HouseAdsJson/house_ads.json"
);
```

or
```java
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

```java
myAdsAdder.showInterAd(this, false);
```

To show interstitial ads on back press:

```java
@Override
public void onBackPressed() {
    if (!myAdsAdder.showInterAd(this, true)) {
        super.onBackPressed();
    }
}
```

## License

MIT License — Copyright (c) 2019 Fayaz Bin Salam. See [LICENSE](LICENSE) for the full text.

## Contributing

Contributions are warmly welcomed and greatly appreciated! Whether it's a bug fix, new feature, or improvement, your input helps make this project better for everyone.

Before submitting a pull request, please:

1. Create an issue describing the feature or bug fix you'd like to work on
2. Wait for discussion and approval to ensure alignment with project goals
3. Fork the repository and create your feature branch
4. Submit your pull request with a clear description of changes

This approach helps avoid duplicate efforts and ensures smooth collaboration. Thank you for considering contributing!

## Share

Sharing this repository with your friends is just one click away from here

[![facebook](https://user-images.githubusercontent.com/6418354/179013321-ac1d1452-0689-493f-9066-940cf2302b6e.png)](https://www.facebook.com/sharer/sharer.php?u=https://github.com/p32929/MyHouseAdsAndroid/)
[![twitter](https://user-images.githubusercontent.com/6418354/179013351-7d8d6d1c-4ce2-46ab-bef8-4c4765a1b888.png)](https://twitter.com/intent/tweet?url=https://github.com/p32929/MyHouseAdsAndroid/)
[![tumblr](https://user-images.githubusercontent.com/6418354/179013343-3111f55a-3b90-40c7-8487-9777348672b0.png)](https://www.tumblr.com/share?v=3&u=https://github.com/p32929/MyHouseAdsAndroid/)
[![pocket](https://user-images.githubusercontent.com/6418354/179013334-b095c45f-becf-49f4-9ee1-5a731a9b1f85.png)](https://getpocket.com/save?url=https://github.com/p32929/MyHouseAdsAndroid/)
[![pinterest](https://user-images.githubusercontent.com/6418354/179013331-44cd9206-11b1-4b65-becb-5863b61c828f.png)](https://pinterest.com/pin/create/button/?url=https://github.com/p32929/MyHouseAdsAndroid/)
[![reddit](https://user-images.githubusercontent.com/6418354/179013338-7416ae3f-73ba-4522-86e1-1374d7082d22.png)](https://www.reddit.com/submit?url=https://github.com/p32929/MyHouseAdsAndroid/)
[![linkedin](https://user-images.githubusercontent.com/6418354/179013327-ca7b7102-1da8-4b1c-858f-1a6e5f21bd70.png)](https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/p32929/MyHouseAdsAndroid/)
[![whatsapp](https://user-images.githubusercontent.com/6418354/179013353-f477fa0b-3e6f-4138-a357-c9991b23ff88.png)](https://api.whatsapp.com/send?text=https://github.com/p32929/MyHouseAdsAndroid/)

---

## Support

If this saved you time, you can buy me a coffee — it keeps these projects maintained and free. Other payment options: https://p32929.github.io/SendMoney2Me/

[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20me%20a%20coffee-%E2%98%95-FFDD00?style=for-the-badge&logo=buymeacoffee&logoColor=black)](https://www.buymeacoffee.com/p32929)

<!-- hire-block -->

---

## 💼 Need this customised — or need it yesterday?

I take fixed-price native Android work on my own projects. No hourly billing, no surprise scope:

| | |
|---|---|
| **Drop-in integration** — I wire this into your codebase and hand you a PR that builds | **$45** · 3 days |
| **Priority bug fix or small feature** — jumps ahead of the free issue queue | **$95** · 72 hours |
| **Custom build** — branded, packaged and deployed, source yours | **$130** · 7 days |
| **A full app from scratch** | **from $350** · quoted first |

All prices and how to buy → **[p32929.github.io/hire](https://p32929.github.io/hire/)**  
Or buy through [Fiverr](https://www.fiverr.com/fayazbinsalam) (escrow, ID-verified, 5.0★) — safest for a first job.

Scoping and quotes are free: [open an issue](https://github.com/p32929/hire/issues/new) and describe the job.
