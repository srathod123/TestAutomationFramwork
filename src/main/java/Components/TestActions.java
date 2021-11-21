package Components;

import Browser.DriverManager;
import Properties.PropertiesLoader;
import Properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestActions {
    public WebDriver Driver;
    public DriverManager driverManager;
    public BaseActions pageActions;
    @BeforeSuite
    public void setUpConfig()throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
    }

    @BeforeMethod
    public void setUpBrowser()throws Exception{
        driverManager = new DriverManager();
        driverManager.loadDriver();
        Driver = driverManager.getDriver();
        pageActions = new BaseActions(Driver);
        pageActions.launchURL(PropertiesLoader.appUrl);
    }

    @AfterMethod
    public void tearDownBrowser()throws Exception{
        driverManager.closeBrowser();
    }

    @AfterSuite
    public void tearDownObject()throws Exception{
        PropertiesLoader.configProperties = null;
    }
}
