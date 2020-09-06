package com.pageObjectModel2.com.pageObjectModel2.logintests;

import com.pageObjectModel2.base.TestUtilities;
import com.pageObjectModel2.pages.ScratchHomePage;
import com.pageObjectModel2.pages.ScratchLoggedinPage;
import com.pageObjectModel2.pages.ScratchMyProfile;
import com.pageObjectModel2.pages.ScratchRetryLoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScratchProfileTest extends TestUtilities {

    @Parameters({ "username", "password"})
    @Test(priority=1)
    public void updateProfile(String username, String password){
        log.info("open page");
        ScratchHomePage scratchHomePage = new ScratchHomePage(driver,log);
        //ScratchLoggedinPage scratchLoggedinPage;

        log.info("log in");
        scratchHomePage.openPage();
        ScratchLoggedinPage scratchLoggedinPage = scratchHomePage.positiveLogin(username, password);
        sleep(10000);
        Assert.assertTrue(scratchLoggedinPage.isProfileNameDisplayed());

        //scratchLoggedinPage.clickProfileLink();
        //Assert.assertTrue(scratchLoggedinPage.isAccountNavDisplayed());

        ScratchMyProfile scratchMyProfile = scratchLoggedinPage.selectProfile();
        sleep(6000);
        log.info("Current url is "+scratchMyProfile.getCurrentUrl());

        Assert.assertTrue(scratchMyProfile.getCurrentUrl().equalsIgnoreCase(scratchMyProfile.getUrl()));

        scratchMyProfile.enterAboutMe("About me", "About my work");
        sleep(6000);

        Assert.assertTrue(scratchMyProfile.getBio().contains("About me"));
        Assert.assertTrue(scratchMyProfile.getStatus().contains("About my work"));

        scratchMyProfile.uploadPic();

    }

    @Test(priority=2)
    public void uploadProfilePic(){

        //scratchMyProfile.uploadPic();

    }
}
