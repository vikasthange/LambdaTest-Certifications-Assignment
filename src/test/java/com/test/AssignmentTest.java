package com.test;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.BlogPage;
import com.pages.CommunityPage;
import com.pages.IntegrationPage;
import com.pages.LtPage;
import com.vikas.Const;
import com.vikas.DriverManager;
import com.vikas.Logger;

public class AssignmentTest{
    // Question: Keep it simple
    // TimeOut of the test duration should be set to 20 seconds (for both the test scenarios). 
    @AfterMethod
    public void cleanUp(){
        // Last step to close and quit all sessions
        DriverManager.cleanUp();
    }
    @Test(dataProvider = "OS_Browsers_Data_Factory",timeOut = Const.TIMEOUT)
    public void test1(String browserName,String browserVersion,String osName,String testName,String testId){
        
        Assert.assertTrue(true);
        DriverManager.initDriver(browserName,browserVersion,osName,testName,testId);
        
        LtPage ltHomePage = openHomePage();
        //Navigate to https://www.lambdatest.com/.
        //Perform an explicit wait till the time all the elements in the DOMare available.
        Logger.log("Waiting for page to load..");
        ltHomePage.waitForPageToLoad();
        // Scroll and Click -> All integrations & navigate to new page
        //Integrations module will be on screen and will be captured in screenshot
        Logger.log( "Scrolling to all integrations sections ");
        ltHomePage.scrollToIntegrationsModuleSection();
        Logger.log( "Clicking all integrations link");

/* Defect#1: clicking on  "all integrations link" does not open new page in new tab/window */
        ltHomePage.clickToSeeAllIntegrations();

        //Print the window handles of the opened windows
        Logger.log( "Reading all window handles");
        List<String> handles = ltHomePage.getAllWindowHandles();
        // Vikas: Question only tells to print the count and not to assert count, If assert added then test will fails as mentioned Defect#1.
        Logger.log( "Currently opened window: "+handles.size()+", Handles :"+handles);  
        // Switch to newly open window
        Logger.log( "Switching to new window");
        ltHomePage.switchToWindowByHandleId(handles.get(handles.size()-1));
        //Verify whether the URL is the same as the expected URL (if not, throw an Assert).
        IntegrationPage integrationsPage = PageFactory.initElements(DriverManager.driver(), IntegrationPage.class);
        Logger.log( "Asseting url, expected: https://www.lambdatest.com/integrations");
        Assert.assertEquals(integrationsPage.getUrl(), "https://www.lambdatest.com/integrations", "Invalid url for Integrations page");
        //On that page, scroll to the page where the WebElement(Codeless Automation) is present.
        integrationsPage.scrollToCodelessRow();
        //Click the ‘LEARN MORE’ link for Testing Whiz. The page should open in the same window.
        integrationsPage.clickTestingWhizLearnMore();

/* Defect#2:   expected page time mentioned in question is different that  actual title, below assert is failing */
        //Check if the title of the page is ‘TestingWhiz Integration | LambdaTest’. If not, raise an Assert.
        Assert.assertEquals(integrationsPage.getTitle(), "TestingWhiz Integration | LambdaTest","Page title failed after opening testing whiz learn more");
/* Defect#1: clicking on  "all integrations link" does not open new page in new tab/window  so if current window closed then following code will fais as there is only one window*/
        //Close the current window using the window handle [which we obtained in step (5)]
        integrationsPage.closeCurrnetWindow();
        
        integrationsPage.switchToWindowByHandleId(handles.get(0));
        //Print the current window count.
        Logger.log("Currently opened windows: "+ integrationsPage.getAllWindowHandles().size());
        //On the current window, set the URL to https: //www.lambdatest.com/blog.
        BlogPage blogpage = navigateToBlogPage();
        //Click on the ‘Community’ link and verify whether the URL is
        CommunityPage communityPage = blogpage.clickCommunityLink();
        //14. Close the current browser window. https://community.lambdatest.com/.
        Assert.assertEquals(communityPage.getUrl(), "https://community.lambdatest.com/");

    }
    private BlogPage navigateToBlogPage() {
    
        Logger.log("Opening Url: "+Const.BLOG_PAGE_URL);
        DriverManager.driver().navigate().to(Const.BLOG_PAGE_URL);
        return PageFactory.initElements(DriverManager.driver(), BlogPage.class);
    }
    private LtPage openHomePage() {
        Logger.log("Opening Url: "+Const.APP_HOME_URL);
        DriverManager.driver().get(Const.APP_HOME_URL);
        return PageFactory.initElements(DriverManager.driver(), LtPage.class);
    }
    
    // Question: You must run the test on LambdaTest Cloud Selenium Grid in parallel and mention the final Test ID(s) while submitting.
    @DataProvider(name="OS_Browsers_Data_Factory",parallel = true)
    public Object[][] getTestEnvironmentParams(){

        // Question: If you are using Java and TestNG, then pass the browser and OS combinations to the test scenario(s) from testng.xml (for Java). You could also hard code the browser and OS combination in the implementation.
        // Vikas: In this assignment I am hard coding in Data provider but can be read from external source. 
        // Vikas: we get better control over test data in coding instead of using textng.xml <parameters>

        
        return new Object[][]{
           {"Chrome","86.0","Windows 10","Test 1: LT integration Page with chrome browser on Windows 10","TC1"},
           {"Microsoft Edge","87.0","macOS Sierra","Test 2: LT integration Page with MS Edge browser on MacOS Sierra","TC2"}
        }; 
    }
}