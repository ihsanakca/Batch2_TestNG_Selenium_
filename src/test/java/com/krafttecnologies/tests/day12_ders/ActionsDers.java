package com.krafttecnologies.tests.day12_ders;

import com.github.javafaker.Faker;
import com.krafttecnologies.utilities.Driver;
import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsDers {
    WebDriver driver;
    Actions actions;


    @BeforeMethod
    public void setUp() {
       // driver = WebDriverFactory.getDriver("chrome");
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
       driver.quit();
    }


    @Test
    public void doubleClick() {
        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.id("clicker"));
        actions = new Actions(driver);
        actions.doubleClick(clicker).perform();

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//
//// Eleman üzerinde double click işlemini gerçekleştirin.
//        executor.executeScript("var event = new MouseEvent('dblclick', {'view': window, 'bubbles': true, 'cancelable': " +
//                "true}); arguments[0].dispatchEvent(event);", clicker);

    }

    @Test
    public void rightClick() {
        driver.get("https://skill-test.net/right-click-test");
        WebElement clicker = driver.findElement(By.id("clicker"));
        Actions actions = new Actions(driver);
        //    JavascriptExecutor executor = (JavascriptExecutor) driver;
        for (int i = 0; i < 50; i++) {
            actions.contextClick(clicker).perform();
//            executor.executeScript("var event = new MouseEvent('contextmenu', {'view': window, 'bubbles': " +
//                    "true, 'cancelable': true}); arguments[0].dispatchEvent(event);", clicker);
//            executor.executeScript("arguments[0].dispatchEvent(new MouseEvent('contextmenu', " +
//                    "{'view': window, 'bubbles': true, 'cancelable': true}));", clicker);
        }
    }

    @Test
    public void hover() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        String[] tabs = {"Elektronik", "Moda", "Ev, Yaşam, Kırtasiye, Ofis", "Oto, Bahçe, Yapı Market",
                "Anne, Bebek, Oyuncak", "Spor, Outdoor", "Kozmetik, Kişisel Bakım", "Süpermarket, Pet Shop", "Kitap, Müzik, Film, Hobi"};

        actions = new Actions(driver);
        List<String> tabNames = new ArrayList<>();

        for (int i = 0; i < tabs.length; i++) {
            WebElement tab = driver.findElement(By.xpath("//span[text()='" + tabs[i] + "']"));
            actions.moveToElement(tab).perform();
            tabNames.add(tab.getText());
            Thread.sleep(1000);
        }
        System.out.println("tabNames = " + tabNames);
    }

    @Test
    public void hover1() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        actions = new Actions(driver);
        List<String> list = new ArrayList<>();
        List<WebElement> users = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        List<WebElement> names = driver.findElements(By.className("figcaption"));

        for (int i = 0; i < users.size(); i++) {
            actions.moveToElement(users.get(i)).perform();

            list.add(names.get(i).getText());
        }
        System.out.println("list = " + list);
    }

    @Test
    public void hover2() throws InterruptedException {
        driver.get("https://www.hepsiburada.com/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement evTekstil = driver.findElement(By.xpath("//span[text()='Ev, Yaşam, Kırtasiye, Ofis']"));
        actions.moveToElement(evTekstil).perform();
        driver.findElement(By.xpath("//span[text()='Nevresim']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");
        WebElement dragElement = driver.findElement(By.id("draggable2"));
        WebElement dropElement = driver.findElement(By.id("droppable1"));
        WebElement index = driver.findElement(By.xpath("//*[text()='Index']"));

        //actions.dragAndDrop(dragElement,dropElement).perform();

        actions.clickAndHold(dragElement).moveToElement(index).pause(2000).moveToElement(dropElement).pause(2000).release().perform();
        Thread.sleep(2000);

    }

    @Test
    public void actionsExtra() {
        driver.get("https://www.krafttechexlab.com/forms/elements");
        WebElement firstElement = driver.findElement(By.xpath("//input[@name='text']"));
        actions.click(firstElement)
                .sendKeys("Ahmet Ay")
                .sendKeys(Keys.TAB)
                .sendKeys("Ahmet@ay.com" + Keys.TAB)
                .sendKeys("12345678" + Keys.TAB)
                .sendKeys("155" + Keys.TAB + Keys.TAB)
                .sendKeys("01022022" + Keys.TAB)
                .sendKeys("1212P" + Keys.TAB + Keys.TAB)
                .sendKeys("Ahmet Ay Adana" + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB + Keys.TAB)
                .sendKeys("aaaa@aaa.com" + Keys.TAB)
                .sendKeys("12345678" + Keys.TAB)
                .sendKeys("No comment" + Keys.TAB + Keys.TAB + Keys.ENTER).perform();

        String actualText = driver.findElement(By.xpath("//pre")).getText();
        Assert.assertTrue(actualText.contains("aaaa@aaa.com"));
    }


}
