# MyHouseAdsAndroid

Promote your own Android apps inside your own Android apps. MyHouseAdsAndroid shows a small banner and a full interstitial for your other apps, loaded from a JSON file you host or from a list in your code. No ad network, no account, no revenue share.

Each time an ad is shown, the next app in your list is used, so all your apps get their turn. The ads take their colors from your app's theme, so they look right in light and dark mode.

## Screenshots

| Light | Dark |
|---|---|
| ![Light](docs/screenshots/light.png) | ![Dark](docs/screenshots/dark.png) |

## Features

1. **Banner ad:** your app's icon, a short line of text and a "Get" button. Tapping it opens your link.
2. **Interstitial ad:** a centered card with a big icon, "Get it" and "Later".
3. **Ad on back press:** the close button says "Exit" and closes the screen, so the ad never traps your users.
4. **Two ways to feed it:** a JSON file at any URL, or `MyAd` items in code.
5. **Follows your theme:** uses your app's primary color and background, in light and dark mode.
6. **Small:** no image or network library is added to your app.

## Install

Add JitPack to `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

Add the dependency:

```kotlin
dependencies {
    implementation("com.github.p32929:MyHouseAdsAndroid:2.0.0")
}
```

Requires Android 5.0 (API 21) or newer. Your app's theme should be an AppCompat or Material theme.

## The JSON file

Host a JSON file anywhere (GitHub, a Gist, your own server). The format is the same as in version 1. See [docs/sample-ads.json](docs/sample-ads.json).

```json
[
  {
    "appIconStr": "https://example.com/icon.png",
    "appDescription": "My App - what it does in a few words",
    "url": "https://play.google.com/store/apps/details?id=com.example.myapp"
  }
]
```

## How to use

Kotlin:

```kotlin
// Banner goes into this LinearLayout. Pass null if you only want interstitials.
val ads = MyAdsAdder(this, linearLayout, "https://example.com/house_ads.json")

// Or from code
val ads = MyAdsAdder(
    this, linearLayout,
    MyAd("https://example.com/icon.png", "My App - what it does", "https://example.com/myapp"),
    MyAd(R.drawable.other_icon, "Other App - what it does", "https://example.com/other"),
)

// Show an interstitial anywhere
ads.showInterAd(this, false)

// Show one when the user presses back. Returns false if no ads are loaded yet.
onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
    override fun handleOnBackPressed() {
        if (!ads.showInterAd(this@MainActivity, true)) {
            isEnabled = false
            onBackPressedDispatcher.onBackPressed()
        }
    }
})
```

Java:

```java
MyAdsAdder ads = new MyAdsAdder(this, linearLayout, "https://example.com/house_ads.json");

ads.showInterAd(this, false);
```

## Migrating from 1.x

1. The class and method names are the same: `MyAdsAdder`, `MyAd`, `showInterAd`. Most apps only need the new version number.
2. The library is now in Kotlin and uses AndroidX. Your app must use AndroidX, not the old support library.
3. The minimum Android version is now 5.0 (API 21).
4. If the JSON can't be loaded, the library no longer shows a Toast to your users. It writes a warning to Logcat (tag `MyHouseAds`).
5. `JsonObjectGetter`, `JsonObjectGetListener` and `FayazSP` are removed. They were helpers inside the library.
6. Picasso is no longer a dependency. Icons are loaded by the library itself.
7. `MyAdsAdder(context, layout, ads...)` now also works with icon URLs, not only drawables.

If you want rotating banners and a rating dialog too, see the sibling library [HouseAds2](https://github.com/p32929/HouseAds2).

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

If this saved you time, you can buy me a coffee — it keeps these projects maintained and free. Other payment options: https://p32929.github.io/SendMoney2MeV1/

[![Buy Me A Coffee](https://img.shields.io/badge/Buy%20me%20a%20coffee-%E2%98%95-FFDD00?style=for-the-badge&logo=buymeacoffee&logoColor=black)](https://www.buymeacoffee.com/p32929)

<!-- hire-block -->

---

## 💼 Using this at a company?

I do fixed-price delivery work on my own projects. One invoice, one date, no hourly billing:

| | |
|---|---|
| **White-label build** — this project rebranded, extended and deployed as yours | **$6,500** · 3 weeks |
| **Custom app from scratch** on my own stack, signed and auto-updating | **$12,500** · 6 weeks |
| **Production-hardening sprint** — 72 hours on this project, for your load and your security review | **$999** |
| **Ongoing capacity** — one project-week of my time reserved every month | **$9,000 / month** |

Full details → **[p32929.github.io/hire](https://p32929.github.io/hire/)** · Email **[fayazdevinbox@uberip.com](mailto:fayazdevinbox@uberip.com)** — scoping and quotes are free and I answer within one business day.
