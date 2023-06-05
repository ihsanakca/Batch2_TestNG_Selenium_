package com.krafttecnologies.tests.day15_dersPOM;

import com.krafttecnologies.pagesDers.HepsiBuradaBasePage;
import com.krafttecnologies.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HepsiBuradaTabModule extends TestBase {
HepsiBuradaBasePage hepsiBuradaBasePage=new HepsiBuradaBasePage();
    @Test
    public void hepsiBuradaNavigateToModuleTest() {
        //driver.get("https://www.hepsiburada.com/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        hepsiBuradaBasePage.hepsiBuradaTabModule2("Spor, Outdoor", "Çadır");
    }

    @Test
    public void hepsiBuradaElektronikModule(){
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        hepsiBuradaBasePage.elektronikTabModule("Beyaz Eşya","Bulaşık Makineleri");
    }


}
