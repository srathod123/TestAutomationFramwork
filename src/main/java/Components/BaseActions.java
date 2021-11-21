package Components;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BaseActions {
    WebDriver Driver;
    public BaseActions(WebDriver Driver) {
        this.Driver = Driver;
    }

    public void ClickIt(String ElementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            elementBy.click();
        }catch (Exception e){}
    }

    public void typeTextInto(String ElementRef, String Text){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            elementBy.click();
            elementBy.clear();
            elementBy.sendKeys(Text);
        }catch (Exception e){}
    }

    public String getText(String ElementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            return elementBy.getText();
        }catch (Exception e){
            return null;
        }
    }

    public String getAttributeForElement(String ElementRef, String attributeType){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            return elementBy.getAttribute(attributeType);
        }catch (Exception e){
            return null;
        }
    }

    public void selectValueFromDropDown(String ElementRef, String selectBy,String ValueToSelect){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            Select dropDown = new Select(elementBy);
            if(selectBy.equalsIgnoreCase("visibleText")){
                dropDown.selectByVisibleText(ValueToSelect);
            }else if(selectBy.equalsIgnoreCase("value")){
                dropDown.selectByValue(ValueToSelect);
            }else if(selectBy.equalsIgnoreCase("index")){
                int index = Integer.parseInt(ValueToSelect);
                dropDown.selectByIndex(index);
            }
        }catch (Exception e){}
    }

    public void switchToSecondWindow(){
        try {
            List<String> array = new ArrayList<>(Driver.getWindowHandles());
            Driver.switchTo().window(array.get(1));
            //OR
           // Driver.switchTo().window(new ArrayList<String>(Driver.getWindowHandles()).get(1));
        }catch(Exception e){}
    }

    public void switchToLastWindow(){
        try {
            List<String> windows = new ArrayList<>(Driver.getWindowHandles());
            Driver.switchTo().window(windows.get(windows.size() - 1));
        }catch(Exception e){}
    }

    public void hitEnter(String ElementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            elementBy.sendKeys(Keys.ENTER);
        }catch(Exception e){}
    }

    public void hitTab(String ElementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            elementBy.sendKeys(Keys.TAB);
        }catch(Exception e){}
    }

    public void launchURL(String url){
        try{
            Driver.get(url);
        }catch(Exception e){}
    }

    public void refreshPage(String url){
        try{
            Driver.navigate().refresh();
        }catch(Exception e){
            new Actions(Driver).sendKeys(Keys.F5);
        }
    }

    public void switchToAlertAccept(String url){
        try{
            Driver.switchTo().alert().accept();
        }catch(Exception e){}
    }


    public void switchToAlertDismiss(String url){
        try{
            Driver.switchTo().alert().dismiss();
        }catch(Exception e){}
    }

    public void switchToFrame(String ElementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement elementBy = obj.findElementBy(ElementRef);
            Driver.switchTo().frame(ElementRef);
        }catch(Exception e){}
    }

    public void switchToOriginalPageFromIFrame(String ElementRef){
        try{
           Driver.switchTo().defaultContent();
        }catch(Exception e){}
    }

    public void scrollToTop(){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) Driver;
            jse.executeScript("window.scrollTo(-0,document.body.scrollHeight)");
        }catch (Exception e){}
    }

    public void scrollToDown(){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) Driver;
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }catch (Exception e){}
    }

    public void hoverOnTo(String elementRef){
        try{
           ElementFindBy obj = new ElementFindBy(Driver);
           WebElement elementBy = obj.findElementBy(elementRef);
           new Actions(Driver).moveToElement(elementBy).build().perform();
        }catch(Exception e){}
    }

    public void dragAndDrop(String ele1, String ele2){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement element1 = obj.findElementBy(ele1);
            WebElement element2 = obj.findElementBy(ele2);
            new Actions(Driver).dragAndDrop(element1,element2).build().perform();
        }catch(Exception e){}
    }

    public void rightClickOnElement(String elementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement element = obj.findElementBy(elementRef);
            new Actions(Driver).contextClick(element).build().perform();
        }catch(Exception e){}
    }

    public void doubleClickOnElement(String elementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement element = obj.findElementBy(elementRef);
            new Actions(Driver).doubleClick(element).build().perform();
        }catch(Exception e){}
    }

    public boolean isEnabled(String elementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement element = obj.findElementBy(elementRef);
            return element.isEnabled();
        }catch(Exception e){
            return false;
        }
    }

    public boolean isDisplayed(String elementRef){
        try{
            ElementFindBy obj = new ElementFindBy(Driver);
            WebElement element = obj.findElementBy(elementRef);
            return element.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

}
