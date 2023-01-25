package com.krafttecnologies.tests.day20_DataDrivenFramework;

import com.krafttecnologies.pages.DashboardPage;
import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.ConfigurationReader;
import com.krafttecnologies.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData() {
        //ExcelUtil classından bir obje oluşturuyotuz..
        //iki parametre giriyoruz: excel file path ve sayfa(sheet)

        ExcelUtil qaTeam3 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam3");
        String[][] dataArray = qaTeam3.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void loginTestWithDDF(String email, String password, String yourName) {
        extentLogger=report.createTest("ExcelUserName Test3");

        LoginPages loginPages = new LoginPages();
        DashboardPage dasboardPage = new DashboardPage();



        loginPages.loginWithParameter(email,password);
        String actualName = dasboardPage.getUserName();
        String expectedName=yourName;
        Assert.assertEquals(actualName,expectedName,"verify that names are same");


      driver.findElement(By.xpath("//span[@class='d-none d-md-block dropdown-toggle ps-2']")).click();
       driver.findElement(By.xpath("//span[normalize-space()='Sign Out']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
        extentLogger.pass("PASSED");
    }
}
