package com.pageObjectModel2.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScratchRetryLoginPage extends BasePageObject{
    private By signinRetryButton = By.xpath("//*[@id=\"content\"]/form/button");
    private By usernameRetryField = By.id("id_username");
    private By passwordRetryField = By.id("id_password");
    //private By captchaCheckbox = By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[4]");
    private By alert = By.xpath("//*[@id=\"content\"]/p");

    public ScratchRetryLoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public ScratchLoggedinPage retryLogin(String username, String password){
        type(username, usernameRetryField);
        type(password, passwordRetryField);
        //click(captchaCheckbox);
        waitFor(3000);
        click(signinRetryButton);
        waitFor(5000);
        return new ScratchLoggedinPage(driver,log);
    }

    public ScratchRetryLoginPage retryLoginNegative(String username, String password){
        type(username, usernameRetryField);
        type(password, passwordRetryField);
        //click(captchaCheckbox);
        waitFor(3000);
        click(signinRetryButton);
        waitFor(5000);
        return new ScratchRetryLoginPage(driver,log);
    }

    public boolean isAlertDisplayed(){
        return find(alert).isDisplayed();
    }

    public String getAlertMessage(){return find(alert).getText();}

}
