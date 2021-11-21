package Components;

import Properties.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class ElementFindBy  {
    WebDriver driver;
    WebDriverWait wait;
    public ElementFindBy(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver,PropertiesLoader.explicitWait);
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
       return waitUntilElementVisible(by);
    }

   public List<WebElement> findElementsBy(String element)throws Exception{
        By by = findBy(element);
       return waitUntilAllElementsVisible(by);
   }

    public WebElement waitUntilElementVisible(By by)throws Exception{
      return wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
    }

    public List<WebElement> waitUntilAllElementsVisible(By by)throws Exception{
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public boolean waitUntilElementDisappear(By by)throws Exception{
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitUntilElementFound(By by)throws Exception{
      return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilClickable(By by)throws Exception{
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
