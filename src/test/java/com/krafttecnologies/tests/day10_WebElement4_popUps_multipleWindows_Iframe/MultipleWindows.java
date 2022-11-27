package com.krafttecnologies.tests.day10_WebElement4_popUps_multipleWindows_Iframe;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        driver.close();  //current windowu kapatır...
        driver.quit(); //açılan tüm penceleri kapatır...
    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick =driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        Thread.sleep(2000);

//        String titleAfterClick= driver.getTitle();
//        System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle(); //title The Internet and has ID=506B1B9F7D87D7355C3F5AA44BA4B365
        System.out.println("currentTab = " + currentTab);

       Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {// go and check one by one
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @Test
    public void multipleWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();
        Thread.sleep(5000);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals("New Window"))
//            if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new"))
            {
                //stop loop
                break;
            }

        }
        System.out.println("after click driver.getTitle() = " + driver.getTitle());
    }
}

