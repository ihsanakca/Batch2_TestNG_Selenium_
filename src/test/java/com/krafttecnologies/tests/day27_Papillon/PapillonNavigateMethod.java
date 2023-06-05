package com.krafttecnologies.tests.day27_Papillon;

import com.krafttecnologies.pages.PapillonHomePage;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.Driver;
import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class PapillonNavigateMethod {


    PapillonHomePage papillonHomePage = new PapillonHomePage();

    @Test
    public void test1() throws InterruptedException {
        Driver.get().get("https://papillonakademi.com/");
        papillonHomePage.navigateToTabsOrModules("Sıkça Sorulan Sorular");
        Thread.sleep(3000);
        Driver.get().close();
    }

    @Test
    public void test2() throws InterruptedException {
        Driver.get().get("https://papillonakademi.com/");
        papillonHomePage.hoverTabs("Blog");
        Thread.sleep(3000);
        Driver.get().close();
    }
    @Test
    public void test3() throws InterruptedException, AWTException {
        Driver.get().get("https://papillonakademi.com/");
        WebElement element = Driver.get().findElement(By.xpath("//img[@class='iconmaps']"));
        Actions actions=new Actions(Driver.get());
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        Driver.get().close();


    }

}
