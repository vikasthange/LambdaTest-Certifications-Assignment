package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class LtPage {

    //Question: Please ensure to use at least 3 different locators while performing the test.

    protected WebDriver driver;
    LtPage(WebDriver driver){
        this.driver=driver;
    }
    public void waitForPageToLoad(){
        // Question: Perform an explicit wait till the time all the elements in the DOM are available.
        //TODO:
    }
    //Scroll to the WebElement ‘SEE ALL INTEGRATIONS’ using the scrollIntoView() method. You are free to use any of the available web locators (e.g., XPath, CssSelector, etc.)
    public void scrollToSeeAllIntegrations(){
        //TODO:
    }
    //Click on the link and ensure that it opens in a new Tab.
    public void clickScrollToSeeAllIntegrations(){
        // TODO: 

       
    }
    // 5. Save the window handles in a List (or array). Print the window handles of the opened windows (now there are two windows open).
    /**
     * @return all  open window handles
     */
    public List<String> getAllWindowHandles(){
        return new ArrayList(this.driver.getWindowHandles());
    }
}
