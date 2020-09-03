package com.pageObjectModel.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginWindow {
    private static WebElement element = null;
    private HomePage homepage;

    public static WebElement usernameInput(WebDriver driver){
        element = driver.findElement(By.name("username"));
        return element;
    }

    //WebElement usernameInput = driver.findElement(By.name("username"));
    //WebElement passwordInput = driver.findElement(By.name("password"));
    //WebElement signInButton = driver.findElement(By.cssSelector("button.button.submit-button.white"));

    public static WebElement passwordInput(WebDriver driver){
        element = driver.findElement(By.name("password"));
        return element;

    }

    public static WebElement submitButton(WebDriver driver){
        element = driver.findElement(By.cssSelector("button.button.submit-button.white"));
        return element;

    }

    public static WebElement errorMessage (WebDriver driver){
        element = driver.findElement(By.className("error"));
        return element;

    }

}




