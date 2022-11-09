package com.krafttecnologies.test.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){
        System.out.println("First Test First Assertion");
        Assert.assertEquals("title","title");


        System.out.println("First Test Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2(){
        System.out.println("Second Test Assertion");
        Assert.assertEquals("test2","test2");

    }

    @Test
    public void test3(){
        String expectedTitle="Kraft";
        String actualTitle="Krafttech";

        Assert.assertTrue(actualTitle.contains(expectedTitle),"verify that title starts with Kraft");
    }
    @Test
    public void test4(){
        //verify that email contains @ sign
        String email="KarafTexh@gmail.com";

//        if (email.contains("@")){
//            System.out.println("Pass");   //BUNUN YERİNE ASSERT KULLANALIM
//        }else{
//            System.out.println("Fail");
//        }
        Assert.assertTrue(email.contains("@")," must be cointain @ sign");
    }

    @Test
    public void test5(){
        Assert.assertFalse(1<2,"false ise true döner; true ise hata verir...");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("star","star"," eşitse hata verir, eşit değilse hata vermez..");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close browser");
    }
}
