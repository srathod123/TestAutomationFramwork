package Components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private static final int Max_Retry = 2;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            if(retryCount<Max_Retry){
                retryCount++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            }else{
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        }else{
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
