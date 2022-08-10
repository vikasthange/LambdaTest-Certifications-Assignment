package com.vikas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver driver(){
        return driver.get();
    }
    public static void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
    }
    public static void initDriver(DesiredCapabilities capabilities){

        
        try {
            System.out.println("Starting browser....");
            try{
                System.out.println("Hub Url: "+ Const.LT_GRID_URL);
                System.out.println("Capabilities: "+capabilities);
                
                driver.set(new RemoteWebDriver(new URL(Const.LT_GRID_URL), capabilities));
                System.out.println("Browser started....");
            }
            catch(WebDriverException e){
                System.err.println("Failed to launch browser, Please refer below error stack");
                e.printStackTrace();
                throw e;
            }
        } catch (MalformedURLException e) {
            System.err.println("Failed to launch Browser, Error: "+e.getClass().getName()+" - "+e.getMessage()+", Cause: "+ e.getCause().getClass().getName()+" - "+e.getCause().getMessage());
            e.printStackTrace();
        }
        
        // Question: TimeOut of the test duration should be set to 20 seconds (for both the test scenarios). Parallelism should be at the Class Level (i.e., both the tests should be executing in parallel on LambdaTest).
    }
    public static void closeBrowser(){
        driver.get().close();
    }
    public static void cleanUp(){
        try{
            driver.get().quit();
        }
        catch(Exception e){
            System.out.println("Already closed?..");
        }
    }
    public static void initDriver(String browserName, String browserVersion, String osName, String testName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("user", Const.getLtUsername());
        ltOptions.put("accessKey", Const.getLtToken());
        ltOptions.put("build", "Vikas Thange - Certification");

        ltOptions.put("name", testName);
        ltOptions.put("platformName", osName);

        // ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0"); // Vikas: 4.4.0 not supported right now from lambdatest
        // Question: Ensure that network logs, video recording, screenshots, & console
        // logs are enabled through the desired capabilities generator.
        ltOptions.put("visual", true);
        ltOptions.put("video", true);
        ltOptions.put("network", true);
        ltOptions.put("project", "Certification");
        ltOptions.put("console", "info");
        ltOptions.put("w3c", true);

        capabilities.setCapability("LT:Options", ltOptions);
        
        initDriver(capabilities);
    }
}
