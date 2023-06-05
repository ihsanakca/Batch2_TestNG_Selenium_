package com.krafttecnologies.tests.day12_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StaleElement_And_Waits {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void staleElement1() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        WebElement element = driver.findElement(By.linkText("Basic Ajax in new page"));
        System.out.println("element.getText() = " + element.getText());

        driver.navigate().refresh();

        Thread.sleep(2000);
        System.out.println("element.getText() = " + element.getText());
        WebElement element1 = driver.findElement(By.linkText("Basic Ajax in new page"));
        System.out.println("element1.getText() = " + element1.getText());


    }

    @Test
    public void staleElement2() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement element = driver.findElement(By.xpath("//span[text()='Keyboards']"));
        System.out.println("element.getText() = " + element.getText());
        element.click();
        driver.navigate().back();
        Thread.sleep(5000);
        // WebElement element2 = driver.findElement(By.xpath("//span[text()='Keyboards']"));
        System.out.println("element.getText() = " + element.getText());


//        Alert alert = driver.switchTo().alert();
//        alert.accept();


    }

    @Test
    public void nestedIframe() throws InterruptedException {
        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

    @Test
    public void implicitlyWait() {

        driver.get("https://www.hepsiburada.com/ara?q=laptop");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");

        WebElement laptop = driver.findElement(By.xpath("//h3[text()=' Abra A5 V17.2.3 Intel Core i5-11400H 16GB RAM 500GB SSD 4GB RTX3050Ti FreeDOS 15.6\" FHD 144Hz Oyun Bilgisayarı']"));


        Actions actions = new Actions(driver);
        actions.moveToElement(laptop).perform();

        WebElement sepeteEkle = driver.findElement(By.xpath("(//button[@kind='primary'])[2]"));
        sepeteEkle.click();

    }

    @Test
    public void explicitlyWait() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement startBtn = driver.findElement(By.id("button00"));
        startBtn.click();

        WebElement button01 = driver.findElement(By.id("button01"));
        wait.until(ExpectedConditions.elementToBeClickable(button01));
        button01.click();

        WebElement button02 = driver.findElement(By.id("button02"));
        wait.until(ExpectedConditions.elementToBeClickable(button02));
        button02.click();

        WebElement button03 = driver.findElement(By.id("button03"));
        wait.until(ExpectedConditions.elementToBeClickable(button03));
        button03.click();

        WebElement message = driver.findElement(By.xpath("//*[text()='All Buttons Clicked']"));
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage, "All Buttons Clicked");

    }

    @Test
    public void implicitlyWait2() {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html");

        WebElement startBtn = driver.findElement(By.id("button00"));
        startBtn.click();
        WebElement button01 = driver.findElement(By.id("button01"));
        button01.click();
        WebElement button02 = driver.findElement(By.id("button02"));
        button02.click();
        WebElement button03 = driver.findElement(By.id("button03"));
        button03.click();

        WebElement message = driver.findElement(By.xpath("//*[text()='All Buttons Clicked']"));
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage, "All Buttons Clicked");

    }


}
