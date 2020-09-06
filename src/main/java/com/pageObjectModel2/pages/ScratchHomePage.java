package com.pageObjectModel2.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class ScratchHomePage extends BasePageObject{
    private String pageUrl = "https://scratch.mit.edu/";
    private By signInLink = By.cssSelector("li.link.right.login-item");
    //private By signinButtonFromRetry = By.linkText("Login");
    //private By usernameRetryField = By.id();
    private By loginWindow = By.cssSelector("div.dropdown.with-arrow.open");
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button.button.submit-button.white");
    private By loginErrorMessage = By.className("error");
    //private By profileName = By.className("profile-name");
    private String retryUrl = "https://scratch.mit.edu/login_retry/";
    //private By captchaCheckbox = By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[4]");

    ScratchRetryLoginPage scratchRetryLoginPage;

    public ScratchHomePage(WebDriver driver, Logger log) {
        super(driver,log);
    }

    //open Scratch home page
    public void openPage(){
        log.info("Opening page "+pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public String signInAttempt(String username, String password) {
        log.info("Selecting login link from page header");
        click(signInLink);
        log.info("Executing login with username: ["+username+"] and password ["+password+"]");
        //log.info("Selecting login link from page header");
        type(username, usernameField);
        type(password, passwordField);
        waitFor(3000);
        click(loginButton);
        waitFor(5000);
        System.out.println(getCurrentUrl());
        return getCurrentUrl();

    }

    public ScratchLoggedinPage positiveLogin(String username, String password){
        String redirectUrl = signInAttempt(username,password);
        if (redirectUrl.contentEquals(retryUrl)){
            ScratchRetryLoginPage scratchRetryLoginPage = new ScratchRetryLoginPage(driver,log);
            scratchRetryLoginPage.retryLogin(username,password);
        }
        return new ScratchLoggedinPage(driver,log);
    }

    public String negativeLogin(String username, String password){
        String redirectUrl = signInAttempt(username,password);
        if (redirectUrl.contentEquals(retryUrl)){
            ScratchRetryLoginPage scratchRetryLoginPage = new ScratchRetryLoginPage(driver,log);
            scratchRetryLoginPage.retryLoginNegative(username,password);
            //return (scratchRetryLoginPage.isAlertDisplayed());
            return scratchRetryLoginPage.getAlertMessage();
        }
        //ScratchHomePage scratchHomePage = new ScratchHomePage(driver, log);
        return find(loginErrorMessage).getText();
    }



    public boolean isLoginErrorMessageDisplayed(){
        return find(loginErrorMessage).isDisplayed();
    }

    //public void waitForLoginErrorMessage(){waitForVisibilityOf(loginErrorMessage,5); }

    public String getLoginErrorMessage(){
        return find(loginErrorMessage).getText();
    }

    //public boolean isProfileNameDisplayed(){return find(profileName).isDisplayed();}

}
