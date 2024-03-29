package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vikas.Const;

public class LtPage {

    //Question: Please ensure to use at least 3 different locators while performing the test.

    By linkSeeAllIntegrations = By.xpath("//*[text()='See All Integrations']");
    By btnAllowCookie = By.xpath("//*[contains(@class,'cookies__bar')]//span[.='Allow Cookie']");
    By sectionSeemlessCollabration = By.xpath("//*[text()='Seamless Collaboration']");
    By logo = By.cssSelector(".tools_logo img");
    protected WebDriver driver;
    public LtPage(WebDriver driver){
        this.driver=driver;
    }
    public void waitForPageToLoad(){
        // Question: Perform an explicit wait till the time all the elements in the DOM are available.
        //TODO:
        waitForSeconds(1);
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(Const.ELEMENT_TIMEOUT_SEC));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        //close allow cookie popup
        if(isElementPresent(btnAllowCookie)){
            
            driver.findElement(btnAllowCookie).click();
        }
        
    }
    private boolean isElementPresent(By btnAllowCookie2) {
        try{
            return driver.findElement(btnAllowCookie)!=null;
        }
        catch(WebDriverException e){
            return false;
        }
    }
    private void waitForSeconds(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public void openUrl(String url){
        this.driver.get(url);
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    //Scroll to the WebElement ‘SEE ALL INTEGRATIONS’ using the scrollIntoView() method. You are free to use any of the available web locators (e.g., XPath, CssSelector, etc.)
    public void scrollToIntegrationsModuleSection(){
        scrollTo(sectionSeemlessCollabration);
    }
    //Click on the link and ensure that it opens in a new Tab.
    public void clickToSeeAllIntegrations(){
    //    driver.findElement(linkSeeAllIntegrations).click();       
       // Using javascript click as there is allow cookie popup 
       
       jsClick(linkSeeAllIntegrations);
    }
    // 5. Save the window handles in a List (or array). Print the window handles of the opened windows (now there are two windows open).
    /**
     * @return all  open window handles
     */
    public List<String> getAllWindowHandles(){
        return new ArrayList<String>(this.driver.getWindowHandles());
    }
    public void switchToWindowByHandleId(String handleId) {
        this.driver.switchTo().window(handleId);
    }
    public void closeCurrnetWindow() {
        this.driver.close();
    }
    
    protected void jsClick(By locator) {
        WebElement element= driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }
    protected void scrollTo(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", element);
    }
    protected void scrollTo(By locator) {
        WebElement element= driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", element);
    }
    
}
