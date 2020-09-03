package com.pageObjectModel.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutPage {

    private static WebElement element = null;

    public static WebElement aboutPageTitle(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"view\"]/div/h1/span"));
        return element;


    }

    public static String url = "https://scratch.mit.edu/about";
}
