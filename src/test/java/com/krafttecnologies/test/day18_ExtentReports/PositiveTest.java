package com.krafttecnologies.test.day18_ExtentReports;

import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.test.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    @Test
    public void loginTest1(){
        LoginPages loginPages=new LoginPages();
        extentLogger=report.createTest("Test1");
        loginPages.loginUser();
        System.out.println("1");
    }
    @Test
    public void loginTest2(){
        LoginPages loginPages=new LoginPages();
        extentLogger=report.createTest("Test2");
        loginPages.loginUser();
        System.out.println("2");
    }


}
