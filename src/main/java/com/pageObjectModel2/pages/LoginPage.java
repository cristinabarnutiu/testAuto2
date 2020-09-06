package com.pageObjectModel2.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

//    private WebDriver driver;
//    private Logger log;

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.tagName("button");
    private By errorMessageLocator = By.id("flash");



    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SecureAreaPage login(String username, String password){
        log.info("Executing login with username: ["+username+"] and password ["+password+"]");
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public SecureAreaPage negativeLogin(String username, String password){
        log.info("Executing login with username: ["+username+"] and password ["+password+"]");;
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public void waitForErrorMessage(){
        waitForVisibilityOf(errorMessageLocator,5);
    }

    public String getErrorMessageTest(){
        return find(errorMessageLocator).getText();
    }

}
