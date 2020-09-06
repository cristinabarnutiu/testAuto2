package com.pageObjectModel2.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{
//    private WebDriver driver;
//    private Logger log;

    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver,log);
    }

    //open welcome page
    public void openPage(){
        log.info("Opening page "+pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public LoginPage clickFormAuthenticationLink(){
        log.info("Clicking Form Authentication Link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver,log);
    }


}
