import Browser.DriverManager;
import Components.ElementFindBy;
import Properties.PropertiesLoader;
import Properties.PropertiesValidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void loadBrowserTest() throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        DriverManager driverManager = new DriverManager();
        driverManager.loadDriver();
        Thread.sleep(5000);
        DriverManager.Driver.get("http://www.google.com");
        Thread.sleep(3000);
        ElementFindBy findBy = new ElementFindBy(DriverManager.Driver);
       WebElement element = findBy.findElementBy("GooglePage.tbx_search");
       element.sendKeys("Salman pictures");
       Thread.sleep(3000);
        driverManager.closeAllBrowser();
    }
}
