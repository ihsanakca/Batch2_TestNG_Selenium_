package com.krafttecnologies.tests.day12_Actions_FileUpLoad_JSExecutor;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Actions1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement doubleClickElement = driver.findElement(By.cssSelector("#double-click"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.doubleClick(doubleClickElement).perform();

        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("div#droppable"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
//        actions.dragAndDrop(drag,drop).perform();

        actions.moveToElement(drag).clickAndHold().moveToElement(drop).release().perform();
        Thread.sleep(2000);


    }

    @Test
    public void dragAndDropTest2() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/droppable");

        WebElement dragAble = driver.findElement(By.cssSelector("div#draggable"));
        WebElement dropAble = driver.findElement(By.cssSelector("div#droppable"));
        System.out.println("dropAble.getText() = " + dropAble.getText());

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragAble, dropAble).perform();
        Thread.sleep(2000);

//        WebElement dropped= driver.findElement(By.xpath("//p[.='Dropped!']"));
//        System.out.println("dropped.getText() = " + dropped.getText());

        System.out.println("dropAble.getText() = " + dropAble.getText());

        Assert.assertTrue(dropAble.getText().equals("Dropped!"), "FAIL");

    }

    @Test
    public void hover1() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement hoverMe = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        WebElement link1 = driver.findElement(By.xpath("(//a[.='Link 1'])[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMe).perform();
        Thread.sleep(2000);

        Assert.assertTrue(link1.isDisplayed(), "FAIL");
        Thread.sleep(2000);

        link1.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        String expectedText = "Well done you clicked on the link!";
        String actualText = alert.getText();
        System.out.println("actualText = " + actualText);

        Assert.assertEquals(actualText, expectedText, "FAIL");
        Thread.sleep(2000);

        alert.accept();
    }

    @Test
    public void hover2() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/tooltips");
        WebElement hover1 = driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[1]"));
        WebElement hover2 = driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[2]"));
        WebElement hover3 = driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[3]"));
        WebElement hover4 = driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[4]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hover1).perform();
        Thread.sleep(2000);
        actions.moveToElement(hover2).perform();
        Thread.sleep(2000);
        actions.moveToElement(hover3).perform();
        Thread.sleep(2000);
        actions.moveToElement(hover4).perform();
        Thread.sleep(2000);

        String hover1Attribute = hover1.getAttribute("data-bs-placement");
        String expectedHover1Attribute = "top";

        Thread.sleep(2000);
        Assert.assertEquals(hover1Attribute, expectedHover1Attribute, "FAIL");

        List<WebElement> hovers=driver.findElements(By.xpath("//button[@class='btn btn-secondary']"));

        for (WebElement hover : hovers) {
            actions.moveToElement(hover).pause(2000).perform();
        }

    }
    @Test
    public void rightClick() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        WebElement rightClick=driver.findElement(By.id("rightClickBtn"));

        Actions actions=new Actions(driver);
        actions.contextClick(rightClick).perform();
        Thread.sleep(2000);

        WebElement rightClickMessage= driver.findElement(By.id("rightClickMessage"));
         String expectedText="You have done a right click";
         String actualText=rightClickMessage.getText();
        System.out.println("actualText = " + actualText);

        Assert.assertEquals(actualText,expectedText,"FAIL");
    }


}