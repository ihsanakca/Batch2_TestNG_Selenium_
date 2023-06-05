package com.krafttecnologies.tests.day3_ders;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.*;

public class Hastane {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.navigate().to("https://medipol.com.tr/hastanelerimiz/medipol-mega");
        //driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.linkText("HASTANELERİMİZ")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("TIBBİ BİRİMLER")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("DOKTORLARIMIZ")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("TEKNOLOJİ")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("CHECK-UP")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("EVDE SAĞLIK")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("İLETİŞİM")).click();
        Thread.sleep(2000);

        driver.quit();

    }
}
