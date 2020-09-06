package com.pageObjectModel2.com.pageObjectModel2.logintests;

import com.pageObjectModel2.base.BaseTest;
import com.pageObjectModel2.base.TestUtilities;
import com.pageObjectModel2.pages.LoginPage;
import com.pageObjectModel2.pages.WelcomePageObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");


        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();

        // execute negative login
        loginPage.negativeLogin(username, password);


        //wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageTest();

        // Verification
        Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't display");


    }

}
