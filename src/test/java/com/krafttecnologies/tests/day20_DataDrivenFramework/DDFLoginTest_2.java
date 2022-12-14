package com.krafttecnologies.tests.day20_DataDrivenFramework;

import com.krafttecnologies.pages.DasboardPage;
import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.ConfigurationReader;
import com.krafttecnologies.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest_2 extends TestBase {
    @DataProvider(name="QaTeam2_Data")
    public Object[][] userData2(){
        ExcelUtil qaTeam2=new ExcelUtil(ConfigurationReader.get("excelFilePath"),"QaTeam2");

        String [][] userDataArray= qaTeam2.getDataArrayWithoutFirstRow();

        return userDataArray;
    }

    @Test(dataProvider = "QaTeam2_Data")
    public void userLoginTest2(String name, String email, String password){

        extentLogger=report.createTest("ExcelUserName Test2");

        extentLogger.info("Open the login Page");
        LoginPages loginPages=new LoginPages();
        DasboardPage dasboardPage=new DasboardPage();

        extentLogger.info("take the credentials from excel and type in the bars");
        loginPages.loginWithParameter(email,password);

        extentLogger.info("verify that the user dashboard page is true by using username");
        String expectedName=name;
        String actualName=dasboardPage.getUserName();

        Assert.assertEquals(actualName,expectedName,"verify that the names are equal");

        extentLogger.pass("PASSED");



    }


}
