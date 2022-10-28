package com.krafttecnologies.test.day1_AutomationIntro_FrameworkSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openBrowser {

    public static void main(String[] args) {
/*
    1.pom.xml'e yüklediğimiz webDriver manager kütüphanesinden chrome u hazır hale getirmesini isteyeceğiz...
    2.WebDriver classından driver ı hazır hale getirmesini isteyeceğiz...
    3.Driver a testini yapacağımız web sayfasına bizi götürmesini isteyeceğiz...
 */



        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");
        driver.manage().window().maximize();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        String expectedTitle="Kraft Technologie | Yazılım ve Bilişim Eğitimleri – Uzaktan Canlı Eğitim";

        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Başlık Beklendiği gibi geldi. Doğrulama Geçti");
        }else {
            System.out.println("Başlık beklendiği gibi GELMEDİ. Doğrulama GEÇMEDİ.");
        }
    }
}
