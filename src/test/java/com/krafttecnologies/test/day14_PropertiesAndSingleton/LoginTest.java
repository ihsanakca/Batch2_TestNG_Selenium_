package com.krafttecnologies.test.day14_PropertiesAndSingleton;

import com.krafttecnologies.pages.DasboardPage;
import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.test.TestBase;
import com.krafttecnologies.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    DasboardPage dasboardPage=new DasboardPage();
//    WebDriver driver;//buna gerek var mı?
    @Test
    public void openBrowserUsingConfigurationReader(){


        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.name("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password")
                        + Keys.ENTER);
//        wait.until(ExpectedConditions.visibilityOf(locator))
//        actions.
    }

    @Test
    public void loginWithMethod(){
        loginPages.loginUser();

        String actualTitle=dasboardPage.dashboardPageTitle("Dashboard");

        String expectedTitle="Dashboard";

        System.out.println("actualTitle = " + actualTitle);

        Assert.assertEquals(actualTitle,expectedTitle,"FAIL");
    }
}
