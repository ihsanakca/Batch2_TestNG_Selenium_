package com.krafttecnologies.tests.day2_webDriveBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {
        //open chrome and navigate to kroft...
        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");

        //başlığı title ı alma
        System.out.println(driver.getTitle());

        //geçerli / current url i alma

        String currentUrl= driver.getCurrentUrl();

        System.out.println(currentUrl);

        // get the source of page- web sayfasının kaynağını almak/incele (html )kısmındaki elements kısmını almak

        String pageSource= driver.getPageSource();
       // System.out.println(pageSource);


    }
}
