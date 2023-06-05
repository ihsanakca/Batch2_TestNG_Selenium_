package com.krafttecnologies.tests.day12_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
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
    public void fileUpload1() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        WebElement fileinput = driver.findElement(By.id("fileinput"));
        Thread.sleep(2000);
        //   fileinput.sendKeys("C:\\Users\\HP\\Desktop\\ccc.txt");
        fileinput.sendKeys("C:/Users/HP/Desktop/ccc.txt");
        Thread.sleep(2000);
        driver.findElement(By.name("upload")).click();

        String actualFileName = driver.findElement(By.id("uploadedfilename")).getText();
        String expectedFileName = "ccc.txt";
        Assert.assertEquals(actualFileName, expectedFileName, "should be same");
    }

    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        WebElement fileinput = driver.findElement(By.id("fileinput"));
        Thread.sleep(2000);

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/ccc.txt";
        String fullPath = projectPath + "/" + filePath;

        fileinput.sendKeys(fullPath);

        driver.findElement(By.name("upload")).click();
        Thread.sleep(2000);

        String actualFileName = driver.findElement(By.id("uploadedfilename")).getText();
        String expectedFileName = "ccc.txt";
        Assert.assertEquals(actualFileName, expectedFileName, "should be same");
    }
}
