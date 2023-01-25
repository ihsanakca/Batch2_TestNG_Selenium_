package com.krafttecnologies.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttecnologies.utilities.BrowserUtils;
import com.krafttecnologies.utilities.ConfigurationReader;
import com.krafttecnologies.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    //exstent report
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;


    @BeforeTest
    public void setUpTest() {

    }

    @AfterTest
    public void tearDownTest() {
        //Driver.closeDriver();
    }

    @BeforeSuite
    public void setUpSuite() {


    }

    @AfterSuite
    public void tearDown() {
        Driver.closeDriver();
    }

    @BeforeClass
    public void setupClass() {
        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        //driver.get("https://testautomationpractice.blogspot.com");
       // driver.get("https://goqr.me/");
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        // String reportPath = projectPath + "/test-output/report.html";
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String reportPath = projectPath + "/test-output/report" + date + ".html";

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

    @AfterClass()
    public void teardownClass() {
        report.flush();
        // Driver.closeDriver();
    }


    @BeforeMethod
    public void setUp() {

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(Driver.get(), 15);
        // driver.manage().window().maximize();
        actions = new Actions(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
// If test fails
        if (result.getStatus() == ITestResult.FAILURE) {

            //Record the name of failed test
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //add screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //capture the exception and put inside to the report
            extentLogger.fail(result.getThrowable());
        }
//        driver.quit();
        //       Driver.closeDriver();
//        driver.close();
    }

}
