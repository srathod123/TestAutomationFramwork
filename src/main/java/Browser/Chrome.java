package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Chrome extends browser {
    ChromeOptions options;

    @Override
    public void setPreferences() {
        options = new ChromeOptions();

        if (isHeadless()) {
            options.setHeadless(true);
        }

        if (isMaximized()) {
            options.addArguments("start-maximized");
        }

    }

    @Override
    public WebDriver loadBrowser(String Path) {
        WebDriver Driver = null;
        System.setProperty("webdriver.chrome.driver", Path);
        if (isRemote()) {
            try {
                Driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Driver = new ChromeDriver(options);
            Driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            Driver.manage().deleteAllCookies();
            if (isDeleteAllCookies()) {
                Driver.manage().deleteAllCookies();
            }
        }
        return Driver;
    }
}
