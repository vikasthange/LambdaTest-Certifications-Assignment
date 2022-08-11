package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends LtPage{

    public BlogPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Community")
    WebElement linkCommunity;

    public CommunityPage clickCommunityLink(){
        linkCommunity.click();
        return PageFactory.initElements(driver, CommunityPage.class);
    }
}
