package com.pageObjectModel.testClases;

import com.pageObjectModel.pageClasses.Footer;
import com.pageObjectModel.pageClasses.Navbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavbarTest {
    private static WebDriver driver = null;

    //Test Data


    @Test

    public void isNavbarDisplayed() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://scratch.mit.edu/");
        System.out.println("isFooterDisplayed test running");

        Assert.assertTrue(Navbar.navbar(driver).isDisplayed());
        driver.close();

    }
}
