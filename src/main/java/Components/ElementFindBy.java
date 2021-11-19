package Components;

import Browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ElementFindBy  {
    WebDriver driver;
    public ElementFindBy(WebDriver driver){
        this.driver = driver;
    }
    public By findBy(String element) throws IOException, Exception {
        By by;
        ObjectRepoLoader loader = new ObjectRepoLoader();
        loader.loadProperties();
        String elementValue = loader.getProperty(element);
        String findBy = elementValue.split(":")[0];
        String findByValue = elementValue.split(":")[1];
        if(findBy.equalsIgnoreCase("xpath")){
            by = By.xpath(findByValue);
        }else if (findBy.equalsIgnoreCase("id")){
            by = By.id(findByValue);
        }else if (findBy.equalsIgnoreCase("name")) {
            by = By.name(findByValue);
        }else if (findBy.equalsIgnoreCase("css")) {
            by = By.cssSelector(findByValue);
        }
        else{
            throw new Exception("Invalid Locator type/value");
        }
        return by;
    }
    public WebElement findElementBy(String element)throws Exception{
       By by= findBy(element);
       return driver.findElement(by);
    }
}
