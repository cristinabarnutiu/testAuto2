package com.pageObjectModel.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer {
    private static WebElement element = null;

    public static WebElement footerDiv(WebDriver driver){
        element = driver.findElement(By.id("footer"));
        return element;

    }

}
