package p32929.myadslib

/** One app to promote: an icon (drawable or image URL), a short text and the link to open. */
class MyAd {
    var appIcon: Int = 0
    var appIconStr: String? = null
    var appDescription: String
    var url: String

    constructor(appIcon: Int, appDescription: String, url: String) : this(appIcon, null, appDescription, url)

    constructor(appIconStr: String, appDescription: String, url: String) : this(0, appIconStr, appDescription, url)

    constructor(appIcon: Int, appIconStr: String?, appDescription: String, url: String) {
        this.appIcon = appIcon
        this.appIconStr = appIconStr
        this.appDescription = appDescription
        this.url = url
    }
}
