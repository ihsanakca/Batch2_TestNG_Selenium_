package com.krafttecnologies.test.day12_Actions_FileUpLoad_JSExecutor;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
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
    public void uploadFile() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");

        WebElement chooseFile=driver.findElement(By.id("uploadFile"));
        Thread.sleep(2000);
        chooseFile.sendKeys("C:\\Users\\HP\\Desktop\\ccc.txt");

        WebElement textMessage=driver.findElement(By.id("uploadedFilePath"));
        String actualText = textMessage.getText();
        String expectedText="ccc.txt";
        System.out.println("textMessage.getText() = " + textMessage.getText());
        Thread.sleep(2000);

        Assert.assertTrue(actualText.contains(expectedText),"FAIL");
    }
}
