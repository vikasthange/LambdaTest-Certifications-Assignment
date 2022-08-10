package com.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AssignmentTest{

    public static void main(String[] args) {
        System.out.println("Hi");
        
    }
    @Test(dataProvider = "OS_Browsers_Data_Factory")
    public void test1(String browserName,String browserVersion,String osName){
        Assert.assertTrue(true);
    }
    
    @DataProvider(name="OS_Browsers_Data_Factory")
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