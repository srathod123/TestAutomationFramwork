package Components;

import Helpers.StringUtils;
import Properties.PropertiesLoader;
import com.relevantcodes.extentreports.ExtentReports;


import java.io.File;

public class ExtentReporter {
    private static ExtentReports suiteReport;
    public static synchronized ExtentReports getReporter(){
        try{
            PropertiesLoader.initializeProperties();
            if(suiteReport==null){
                String extendReportPath = "extentReports";
                extendReportPath = StringUtils.generateFolderPath(extendReportPath);
                File f = new File(extendReportPath);
                if(!f.isDirectory()){
                    f.mkdirs();
                }
                suiteReport = new ExtentReports(extendReportPath +"//TestResult.html");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return suiteReport;
    }
}
