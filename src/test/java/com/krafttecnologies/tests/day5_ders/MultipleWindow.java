package com.krafttecnologies.tests.day5_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindow {
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
    public void oneWindow() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        driver.findElement(By.linkText("Basic Ajax in new page")).click();

        String currentTab = driver.getWindowHandle();

        Set<String> tabs = driver.getWindowHandles();
        Thread.sleep(3000);

        for (String tab : tabs) {
            if (!currentTab.equals(tab)) {
                driver.switchTo().window(tab);
            }
        }

        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void multipleWindows() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

        driver.findElement(By.linkText("Basic Ajax in new page")).click();
        driver.findElement(By.linkText("Attributes in new page")).click();
        driver.findElement(By.linkText("Alerts In A New Window From JavaScript")).click();

        Set<String> tabs = driver.getWindowHandles();
        Thread.sleep(3000);


        String expectedTitle = "Test Page For Element Attributes";

        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        String text = driver.findElement(By.xpath("//h1[text()='Element Attributes Examples']")).getText();
        System.out.println(text);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        WebElement element = driver.findElement(By.linkText("Basic Ajax in new page"));
        System.out.println("element.getText() = " + element.getText());
        driver.navigate().refresh();
        Thread.sleep(5000);
        System.out.println("element.getText() = " + element.getText());

    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement element = driver.findElement(By.xpath("//span[text()='Keyboards']"));
        System.out.println("element.getText() = " + element.getText());
        element.click();
        driver.navigate().back();
        Thread.sleep(5000);
        WebElement element2 = driver.findElement(By.xpath("//span[text()='Keyboards']"));
        System.out.println("element2.getText() = " + element2.getText());

    }
}
