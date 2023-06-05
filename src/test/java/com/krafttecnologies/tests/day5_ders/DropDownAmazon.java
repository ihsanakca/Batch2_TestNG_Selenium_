package com.krafttecnologies.tests.day5_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.MessageFormat;
import java.util.List;

public class DropDownAmazon {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        actions=new Actions(driver);
    }

    @Test
    public void test1() {
        driver.get("https://www.saucedemo.com/");
        List<WebElement> loginInputs = driver.findElements(By.xpath("//input"));
        loginInputs.get(0).sendKeys("standard_user");
        loginInputs.get(1).sendKeys("secret_sauce");
        loginInputs.get(2).click();
        List<WebElement> item_names = driver.findElements(By.className("inventory_item_img"));
        for (WebElement item_name : item_names) {
            System.out.println(item_name.getText());
        }

    }



    @Test
    public void dropDownWithSelect() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement searchDropdownBox = driver.findElement(By.cssSelector("#searchDropdownBox"));
     //   List<WebElement> elements = driver.findElements(By.cssSelector("#searchDropdownBox"));

        Select select=new Select(searchDropdownBox);
      //  Select select=new Select(elements.get(0));

        select.selectByIndex(5);
        Thread.sleep(3000);
        select.selectByVisibleText("Deals");
        Thread.sleep(3000);
        select.selectByValue("search-alias=digital-music");
        Thread.sleep(3000);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        Thread.sleep(3000);
        options.forEach(e->{
            System.out.println(e.getText());
        });

        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

        for (int i = options.size() - 1; i >= 0; i--) {
            System.out.println(options.get(i).getText());
        }

        select.selectByIndex(5);

        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Deals");
        Thread.sleep(2000);

        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        select.selectByValue("search-alias=beauty-intl-ship");
        System.out.println(select.getFirstSelectedOption().getText());

    }

    @Test
    public void dropDownWithOutSelect() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[text()='Select Option']")).click();
       // driver.findElement(xPathLocator("Select Option")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Group 2, option 1']")).click();
        //driver.findElement(xPathLocator("Group 2, option 1")).click();
        Thread.sleep(2000);

        String actual=driver.findElement(By.xpath("//div[text()='Group 2, option 1']")).getText();
        String expected="Group 2, option 1";

        Assert.assertEquals(actual,expected);
    }

    By xPathLocator(String text){
        return By.xpath("//*[text()='"+text+"']");
    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://www.hepsiburada.com");
        Thread.sleep(2000);

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement tabBahce = driver.findElement(By.xpath("//span[text()='Oto, Bahçe, Yapı Market']"));
        Thread.sleep(2000);

        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(tabBahce).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Bahçe Kovucuları']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void amazonDropDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.linkText("Keyboards")).click();
        driver.findElement(By.xpath("//span[text()='Featured']")).click();
        driver.findElement(By.linkText("Price: Low to High")).click();
        Thread.sleep(2000);

    }

    @Test
    public void hoverTask() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));

        List<WebElement> imgList=driver.findElements(By.tagName("img"));


        for (int i = 2; i <= imgList.size(); i++) {

            String imgXpath="(//img)["+i+"]";
            System.out.println("imgXpath = " + imgXpath);

            WebElement img = driver.findElement(By.xpath(imgXpath));
            Thread.sleep(1000);

            actions.moveToElement(img).perform();

            String textPath="//h5[text()='name: user" + (i - 1) + "']";

            WebElement text = driver.findElement(By.xpath("//h5[text()='name: user" + (i - 1) + "']"));
            System.out.println("textPath = " + textPath);

            Assert.assertTrue(text.isDisplayed(),"verify that user "+(i-1)+" is displayed");
            System.out.println("verify that user "+(i-1)+" is displayed");

        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
