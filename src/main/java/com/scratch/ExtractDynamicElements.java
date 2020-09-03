package com.scratch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//Class allows extracting elements from a particular part of a webpage (e.g. iFrames)
public class ExtractDynamicElements {

    //public class CreateProject {
    WebDriver driver =null;
    String URL = "https://scratch.mit.edu/";
    Logger log;

    @BeforeMethod
    public void beforeExtractSpecificElements() {
        System.out.println("executing beforeExtractSpecificElements");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        //Apply Implicit Wait - wait for 30 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterExtractSpecificElements() {
        //log.info("executing afterExtractSpecificElements");
        driver.quit();
    }

    @Test
    public void getElements(){
        System.out.println("executing getElements");
        WebElement recommendedProjectsDiv = driver.findElement(By.xpath("//*[@id=\"view\"]/div/div[2]/div[1]"));

        List<WebElement> recommendedProjectLinks = recommendedProjectsDiv.findElements(By.tagName("a"));

        for (WebElement recommendedProjectLink : recommendedProjectLinks){
            System.out.println(recommendedProjectLink.getText());
        }
    }


}
