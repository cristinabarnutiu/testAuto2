package com.devicesCompatibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestToggleView {
    public WebDriver driver;
    String url = "https://scratch.mit.edu/";


    @Test(testName = "testToggleViewIphoneX")
    public void testToggleViewIphoneX() throws InterruptedException {
        System.out.println("executing testToggleViewIphoneX");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        Thread.sleep(3000);

        WebElement startCreating = driver.findElement(By.cssSelector("a.intro-button.create-button.button"));
        Assert.assertTrue(startCreating.isDisplayed());

        WebElement join = driver.findElement(By.cssSelector("a.intro-button.join-button.button"));
        Assert.assertTrue(join.isDisplayed());

        List<WebElement> detailsLinks = driver.findElements(By.cssSelector("div.subnav-button.button"));

        Assert.assertTrue(detailsLinks.size()==3);

        for (WebElement detailsLink : detailsLinks){
            //System.out.println(detailsLinks.contains("About Sratch"));
            System.out.println(detailsLink.getText());
        }
        //Assert.assertTrue(detailsLinks.contains());

        driver.close();
    }

    @Test (testName = "testToggleViewTablet")
    public void testToggleViewTablet() throws InterruptedException {
        System.out.println("executing testToggleViewTablet");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "iPad");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        Thread.sleep(3000);

        WebElement startCreating = driver.findElement(By.cssSelector("a.intro-button.create-button.button"));
        Assert.assertTrue(startCreating.isDisplayed());

        WebElement join = driver.findElement(By.cssSelector("a.intro-button.join-button.button"));
        Assert.assertTrue(join.isDisplayed());

        List<WebElement> detailsLinks = driver.findElements(By.cssSelector("div.subnav-button.button"));

        Assert.assertTrue(detailsLinks.size()==3);

        for (WebElement detailsLink : detailsLinks){
            //System.out.println(detailsLinks.contains("About Sratch"));
            System.out.println(detailsLink.getText());
        }
        //Assert.assertTrue(detailsLinks.contains());

        driver.close();
    }

    @Test (testName = "testToggleViewGalaxyS5")
    public void testToggleViewGalaxyS5() throws InterruptedException {
        System.out.println("executing testToggleViewGalaxyS5");

        Map<String, String> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceName", "Galaxy S5");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        Thread.sleep(3000);

        WebElement startCreating = driver.findElement(By.cssSelector("a.intro-button.create-button.button"));
        Assert.assertTrue(startCreating.isDisplayed());

        WebElement join = driver.findElement(By.cssSelector("a.intro-button.join-button.button"));
        Assert.assertTrue(join.isDisplayed());

        List<WebElement> detailsLinks = driver.findElements(By.cssSelector("div.subnav-button.button"));

        Assert.assertTrue(detailsLinks.size()==3);

        for (WebElement detailsLink : detailsLinks){
            //System.out.println(detailsLinks.contains("About Sratch"));
            System.out.println(detailsLink.getText());
        }
        //Assert.assertTrue(detailsLinks.contains());

        driver.close();
    }

    @AfterTest
    public void afterTestToggleView(){
        System.out.println("executing afterTestToggleView");
        //driver.close();
    }



}
