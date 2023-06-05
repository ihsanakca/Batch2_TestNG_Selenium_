package com.krafttecnologies.tests.day7_TestNG;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTestNGTest {
    @Test

    public void test1(){
        System.out.println("My First Test Case");
    }
    @Test
    public void test2(){
        System.out.println("My Second Test Case");
    }

    @Test
    public void test3(){
        System.out.println("My Fourth Test Case");
    }

    @Test
    public void test4(){
        System.out.println("My Third Test Case");
    }

    @Test
    public void test5() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://demowebshop.tricentis.com/contactus");

        List<WebElement> elements;

        //Ajax için konulmuştur.... refresh sonrasında önceden create edilen elementler kullanılamaz. stale element
        //hatası verir...

        String [] text={"ihsan","akçair"};

        for (int i = 0; i < 2; i++) {

            elements=driver.findElements(By.cssSelector(".page-body input[type='text']"));
            elements.get(i).sendKeys(text[i]);
            Thread.sleep(3000);
            driver.navigate().refresh();
        }
    }
}
