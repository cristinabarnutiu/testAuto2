package com.pageObjectModel.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navbar {
    private static WebElement element = null;

    public static WebElement navbar(WebDriver driver){
        element = driver.findElement(By.id("navigation"));
        return element;

    }
}
