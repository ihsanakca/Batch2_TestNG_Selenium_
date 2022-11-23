package com.krafttecnologies.test.day12_Actions_FileUpLoad_JSExecutor;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JSExecutor {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void clickWithJS() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/floating_menu");

        WebElement buttonDeep = driver.findElement(By.linkText("Elemental Selenium"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()", buttonDeep);

        Thread.sleep(2000);

        System.out.println("title= "+js.executeScript("return document.title;").toString());
        System.out.println("url= "+js.executeScript("return document.URL;").toString());

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
            }
        }
        String actualText = driver.findElement(By.tagName("h1")).getText();
        String expectedText = "Elemental Selenium";
        System.out.println("actualText = " + actualText);

        Thread.sleep(2000);
        Assert.assertEquals(actualText, expectedText, "FAIL");

    }
    @Test
    public void  typeWithJS() throws InterruptedException {
        driver.get("https://selectorshub.com/xpath-practice-page/");

        WebElement firstName= driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
        WebElement lastName= driver.findElement(By.xpath("//input[@placeholder='Enter Last name']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

//        js.executeScript("arguments[0].setAttribute('value', 'İhsan')", firstName);
//        js.executeScript("arguments[0].setAttribute('value', 'Akçair')", lastName);


        String name="Ali";
        String surname="Veli";

        js.executeScript("arguments[0].setAttribute('value', '" + name + "')", firstName);
        js.executeScript("arguments[0].setAttribute('value', '" + surname + "')", lastName);
        Thread.sleep(3000);
    }

    @Test
    public void mouseScroll() throws InterruptedException {
        driver.get("https://www.krafttechnologie.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,-3000)");
        Thread.sleep(3000);
    }

}
