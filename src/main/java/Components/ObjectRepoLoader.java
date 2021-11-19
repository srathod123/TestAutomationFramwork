package Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepoLoader {
   static Properties properties;
    public void loadProperties()throws IOException{
        String path = System.getProperty("user.dir")+"//src//main//resources//objectRepo.properties";
        FileInputStream fls = new FileInputStream(new File(path));
        properties = new Properties();
        properties.load(fls);
    }

    public String getProperty(String name){
        return properties.getProperty(name);
    }

    public static void main(String [] args) throws IOException{
        ObjectRepoLoader obj = new ObjectRepoLoader();
        obj.loadProperties();
        System.out.println(obj.getProperty("CardNumberPage.cardNumber"));
    }
}
