package Helpers;

import org.testng.Assert;

public class TestAsserts {
    public static void checkIfValuesAreEquals(String value1, String value2){
        Assert.assertEquals(value1, value2,"Value["+value1+"] and value2 ["+value2+"]");
    }

    public static void checkIfContains(String valueToCheck, String value){
        Assert.assertTrue(value.contains(valueToCheck),"Value["+value+"] not found");
    }
}
