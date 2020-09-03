package com.pageObjectModel2.loginpagetests.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SHomePage extends BasePageObject {

    private String pageUrl = "https://scratch.mit.edu/";

    private By signinButton = By.cssSelector("li.link.right.login-item");
    private By singinWindow = By.cssSelector("div.login");

    public SHomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Open WelcomePage with it's url */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /** Open SLoginPage by clicking on Form Authentication Link */
    public void clickLoginButton() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(signinButton);
        //return new SHomePage(driver,log);
    }

}

