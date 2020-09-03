package com.pageObjectModel.testClases;

import com.pageObjectModel.pageClasses.HomePage;
import com.pageObjectModel.pageClasses.LoginWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class SigninTest {

    private static WebDriver driver = null;
    //Test Data
    String validUser = "username_testauto";
    String invalidUser = "invalid";
    String validPassword = "password_testauto";
    String invalidPassword = "invalid";

    @Test

    public void signinTest() throws InterruptedException {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    driver.get("https://scratch.mit.edu/");


     HomePage.loginLink(driver).click();
     Thread.sleep(2000);
     LoginWindow.usernameInput(driver).sendKeys(validUser);
     LoginWindow.passwordInput(driver).sendKeys(validPassword);
     Thread.sleep(2000);
     LoginWindow.submitButton(driver).click();
     Thread.sleep(2000);


     //SHomePage homePage = driver.getCurrentUrl();
        //Assert.assertFalse(LoginWindow.errorMessage(driver).isDisplayed());
        Assert.assertEquals(HomePage.profileNameLink(driver).getText(),validUser);

        //Assert.assertFalse(LoginWindow.errorMessage().);

     System.out.println("Login works!");


     driver.quit();

}

}
