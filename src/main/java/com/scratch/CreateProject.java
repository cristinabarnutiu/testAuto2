package com.scratch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProject {
    WebDriver driver = new ChromeDriver();
    String URL = "https://scratch.mit.edu/";
    //private WebElement block = driver.findElement(By.cssSelector("path.blocklyPath.blocklyBlockBackground"));

    @BeforeMethod
    public void beforeCreateProject() {
        System.out.println("executing beforeCreateProject");
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterCreateProject() {
        System.out.println("executing afterCreateProject");
        //driver.quit();
    }

    @Test(priority = 0)
    public void testCreateProject() throws InterruptedException {
        System.out.println("executing testCreateProject");
        WebElement createLink = driver.findElement(By.cssSelector("li.link.create"));
        createLink.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //check if current url is create project page
        Assert.assertEquals(driver.getCurrentUrl(),"https://scratch.mit.edu/projects/editor/?tutorial=getStarted");


        WebElement moveXStepsBlock = driver.findElement(By.cssSelector("#react-tabs-1 > div.gui_blocks-wrapper_1ccgf.box_box_2jjDp > div > div > svg.blocklyFlyout > g > g.blocklyBlockCanvas > g:nth-child(100) > path.blocklyPath.blocklyBlockBackground"));
        moveXStepsBlock.getText();

        WebElement eventsCategory=driver.findElement(By.cssSelector("#react-tabs-1 > div.gui_blocks-wrapper_1ccgf.box_box_2jjDp > div > div > div > div > div:nth-child(4) > div > div.scratchCategoryItemBubble"));
        System.out.println(eventsCategory.getLocation());

        Actions act = new Actions(driver);

        //WebElement block=driver.findElement(By.cssSelector("#react-tabs-1 > div.gui_blocks-wrapper_1ccgf.box_box_2jjDp > div > div > svg.blocklyFlyout > g"));

        //WebElement to=driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Actions act = new Actions(driver);
        act.dragAndDropBy(moveXStepsBlock,700,20).perform();

        Thread.sleep(4000);
        eventsCategory.click();
        eventsCategory.click();
        Thread.sleep(4000);

        WebElement whenFlagClicked = driver.findElement(By.cssSelector("#react-tabs-1 > div.gui_blocks-wrapper_1ccgf.box_box_2jjDp > div > div > svg.blocklyFlyout > g > g.blocklyBlockCanvas > g:nth-child(25) > path"));
        //Actions act2 = new Actions(driver);
        whenFlagClicked.getLocation();
        act.dragAndDropBy(whenFlagClicked,700,-20).perform();
        Thread.sleep(4000);

        WebElement goFlag = driver.findElement(By.cssSelector("#app > div > div.gui_body-wrapper_-N0sA.box_box_2jjDp > div > div.gui_stage-and-target-wrapper_69KBf.box_box_2jjDp > div.stage-wrapper_stage-wrapper_2bejr.box_box_2jjDp > div:nth-child(1) > div > div > div.controls_controls-container_2xinB > img.green-flag_green-flag_1kiAo"));
        goFlag.click();

        Thread.sleep(5000);

        //System.out.println(block.isDisplayed()+""+block.getLocation());


    }

}
