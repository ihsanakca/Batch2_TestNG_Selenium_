package com.krafttecnologies.tests.day9_WebElements3;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSelect {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        //1. dropdown ı diğer elementler gibi locate ediyoruz.

        WebElement dropDownButton=driver.findElement(By.id("oldSelectMenu"));

        //2.Elementi constructor gibi atayarak selenium select classından bir object oluşturuyoruz

        Select selectMenu=new Select(dropDownButton);

        //3. Seçilen ilk elementi test edelim...

        String expectedOption="Red";
        String actualOption=selectMenu.getFirstSelectedOption().getText();

        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption, expectedOption,"FAIL");

        //===============================================================================//
        //DropDowndan diğer optionlar nasıl getirilir.
        //1.Yol Select visibleText kullanılabilir..

        Thread.sleep(2000);

        selectMenu.selectByVisibleText("Black");
        expectedOption="Black";
        actualOption=selectMenu.getFirstSelectedOption().getText();

        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        //===============================================================================//
        //2.Yol Index kullanılarak yapılır..

        Thread.sleep(2000);
        selectMenu.selectByIndex(6);

        expectedOption="White";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        //===============================================================================//
        //3.Yol value kullanılarak yapılır..
        Thread.sleep(2000);

        selectMenu.selectByValue("3");

        expectedOption="Yellow";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

    }
}
