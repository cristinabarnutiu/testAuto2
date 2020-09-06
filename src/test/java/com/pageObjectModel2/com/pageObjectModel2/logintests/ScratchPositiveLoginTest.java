package com.pageObjectModel2.com.pageObjectModel2.logintests;

import com.pageObjectModel2.base.TestUtilities;
import com.pageObjectModel2.pages.ScratchHomePage;
import com.pageObjectModel2.pages.ScratchLoggedinPage;
import com.pageObjectModel2.pages.ScratchRetryLoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScratchPositiveLoginTest extends TestUtilities {

    @Parameters({ "username", "password"})
    @Test(enabled=true)
    public void positiveLogInTest(String username, String password) {
        log.info("Starting positive logIn test");
        ScratchHomePage scratchHomePage = new ScratchHomePage(driver,log);
        ScratchRetryLoginPage scratchRetryLogin;
        ScratchLoggedinPage scratchLoggedinPage;

        scratchHomePage.openPage();

//        String redirectuUrl = scratchHomePage.signInAttempt(username,password);
//        sleep(5000);
        //Assert.assertFalse(scratchHomePage.isLoginErrorMessageDisplayed(),"Login Error Message is displayed");
        //Assert.assertTrue(scratchHomePage.isProfileNameDisplayed());

        scratchLoggedinPage = scratchHomePage.positiveLogin(username,password);
        Assert.assertTrue(scratchLoggedinPage.isProfileNameDisplayed());
    }




}
