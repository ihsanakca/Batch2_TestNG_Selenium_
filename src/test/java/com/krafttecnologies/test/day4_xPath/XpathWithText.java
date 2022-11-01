package com.krafttecnologies.test.day4_xPath;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathWithText {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.krafttechexlab.com/index");
        String text=driver.findElement(By.xpath("//li[text()='All Users Profile']")).getText();
        System.out.println("text = " + text);
        String text2=driver.findElement(By.xpath("//li[.='All Users Profile']")).getText();
        System.out.println("text2 = " + text2);
        String text3=driver.findElement(By.xpath("//*[.='All Users Profile']")).getText();
        System.out.println("text3 = " + text3);
    }
}
