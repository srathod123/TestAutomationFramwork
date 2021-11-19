package Browser;

import org.openqa.selenium.WebDriver;

public abstract class browser {

    WebDriver Driver;
    protected boolean isHeadless;
    protected boolean isRemote;
    private boolean isMaximized;
    private Integer pageLoadTimeout;
    private  boolean deleteAllCookies;
    public abstract void setPreferences();

    public abstract WebDriver loadBrowser(String Path);

    public boolean isHeadless() {
        return isHeadless;
    }// will not work for edge

    public void setHeadless(boolean headless){
        isHeadless = headless;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote){
        isRemote = remote;
    }

    public boolean isMaximized() {
        return isMaximized;
    }

    public void setMaximized(boolean maximized) {
        isMaximized = maximized;
    }


    public Integer getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(Integer pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public boolean isDeleteAllCookies() {
        return deleteAllCookies;
    }

    public void setDeleteAllCookies(boolean deleteAllCookies) {
        this.deleteAllCookies = deleteAllCookies;
    }
}
