package com.krafttecnologies.tests.day8_WebElements2;

import org.testng.Assert;
import org.testng.annotations.*;

public class SummaryOfTheLastLesson {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit runs");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test runs");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class runs");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method runs");
    }

    @Test
    public void test1(){
        Assert.assertTrue(4>2);
        System.out.println("test 1 runs");
    }

    @Test
    public void test2(){
        System.out.println("test 2 runs");
        Assert.assertFalse(1<2);

    }

    @Test
    public void test3(){
        Assert.assertEquals(1,1);
        System.out.println("test 3 runs");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method runs");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class runs");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test runs");
    }

    @AfterSuite
    public void AfterSuit(){
        System.out.println("Before Suit runs");
    }


}
