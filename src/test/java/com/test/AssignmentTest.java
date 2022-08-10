package com.test;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.IntegrationPage;
import com.pages.LtPage;
import com.vikas.Const;
import com.vikas.DriverManager;

public class AssignmentTest{
    // Question: Keep it simple
    // TimeOut of the test duration should be set to 20 seconds (for both the test scenarios). 
    @AfterMethod
    public void cleanUp(){
        // Last step to close and quit all sessions
        DriverManager.cleanUp();
    }
    @Test(dataProvider = "OS_Browsers_Data_Factory",timeOut = Const.TIMEOUT)
    public void test1(String browserName,String browserVersion,String osName,String testName){
        
        Assert.assertTrue(true);
        DriverManager.initDriver(browserName,browserVersion,osName,testName);
        
        LtPage ltHomePage = openHomePage();
        //Navigate to https://www.lambdatest.com/.
        //Perform an explicit wait till the time all the elements in the DOMare available.
        System.out.println("Waiting for page to load..");
        ltHomePage.waitForPageToLoad();
        // Scroll and Click -> All integrations & navigate to new page
        System.out.println("Scrolling to all integrations link");
        ltHomePage.scrollToSeeAllIntegrations();
        System.out.println("Clicking all integrations link");
        ltHomePage.clickToSeeAllIntegrations();
        //Print the window handles of the opened windows
        System.out.println("Reading all window handles");
        List<String> handles =ltHomePage.getAllWindowHandles();
        System.out.println("Currently opened window: "+handles.size()+", Handles :"+handles);
        // Switch to newly open window
        System.out.println("Switching to new window");
        ltHomePage.switchToRecentlyOpenedWindow();
        //Verify whether the URL is the same as the expected URL (if not, throw an Assert).
        IntegrationPage integrationsPage = PageFactory.initElements(DriverManager.driver(), IntegrationPage.class);
        System.out.println("Asseting url, expected: https://www.lambdatest.com/integrations");
        Assert.assertEquals(integrationsPage.getUrl(), "https://www.lambdatest.com/integrations","Invalid url for Integrations page");
        //On that page, scroll to the page where the WebElement(Codeless Automation) is present.
        //Click the ‘LEARN MORE’ link for Testing Whiz. The page should open in the same window.
        //Check if the title of the page is ‘TestingWhiz Integration | LambdaTest’. If not, raise an Assert.
        //Close the current window using the window handle [which we obtained in step (5)]
        //Print the current window count.
        //On the current window, set the URL to https: //www.lambdatest.com/blog.
        //Click on the ‘Community’ link and verify whether the URL is
        //14. Close the current browser window. https: //community.lambdatest.com/.

    }
    private LtPage openHomePage() {
        System.out.println("Opening Url: "+Const.APP_HOME_URL);
        DriverManager.driver().get(Const.APP_HOME_URL);
        return (LtPage)PageFactory.initElements(DriverManager.driver(), LtPage.class);
    }
    
    // Question: You must run the test on LambdaTest Cloud Selenium Grid in parallel and mention the final Test ID(s) while submitting.
    @DataProvider(name="OS_Browsers_Data_Factory",parallel = true)
    public Object[][] getTestEnvironmentParams(){

        // Question: If you are using Java and TestNG, then pass the browser and OS combinations to the test scenario(s) from testng.xml (for Java). You could also hard code the browser and OS combination in the implementation.
        // Vikas: In this assignment I am hard coding in Data provider but can be read from external source. 
        // Vikas: we get better control over test data in coding instead of using textng.xml <parameters>

        
        return new Object[][]{
            {"Chrome","86.0","Windows 10","Test 1: LT integration Page with chrome browser on Windows 10"},
           // {"Microsoft Edge","87.0","macOS Sierra","Test 2: LT integration Page with MS Edge browser on MacOS Sierra"}
        }; 
    }


}