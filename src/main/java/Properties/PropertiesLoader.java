package Properties;

import javax.naming.ConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {
        public static Properties configProperties;
        public static String extendReportPath;
        public static String runOnBrowser;
        public static Boolean takeScreenshot;
        public static String chromeDriverPath;
        public static String ieDriverPath;
        public static String edgeDriverPath;
        public static String firefoxDriverPath;
        public static Boolean maximizeMode;
        public static Boolean minimizeMode;
        public static Integer implicitWait;
        public static Integer explicitWait;
        public static Integer pageLoadWait;
        public static Boolean headless;
        public static Boolean deleteAllCookies;
        public static Boolean remoteRun;
        public static String appUrl;
        public static String environment;

        public static void initializeProperties() throws Exception{
            if(configProperties == null){
                configProperties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//Config-"+PropertiesLoader.environment+".Properties"));
                System.out.println("Environment Initialized:" + environment);
                configProperties.load(fileInputStream);
            }
            runOnBrowser = configProperties.getProperty("RunOnBrowser");
            takeScreenshot= Boolean.valueOf (configProperties.getProperty("TakeScreenshot"));
            chromeDriverPath= configProperties.getProperty("ChromeDriverPath");
            ieDriverPath = configProperties.getProperty("IEDriverPath");
            edgeDriverPath = configProperties.getProperty("EdgeDriverPath");
            firefoxDriverPath = configProperties.getProperty("FirefoxDriverPath");
            maximizeMode = Boolean.valueOf(configProperties.getProperty("MaximizeMode"));
            minimizeMode= Boolean.valueOf(configProperties.getProperty("MinimizeMode"));
            implicitWait = Integer.valueOf(configProperties.getProperty("ImplicitWait"));
            explicitWait = Integer.valueOf(configProperties.getProperty("ExplicitWait"));
            pageLoadWait = Integer.valueOf(configProperties.getProperty("PageLoadWait"));
            headless = Boolean.valueOf(configProperties.getProperty("headless"));
            deleteAllCookies = Boolean.valueOf(configProperties.getProperty("deleteAllCookies"));
            remoteRun = Boolean.valueOf(configProperties.getProperty("remoteRun"));
            appUrl = configProperties.getProperty("appURL");
            if(environment.isEmpty())
                environment = "stg";
        }


        public static void main(String[] args) throws Exception {
            PropertiesLoader.initializeProperties();
            PropertiesValidator.validateConfigurations();
        }
    }

