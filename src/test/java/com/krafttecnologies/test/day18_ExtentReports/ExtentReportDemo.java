package com.krafttecnologies.test.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttecnologies.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    //this is used for starting and building reports
    ExtentReports report;

    //this class is used for to create HTML report file
    ExtentHtmlReporter htmlReporter;

    // this class define a test, anable adding logs, author and test step
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp() {

        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + "/test-output/report.html";

        //initialize the HTML report with the report path
        htmlReporter = new ExtentHtmlReporter(reportPath);

        //attach the HTML report to the report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("KraftTechB2 Smoke Test");

        //set enviroment information
        report.setSystemInfo("Environment", "Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "İhsan Akçair");


    }

    @Test
    public void test1() {
        //give a name to current
        extentLogger=report.createTest("TC001 Login Test");

        //test steps
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to URL:https://www.krafttechexlab.com/login");
        extentLogger.info("Enter Username");
        extentLogger.info("Enter Password");
        extentLogger.info("Click Login Button");
        extentLogger.info("Verify Logged in");
        extentLogger.info("TC001 Login Test is Passed");

    }

    @AfterMethod
    public void tearDown() {
        //this is when the report is actually created
        report.flush();
    }
}
