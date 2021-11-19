package Browser;

import Properties.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class DriverManager {
  public static WebDriver Driver;
    public WebDriver getDriver(){
        return Driver;
    }
    public void setDriver(WebDriver Driver){
        this.Driver = Driver;
    }
    public void loadDriver(){
        browser Browser = null;
        String path="";
        if(PropertiesLoader.runOnBrowser.equalsIgnoreCase("Chrome")){
            Browser = new Chrome();// Runtime polymorphism
            path = PropertiesLoader.chromeDriverPath;
        }
        //else if(PropertiesLoader.runOnBrowser.equalsIgnoreCase("Firefox")){
            //Browser = new Firefox();// Runtime polymorphism
            //path = PropertiesLoader.firefoxDriverPath;
       // }
        Browser.setHeadless(PropertiesLoader.headless);
        Browser.setRemote(PropertiesLoader.remoteRun);
        Browser.setMaximized(PropertiesLoader.maximizeMode);
        Browser.setPageLoadTimeout(PropertiesLoader.pageLoadWait);
        Browser.setPreferences();
        WebDriver driver = Browser.loadBrowser(path);
        setDriver(driver);
    }
    public void closeBrowser(){
        Driver.close();
    }
    public void closeAllBrowser(){
        Driver.quit();
    }
}
