package com.krafttecnologies.tests.day2_webDriveBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        //go to google- google a git
        //go to facebook- facebook a git...
        //back to google- google a geri dön

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();//polymorphism...

        driver.get("https://www.google.com");


        Thread.sleep(3000);//3 saniye beklemesi için senkronizasyon sorununu çözmek için yapılıyor. wait de kullanılıyor..

        driver.navigate().to("https://tr-tr.facebook.com/");//navigate to selenium metodudur. web siteleri erişi sağlar...

        //önceki sayfaya dönmek için..
        Thread.sleep(3000);

        driver.navigate().back();

        //ileri gitmek için

        Thread.sleep(3000);

        driver.navigate().forward();

        //refresh yapma..

        Thread.sleep(3000);

        driver.navigate().refresh();

        driver.quit();

    }
}
