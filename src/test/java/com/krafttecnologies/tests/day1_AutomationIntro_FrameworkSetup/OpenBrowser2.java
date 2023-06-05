package com.krafttecnologies.tests.day1_AutomationIntro_FrameworkSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser2 {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();

        WebDriver driver1=new EdgeDriver();
        driver1.get("https://www.google.com");
    }
}
