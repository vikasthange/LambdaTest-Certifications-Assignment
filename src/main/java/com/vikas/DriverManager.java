package com.vikas;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver driver(){
        return driver.get();
    }
    public void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
    }
    public void initDriver(String url, String ltUserName, String ltToken, Map<String,String> caps){

        // Question: Ensure that network logs, video recording, screenshots, & console
        // logs are enabled through the desired capabilities generator.

        // Question: TimeOut of the test duration should be set to 20 seconds (for both the test scenarios). Parallelism should be at the Class Level (i.e., both the tests should be executing in parallel on LambdaTest).
    }
}
