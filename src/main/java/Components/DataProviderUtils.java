package Components;

import Properties.PropertiesLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProviderUtils {
    @DataProvider(name="jsonDataProvider")
    public static Object[][] getJsonTestData(Method method)throws Exception{
        String testCaseName = method.getName();
        DataProviderArgs args = method.getAnnotation(DataProviderArgs.class);
        String testCaseArguments = args.value();
        String testDataName = testCaseArguments.split("=")[0];
        String testDataFields = testCaseArguments.split("=")[1];

        List<String> allTestFields = Arrays.asList(testDataFields.split(","));

        File testDataFile = new File(System.getProperty("user.dir")+"//src//test//resources//TestData-"+PropertiesLoader.environment+".json");
        FileReader fis = new FileReader(testDataFile);
        // create the instance of JSON parser file, that is responsible for parsing file into JSON
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fis);

        JSONObject testCase = (JSONObject)obj;
        JSONArray testArray = (JSONArray) testCase.get(testDataName);
        List<List<String>> listOfList = new ArrayList<>();
        for(int i =0;i<testArray.size();i++){
            List<String> valueFromFields = new ArrayList<String>();
            JSONObject subset = (JSONObject) testArray.get(i);// located sub

            for(int j=0; j< allTestFields.size();j++){
                valueFromFields.add(subset.get(allTestFields.get(j)).toString());
            }

            listOfList.add(valueFromFields);

        }
        return parseListObjectArray(listOfList);
    }
    public static Object[][] parseListObjectArray(List<List<String>>testData){
        Object [][] TwoArray = new Object[testData.size()][testData.get(0).size()];
        for(int i = 0; i< testData.size();i++){
            List<String> subset = testData.get(i);
            for(int j=0;j< subset.size();j++){
                TwoArray[i][j] = subset.get(j);
            }
        }
        return TwoArray;
    }
}
