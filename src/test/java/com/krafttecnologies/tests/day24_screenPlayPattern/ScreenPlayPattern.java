package com.krafttecnologies.tests.day24_screenPlayPattern;

import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScreenPlayPattern {
    @Test
    public void SPP_Test1() {


        Driver.get().navigate().to("https://www.google.com/");

// Search for a phrase
        Driver.get().findElement(By.xpath("//input[@name='q']")).sendKeys("Virgosol" + Keys.ENTER);

        Driver.get().findElement(By.xpath("//a[text()='Görseller']")).click();
        BrowserUtils.waitFor(2);


        Driver.get().quit();
    }
}
