package com.pageObjectModel2.loginpagetests;

import com.pageObjectModel2.loginpagetests.base.TestUtilities;
import com.pageObjectModel2.loginpagetests.pages.SLoginPage;
import com.pageObjectModel2.loginpagetests.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeLoginTests extends TestUtilities

    {

    @Parameters({ "username", "password", "expectedMessage" })
    @Test(enabled=false, priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting negativeTest");

    }
}
