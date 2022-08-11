package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntegrationPage  extends LtPage{

    public IntegrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div#codeless_row")
    WebElement divCodelessRow;

    @FindBy(xpath = "//*[.='Testing Whiz']/following-sibling::a[.='Learn More']")
    WebElement linkTestingWhizLearnMore;
    
    public void scrollToCodelessRow(){
        this.scrollTo(divCodelessRow);
    }
    public void clickTestingWhizLearnMore(){
        linkTestingWhizLearnMore.click();
    }
    
    

   
}
