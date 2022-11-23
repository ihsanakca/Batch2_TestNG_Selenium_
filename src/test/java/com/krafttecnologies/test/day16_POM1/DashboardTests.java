package com.krafttecnologies.test.day16_POM1;

import com.krafttecnologies.pages.DasboardPage;
import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.test.TestBase;
import com.krafttecnologies.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends TestBase {

    LoginPages loginPages=new LoginPages();

    DasboardPage dasboardPage=new DasboardPage();

    @Test
    public void navigateToTabAndModule() throws InterruptedException {

        loginPages.loginUser();
        dasboardPage.navigateToModule("Components","Charts");

        String actualSubTitleText=dasboardPage.subTitle("Charts");

        Assert.assertEquals(actualSubTitleText,"Charts","FAIL");

        Thread.sleep(3000);
    }

    @Test
    public void getUser(){
        loginPages.loginUser();
        String actualUserName = dasboardPage.usersNames("talip tiras");

        String expectedUserName="talip tiras";

        Assert.assertEquals(actualUserName,expectedUserName,"FAIL");

        System.out.println("actualUserName = " + actualUserName);

        BrowserUtils.waitFor(3);
    }

    @Test
    public void myProfile(){
        loginPages.loginUser();
        dasboardPage.myProfile_loc.click();
        BrowserUtils.waitFor(3);
    }

    @Test
    public void aFmTitle(){
        loginPages.loginUser();
        System.out.println("Title = " + dasboardPage.aFMTitle_loc.getText());
        BrowserUtils.waitFor(3);
    }

    @Test
    public void copyRight(){
        loginPages.loginUser();
        System.out.println("copyright.getText() = " + dasboardPage.copyright_loc.getText());
    }



}
