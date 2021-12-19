package Components;

import Browser.DriverManager;
import Properties.PropertiesLoader;
import Properties.PropertiesValidator;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestActions implements ITestListener {
    public ThreadLocal<WebDriver> Driver = new ThreadLocal<>();
    public static DriverManager driverManager;
    public static BaseActions pageActions;

    @BeforeSuite
    public void setUpEnvironment()throws Exception{
       PropertiesLoader.environment = System.getProperty("envName");
       PropertiesLoader.initializeProperties();
       PropertiesValidator.validateConfigurations();
       driverManager = new DriverManager();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser()throws Exception{
        driverManager.loadDriver();
       // Driver = driverManager.getDriver(); // for single thread
        Driver.set(driverManager.getDriver()); // for multiple threads
        pageActions = new BaseActions(Driver.get());
        pageActions.launchURL(PropertiesLoader.appUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser()throws Exception{
        driverManager.closeBrowser();
    }

    @AfterSuite
    public void tearDownObject()throws Exception{
        PropertiesLoader.configProperties = null;
    }

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult result){
        ExtentTestManager.StartTest(getTestMethodName(result),"");
        ExtentTestManager.getTest().setDescription(result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result){
        try{
            String base64 = BaseActions.captureScreenshot(getTestMethodName(result), Driver.get());
            ExtentTestManager.getTest().log(LogStatus.PASS,
                    ExtentTestManager.getTest().addBase64ScreenShot(base64));
            ExtentTestManager.getTest().log(LogStatus.PASS,"Test passed");
        }catch(Exception e){

        }
    }

    public void onTestFailure(ITestResult result){
        try{
            String base64 = BaseActions.captureScreenshot(getTestMethodName(result), Driver.get());
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Test failed");
            ExtentTestManager.getTest().log(LogStatus.FAIL,
                    ExtentTestManager.getTest().addBase64ScreenShot(base64));
        }catch(Exception e){

        }
    }

    public void onTestSkipped(ITestResult result){
        ExtentTestManager.getTest().log(LogStatus.SKIP,"Test skipped");
    }

    public void onFinish(ITestContext context){
        ExtentReporter.getReporter().flush();
    }

}
