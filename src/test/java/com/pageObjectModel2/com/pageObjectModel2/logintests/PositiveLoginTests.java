package com.pageObjectModel2.com.pageObjectModel2.logintests;

import com.pageObjectModel2.base.BaseTest;
import com.pageObjectModel2.base.TestUtilities;
import com.pageObjectModel2.pages.LoginPage;
import com.pageObjectModel2.pages.SecureAreaPage;
import com.pageObjectModel2.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void logInTest() {
        log.info("Starting logIn test");

        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver,log);
        welcomePageObject.openPage();
//        String url = "http://the-internet.herokuapp.com/";
//        driver.get(url);
//        log.info("Main page is opened.");

        // Click on Form Authentication link
        //driver.findElement(By.linkText("Form Authentication")).click();
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();

        // enter username and password
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //execute login
        //loginPage.login("tomsmith","SuperSecretPassword!");

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        sleep(3000);

        // push log in button
//        WebElement logInButton = driver.findElement(By.className("radius"));
//        wait.until(ExpectedConditions.elementToBeClickable(logInButton));
//        logInButton.click();

        // verifications
        // new url
//        String expectedUrl = "http://the-internet.herokuapp.com/secure";

        SecureAreaPage secureAreaPage =  loginPage.login("tomsmith","SuperSecretPassword!");

        //new page is expected
        Assert.assertEquals(secureAreaPage.getCurrentUrl(),secureAreaPage.getPageUrl());

        // log out button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),
                "logOutButton is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
