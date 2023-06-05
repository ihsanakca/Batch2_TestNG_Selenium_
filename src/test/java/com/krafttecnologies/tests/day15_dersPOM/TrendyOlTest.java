package com.krafttecnologies.tests.day15_dersPOM;

import com.krafttecnologies.pagesDers.SarjCihazlari;
import com.krafttecnologies.pagesDers.TrendyOlBasePage;
import com.krafttecnologies.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrendyOlTest extends TestBase {
   TrendyOlBasePage trendyOlBasePage=new TrendyOlBasePage();
   SarjCihazlari sarjCihazlari=new SarjCihazlari();
  @Test
  public void test1(){
      trendyOlBasePage.clickCookies();

      System.out.println("trendyOlBasePage.mainTabsNamesList() = " + trendyOlBasePage.mainTabsNamesList());
      System.out.println("------------");
      System.out.println("trendyOlBasePage.mainTabsNamesList2() = " + trendyOlBasePage.mainTabsNamesList2());
  }

    @Test
    public void test2(){
        trendyOlBasePage.clickCookies();

        trendyOlBasePage.navigateToTabAndModule("Elektronik","Şarj Cihazları");
        String actualText=sarjCihazlari.searchingSarjCihaz_loc.getText();
        String expectedText="Şarj Cihazları";
        Assert.assertEquals(actualText,expectedText,"Fail");
    }

}
