package Properties;

import javax.naming.ConfigurationException;

import static Properties.PropertiesLoader.*;

public class PropertiesValidator {

    public static void validateConfigurations() throws  Exception{
        if(runOnBrowser.equalsIgnoreCase("chrome")){
            if(chromeDriverPath.isEmpty()){
                throw new ConfigurationException("Chrome path is empty");
            }
        }
        if(runOnBrowser.equalsIgnoreCase("Firefox")){
            if(firefoxDriverPath.isEmpty()){
                throw new ConfigurationException("Firefox path is empty");
            }
        }
        if(runOnBrowser.equalsIgnoreCase("Edge")){
            if(edgeDriverPath.isEmpty()){
                throw new ConfigurationException("Edge path is empty");
            }
        }
        else if(runOnBrowser.equalsIgnoreCase("IE")){
            if(ieDriverPath.isEmpty()){
                throw new ConfigurationException("IE path is empty");
            }
        }
    }
}
