package com.pageObjectModel2.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScratchMyProfile extends BasePageObject{

    private String url = "https://scratch.mit.edu/users/username_testauto/";
    private By bio = By.name("bio");
    private By status = By.name("status");
    private By avatar = By.className("avatar");

    public ScratchMyProfile(WebDriver driver, Logger log) {
        super(driver,log);
    }

    public String getUrl() {
        return url;
    }

    public void enterAboutMe(String bioText, String statusText){
        find(bio).sendKeys(bioText);
        find(status).sendKeys(statusText);
        waitFor(3000);
    }

    public String getBio(){
        return find(bio).getText();
    }
    public String getStatus(){
        return find(status).getText();
    }

    public void uploadPic(){
        find(avatar).click();
        waitFor(3000);
    }
}
