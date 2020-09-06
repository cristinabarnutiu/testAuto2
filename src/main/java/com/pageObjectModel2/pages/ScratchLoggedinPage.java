package com.pageObjectModel2.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScratchLoggedinPage extends BasePageObject{

    private By profileName = By.className("profile-name");
    private By accountNav = By.className("account-nav");
    private By userNavDropdown = By.cssSelector("ul.user-nav");
    private By profileLink = By.linkText("Profile");

    public ScratchLoggedinPage(WebDriver driver, Logger log) {

        super(driver, log);
    }

    public boolean isProfileNameDisplayed(){
        return find(profileName).isDisplayed();
    }

    public void clickProfileLink (){
        find(profileName).click();
    }

    public boolean isAccountNavDisplayed(){
        return find(accountNav).isDisplayed();
    }

    public ScratchMyProfile selectProfile(){
        clickProfileLink();
        waitForVisibilityOf(profileLink);
        find(profileLink).click();
        return new ScratchMyProfile(driver,log);
    }

    public String getSelectedOption() {
        WebElement dropdownElement = find(userNavDropdown);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        log.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }

}
