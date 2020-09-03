package com.browserCompatibility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InvokeBrowserDynamically {

    public WebDriver driver = null;
    public String URL = "https://scratch.mit.edu/";

    @Parameters("browser")
    @BeforeMethod
    public void openBrowser(@Optional String browser){
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                System.out.println("verifying with chrome");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", "en-GB");
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                driver = new FirefoxDriver(options);
                System.out.println("verifying with FF");
                break;
            //case "safari":
            //    driver = new SafariDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", "drivers\\MSEdgedriver.exe");
                driver = new EdgeDriver();
                System.out.println("verifying with edge");
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
                System.out.println("verifying with chrome");
                driver = new ChromeDriver();
        }

//        if(browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//        }
//        else if(browser.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
//            driver = new FirefoxDriver();
//        }
//        else {
//            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//        }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }

    @Test (testName = "verifyHomePageOnBrowsers")
    public void verifyHomePageOnBrowsers(){
        //String URL = "https://scratch.mit.edu/";

        driver.get(URL);

        //To maximize the browser
        driver.manage().window().maximize();

        //Verify SHomePage Title contains Facebook
        String pageTitle = driver.getTitle();
        String[] title = pageTitle.split(" ");
        Assert.assertEquals(title[0],"Scratch");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
