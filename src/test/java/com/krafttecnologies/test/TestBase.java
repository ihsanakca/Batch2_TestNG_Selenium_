package com.krafttecnologies.test;

import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.utilities.ConfigurationReader;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

//    protected LoginPages loginPages;

    @BeforeTest
    public void setUp() {
        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(Driver.get(), 15);
        driver.manage().window().maximize();
        actions = new Actions(driver);
//        loginPages=new LoginPages();
    }

    @AfterTest  //@AfterMethod u @AfterClass yapınca hata gitti...
    public void tearDown() {

//        driver.quit();
//        Driver.closeDriver();
          driver.close();
    }

}
