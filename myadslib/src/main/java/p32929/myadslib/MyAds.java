package p32929.myadslib;

public class MyAds {
    private int appIcon;
    private String appDescription;
    private String url;

    public MyAds(int appIcon, String appDescription, String url) {
        this.appIcon = appIcon;
        this.appDescription = appDescription;
        this.url = url;
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
