package com.pageObjectModel.testClases;

import com.pageObjectModel.pageClasses.AboutPage;
import com.pageObjectModel.pageClasses.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class AboutTest {
    private static WebDriver driver = null;

    @Test(priority=1)
    public void aboutTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://scratch.mit.edu/");

        HomePage.aboutButton(driver).click();
        Thread.sleep(2000);

        Assert.assertEquals(AboutPage.url,driver.getCurrentUrl());


        System.out.println("About works!");


    }

    @Test(priority=2)
    public void aboutTestTitle() throws InterruptedException {
        Thread.sleep(2000);

        //String title = aboutTestTitle(WebDriver driver);

        Assert.assertEquals(AboutPage.aboutPageTitle(driver).getText(),"About Scratch");

        System.out.println("Tets title is correct!");

        driver.quit();

    }

    @AfterClass
    public void quitDriver(){
    driver.quit();
}
}
