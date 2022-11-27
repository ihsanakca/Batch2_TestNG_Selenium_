package com.krafttecnologies.tests.day4_xPath;

import com.krafttecnologies.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RelativeXPath {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("edge");
        driver.get("https://www.hepsiburada.com/");

        String text=driver.findElement(By.xpath("(//a[@href='https://www.hepsiburada.com/cozummerkezi'])[1]")).getText();
        System.out.println(text);
        String text1=driver.findElement(By.xpath("(//a[@*='https://www.hepsiburada.com/cozummerkezi'])[1]")).getText();
        System.out.println(text1);

        driver.close();

    }
}
