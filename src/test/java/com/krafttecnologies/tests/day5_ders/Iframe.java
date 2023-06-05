package com.krafttecnologies.tests.day5_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Iframe {
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
    public void test1() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);
        driver.switchTo().frame("thedynamichtml");
        String h1Text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(h1Text);

        driver.switchTo().parentFrame();

        driver.switchTo().frame("theheaderhtml");
        String h1Text2 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(h1Text2);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        String h1Text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(h1Text);

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        String h1Text2 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(h1Text2);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);
        WebElement iframe1 = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe1);
        String h1Text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(h1Text);

        driver.switchTo().defaultContent();

        WebElement iframe2 = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe2);
        String h1Text2 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(h1Text2);
    }

    @Test
    public void nestedFrames() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        Thread.sleep(2000);


        driver.switchTo().frame("top");
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame("left");
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();

        WebElement rightFrame = driver.findElement(By.xpath("//frame[@src='get-list?name=Right&list=50']"));
        driver.switchTo().frame(rightFrame);
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        driver.switchTo().defaultContent();


        driver.switchTo().frame(4);
        WebElement element = driver.findElement(By.xpath("//a[text()='EvilTester.com']"));
        System.out.println(element.getText());


    }
}