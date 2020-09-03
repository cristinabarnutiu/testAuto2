package com.pageObjectModel2.loginpagetests;

import com.pageObjectModel2.loginpagetests.base.TestUtilities;
import com.pageObjectModel2.loginpagetests.pages.SHomePage;
import com.pageObjectModel2.loginpagetests.pages.SLoginPage;
import com.pageObjectModel2.loginpagetests.pages.SecureAreaPage;
import com.pageObjectModel2.loginpagetests.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

    @Test(enabled=false)
    public void logInTest() {
        log.info("Starting logIn test");

        // open main page
        SHomePage welcomePage = new SHomePage(driver, log);
        welcomePage.openPage();


        // Click on Form Authentication link
        //SLoginPage loginPage = welcomePage.clickLoginButton();

        // execute log in
    }
}
