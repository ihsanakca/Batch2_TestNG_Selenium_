package com.krafttecnologies.tests.day18_ExtentReports;

import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {


    @Test
    public void wrongUsername() {

        extentLogger = report.createTest("Wrong Username Test");


        LoginPages loginPages = new LoginPages();
        BrowserUtils.waitFor(1);

        extentLogger.info("Enter Wrong Username");
        loginPages.userEmailInput_loc.sendKeys("some username");

        extentLogger.info("Enter correct password");
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Click login button");
        loginPages.submitButton_loc.click();

        String actualMessage = loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");

        Assert.assertEquals(actualMessage, "Email address is incorrect. Please check");

        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword() {

        extentLogger = report.createTest("Wrong Password Test");


        LoginPages loginPages = new LoginPages();
        BrowserUtils.waitFor(1);

        extentLogger.info("Enter correct Username");
        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("Enter wrong password");
        loginPages.passwordInput_loc.sendKeys("some passwords here");

        extentLogger.info("Click login button");
        loginPages.submitButton_loc.click();

        String actualMessage = loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");

        Assert.assertEquals(actualMessage, "Password is incorrect. Please check");

        extentLogger.pass("PASSED");


    }

}
