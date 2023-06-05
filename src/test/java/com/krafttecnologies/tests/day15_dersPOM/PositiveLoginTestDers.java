package com.krafttecnologies.tests.day15_dersPOM;

import com.krafttecnologies.pagesDers.DashboardPageDers;
import com.krafttecnologies.pagesDers.LoginPageDers;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTestDers extends TestBase {
    LoginPageDers loginPageDers=new LoginPageDers();
    DashboardPageDers dashboardPageDers=new DashboardPageDers();

    @Test
    public void loginTest(){
       loginPageDers.userEmail_loc.sendKeys(ConfigurationReader.get("userEmail"));
       loginPageDers.userPassword_loc.sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);
//        js.executeScript("arguments[0].scrollIntoView(true);"
//                + "arguments[0].click()", loginPageDers.submitBtn_loc);
//        actions.click(loginPageDers.submitBtn_loc);  ***** hata verir*****

       String actualName=dashboardPageDers.userName_loc.getText();
       String expectedName="Selim Gezer";

        Assert.assertEquals(actualName,expectedName,"should be same");
    }

}
