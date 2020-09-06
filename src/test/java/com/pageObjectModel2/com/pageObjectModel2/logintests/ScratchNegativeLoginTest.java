package com.pageObjectModel2.com.pageObjectModel2.logintests;

import com.pageObjectModel2.base.TestUtilities;
import com.pageObjectModel2.pages.ScratchHomePage;
import com.pageObjectModel2.pages.ScratchLoggedinPage;
import com.pageObjectModel2.pages.ScratchRetryLoginPage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ScratchNegativeLoginTest extends TestUtilities {

    @Parameters({ "username", "password", "errorMessage"})
    @Test
    public void negativeLogInTest(String username, String password, @Optional String errorMessage) {
        log.info("Starting negativeLoginTest");
        ScratchHomePage scratchHomePage = new ScratchHomePage(driver,log);
        ScratchRetryLoginPage scratchRetryLogin;
        ScratchLoggedinPage scratchLoggedinPage;

        scratchHomePage.openPage();


        //Assert.assertFalse(scratchHomePage.isLoginErrorMessageDisplayed(),"Login Error Message is displayed");
        //Assert.assertTrue(scratchHomePage.isProfileNameDisplayed());
        //ScratchHomePage = scratchHomePage.negativeLogin(username,password);
        String alert = scratchHomePage.negativeLogin(username,password);
        System.out.println(alert);
        Assert.assertTrue(alert.contains("Captcha Incorrect.")||alert.contains("Incorrect username or password."));

        //Assert.assertTrue(scratchLoggedinPage.isProfileNameDisplayed());

        //Assert.assertTrue(scratchHomePage.isLoginErrorMessageDisplayed(),"Login Error Message is not displayed");
        //Assert.assertEquals(scratchHomePage.getLoginErrorMessage(),errorMessage, "Incorrect Login error message");
        //Assert.assertTrue(scratchHomePage.isProfileNameDisplayed());
    }
}
