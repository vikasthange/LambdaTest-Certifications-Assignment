package com.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssignmentTest{
    // Question: Keep it simple
    // TimeOut of the test duration should be set to 20 seconds (for both the test scenarios). 
    @Test(dataProvider = "OS_Browsers_Data_Factory",timeOut = 20000)
    public void test1(String browserName,String browserVersion,String osName){
        
        Assert.assertTrue(true);
    }
    // Question: You must run the test on LambdaTest Cloud Selenium Grid in parallel and mention the final Test ID(s) while submitting.
    @DataProvider(name="OS_Browsers_Data_Factory",parallel = true)
    public Object[][] getTestEnvironmentParams(){

        // Question: If you are using Java and TestNG, then pass the browser and OS combinations to the test scenario(s) from testng.xml (for Java). You could also hard code the browser and OS combination in the implementation.
        // Vikas: In this assignment I am hard coding in Data provider but can be read from external source. 
        // Vikas: we get better control over test data in coding instead of using textng.xml <parameters>
        return new Object[][]{
            {"Chrome","86.0","Windows 10"},
            {"Microsoft Edge","87.0","macOS Sierra"},
        }; 
    }


}