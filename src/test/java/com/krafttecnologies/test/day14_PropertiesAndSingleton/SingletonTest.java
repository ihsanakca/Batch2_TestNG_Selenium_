package com.krafttecnologies.test.day14_PropertiesAndSingleton;

import com.krafttecnologies.utilities.ConfigurationReader;
import com.krafttecnologies.utilities.Driver;
import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

//    @Test
//    public void test1(){
//       // Singleton singleton=new Singleton();//obje oluşturmaya müsaade etmiyor
//        String driver1=Singleton.getInstance();
//        String driver2=Singleton.getInstance();
//
//        System.out.println(driver1);
//        System.out.println(driver2);
//    }
//
//    @Test
//    public void test2() {
//        //WebDriver driver = WebDriverFactory.getDriver("chrome");
//
//        WebDriver driver= Driver.get();
//
//        driver.get(ConfigurationReader.get("url"));
//    }
    @Test
    public void test3(){
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();
        driver.get("https://www.google.com.tr/");
//        Driver.closeDriver();
    }

    @Test
    public void test4() {
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();
        driver.get("https://www.amazon.com.tr/");
    }
}
