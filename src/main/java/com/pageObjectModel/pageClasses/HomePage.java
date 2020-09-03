package com.pageObjectModel.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private static WebElement element = null;
    private static AboutPage aboutPage = null;

    public static WebElement loginLink(WebDriver driver){
        element = driver.findElement(By.cssSelector("li.link.right.login-item"));
        return element;

    }

    public static WebElement profileNameLink(WebDriver driver){
        element = driver.findElement(By.className("profile-name"));
        return element;

    }

    public static WebElement aboutButton(WebDriver driver){
        element = driver.findElement(By.linkText("About"));
        return element;

    }

    public static void clickAboutButton(WebDriver driver){
        aboutButton(driver).click();
    }

}
