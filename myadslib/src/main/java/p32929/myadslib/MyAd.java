package p32929.myadslib;

public class MyAd {
    private int appIcon;
    private String appIconStr;
    private String appDescription;
    private String url;

    public MyAd(int appIcon, String appDescription, String url) {
        this.appIcon = appIcon;
        this.appDescription = appDescription;
        this.url = url;
    }

    public MyAd(String appIconStr, String appDescription, String url) {
        this.appIconStr = appIconStr;
        this.appDescription = appDescription;
        this.url = url;
    }

    public MyAd(int appIcon, String appIconStr, String appDescription, String url) {
        this.appIcon = appIcon;
        this.appIconStr = appIconStr;
        this.appDescription = appDescription;
        this.url = url;
    }

    public String getAppIconStr() {
        return appIconStr;
    }

    public void setAppIconStr(String appIconStr) {
        this.appIconStr = appIconStr;
    }

    public int getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(int appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
