package com.krafttecnologies.tests.day2_webDriveBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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

        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        driver.manage().window().setPosition(new Point(15,15));

        driver.manage().window().setSize(new Dimension(600,600));

//        driver.quit();//bütün tabları kapatır. sadece current ı değil...


    }
}
