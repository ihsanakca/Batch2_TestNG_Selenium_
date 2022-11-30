package com.krafttecnologies.tests.day19_reviewAndXmlRunner;

import com.krafttecnologies.pages.DasboardPage;
import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.pages.ProfilePage;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {

    @Test
    public void userInfoTest1(){

        /** Class Task
         * go to https://www.krafttechexlab.com/login web site
         * Login as a user
         * Verify that login is successful with account name
         * Click on My profile
         * Click on Edit Profile
         * Verify that email value
         * navigate back
         * Verify that Dashboard page with url
         *
         */
       // driver.get(ConfigurationReader.get("url"));
        extentLogger=report.createTest("My Profile Test1");

        LoginPages loginPages=new LoginPages();
        DasboardPage dasboardPage=new DasboardPage();
        ProfilePage profilePage=new ProfilePage();

        extentLogger.info("Go to URL:https://www.krafttechexlab.com/login");
        extentLogger.info("Enter site with correct userEmail and password");
        loginPages.loginUser();

        String expectedAccountName="Selim Gezer";
        extentLogger.info("verify that login is successuful with account name= "+expectedAccountName);
        String actualAccountName=loginPages.getAccountName_mtd(expectedAccountName);

        Assert.assertEquals(actualAccountName,expectedAccountName);

        extentLogger.info("click to my profile button");
        //dasboardPage.myProfile_loc.click();
        dasboardPage.navigateToModule("My Profile","");

        BrowserUtils.waitFor(3);

        String profileTab="Edit Profile";
        extentLogger.info("tab to edit profile");
        profilePage.profileTabs(profileTab);

        String expectedEmail="sgezer@gmail.com";
        String actualEmail=profilePage.profileEmail_loc.getAttribute("value");
        extentLogger.info("verify that email is= "+expectedEmail);
        Assert.assertEquals(actualEmail,expectedEmail);

        extentLogger.info("navigate to previous page");
        driver.navigate().back();

        extentLogger.info("verify that driver is at the dashbord");
        String actualDashboardText = dasboardPage.dashboardPageTitle("Dashboard");

        Assert.assertEquals(actualDashboardText,"Dashboard");

        extentLogger.pass("PASSED");

    }
}
