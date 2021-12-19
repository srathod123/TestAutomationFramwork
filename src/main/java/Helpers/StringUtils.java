package Helpers;

import Properties.PropertiesLoader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    public static String generateFolderPath(String path){
        String str = System.getProperty("user.dir")+ File.separator + path;
        str = str + File.separator + new SimpleDateFormat("MM-DD").format(new Date());
        str = str + File.separator + new SimpleDateFormat("hh-mm-ss").format(new Date());
        PropertiesLoader.extendReportPath = str;
        return str;
    }
}
