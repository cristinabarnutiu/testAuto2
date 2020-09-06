package com.findBrokenLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinks {

    public WebDriver driver = null;

    @Test(enabled=false)
    public void checkIfLinkIsValid(){
        String homePage = "https://scratch.mit.edu/";
        String url = "";
        HttpURLConnection httpURLConnection = null;
        int responseCode = 200;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(homePage);

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while(it.hasNext()){

            url = it.next().getAttribute("href");

            System.out.println(url);

            if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                httpURLConnection = (HttpURLConnection)(new URL(url).openConnection());

                httpURLConnection.setRequestMethod("HEAD");

                httpURLConnection.connect();

                responseCode = httpURLConnection.getResponseCode();

                if(responseCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.quit();

    }
}
