package com.krafttecnologies.test.day2_webDriveBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.krafttechnologie.com/");

        Thread.sleep(2000);

        driver.close();//close current tab...geçerli sekmeyi kapatır...

        // go to
        driver=new ChromeDriver();//close dan sonra yeniden açmazsak hata alırız...

        driver.get("https://www.facebook.com/");

        driver.quit();//bütün tabları kapatır. sadece current ı değil...

        System.out.println("ışık");
    }
}
