package com.krafttecnologies.tests.day17_POM2;

import com.krafttecnologies.pages.DashboardPage;
import com.krafttecnologies.pages.LoginPages;
import com.krafttecnologies.pages.ProfilePage;
import com.krafttecnologies.tests.TestBase;
import com.krafttecnologies.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProfileTest extends TestBase {
    LoginPages loginPages = new LoginPages();
    ProfilePage profilePage = new ProfilePage();
    DashboardPage dasboardPage = new DashboardPage();

    @Test
    public void editProfile() {
        loginPages = new LoginPages();
        dasboardPage = new DashboardPage();
        profilePage = new ProfilePage();

        loginPages.loginUser();
        //dasboardPage.myProfile_loc.click();
        dasboardPage.navigateToModule("Selim Gezer","My Profile");
        profilePage.profileTabs("Edit Profile");


        profilePage.fullName.clear();
        profilePage.fullName.sendKeys("Selim Gezer");

        profilePage.about.sendKeys("Some words are here...");

        profilePage.company.clear();
        profilePage.company.sendKeys("KraftTech");

        BrowserUtils.waitForPresenceOfElement(By.cssSelector("#terms"), 5);

        BrowserUtils.dragAndDropBy(profilePage.slider, 150, 0);

        Select select = new Select(profilePage.job);
        select.selectByVisibleText("QA Automation Engineer");

        profilePage.website.clear();
        profilePage.website.sendKeys("https://www.krafttechnologie.com");

        profilePage.location.clear();
        profilePage.location.sendKeys("İstanbul");

        profilePage.skills.clear();
        profilePage.skills.sendKeys("Java,Selenium, TestNG, Cucumber");

//        profilePage.save.click();-->çalışmıyor... scroll yaparak denenebilir...
        BrowserUtils.clickWithJS(profilePage.save);

        BrowserUtils.waitFor(3);

    }

    @Test
    public void addExperience(){
        loginPages = new LoginPages();
        dasboardPage = new DashboardPage();
        profilePage = new ProfilePage();

        loginPages.loginUser();
      //  dasboardPage.myProfile_loc.click();
        dasboardPage.navigateToModule("Selim Gezer","My Profile");
        profilePage.profileTabs("Add Experience");

        profilePage.jobTitle.clear();
        profilePage.jobTitle.sendKeys("Tester");

        profilePage.companyexperience.clear();
        profilePage.companyexperience.sendKeys("KraftTech, Akın Software");

        profilePage.locationExperience.clear();
        profilePage.locationExperience.sendKeys("İstanbul, Ankara, İzmir");

        profilePage.startYear.clear();
        profilePage.startYear.sendKeys("02/02/2022");

        profilePage.endYear.clear();
        profilePage.endYear.sendKeys("05/05/2022");

        profilePage.jobDescription.clear();
        profilePage.jobDescription.sendKeys("junior tester");

      profilePage.addExperienceBtn.click();
     //   BrowserUtils.clickWithJS(profilePage.addExperienceBtn);

        BrowserUtils.waitFor(3);
    }
}
