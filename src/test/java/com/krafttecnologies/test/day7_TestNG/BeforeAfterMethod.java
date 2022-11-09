package com.krafttecnologies.test.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {



    @Test @Ignore
    public void logOut() {
        System.out.println("My Second Test Case Logout");
    }


    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

    //    @Test
    public void comment() {
        System.out.println("Test case comment");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @Test

    public void logIn() {
        System.out.println("My First Test Case Login");
    }

    @Test
    public void register() {
        System.out.println("My Fourth Test Case Register");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("------------After Class-----------");
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("------Before Class--------");
    }
}
