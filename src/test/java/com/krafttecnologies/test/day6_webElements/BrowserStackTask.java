package com.krafttecnologies.test.day6_webElements;

import com.github.javafaker.Faker;
import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserStackTask {
    public static void main(String[] args) throws InterruptedException {

        /** Class Task
         *  go to the url -  "https://www.browserstack.com/users/sign_up"
         *  maximize the window
         *  accept cookies if any ,
         *  fill in the blanks with the faker class
         *  click "Term of service" checkbox
         *  and close the window
         *
         *  hint: u can use any locator you want
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("CHROME");

        Faker faker=new Faker();

        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("accept-cookie-notification")).click();
        Thread.sleep(2000);

        WebElement fullName=driver.findElement(By.xpath("//input[@placeholder='Full name']"));
        fullName.sendKeys(faker.name().fullName());

        Thread.sleep(2000);

        WebElement emailBar=driver.findElement(By.xpath("//input[@id='user_email_login']"));
        emailBar.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);

        WebElement passwordBar=driver.findElement(By.cssSelector("input[type='password']"));
        passwordBar.sendKeys(faker.internet().password());

        WebElement termsOfUserCheckBox=driver.findElement(By.id("tnc_checkbox"));
        termsOfUserCheckBox.click();

        Thread.sleep(2000);

        driver.close();


    }
}
