package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class Day06_TestNGAnnotations {

    //@BeforeMethod : Runs before each method. Same as @Before in Junit
    //@Test : creates test case
    @BeforeMethod
    public void setUp(){
        System.out.println("Set Up Method");
    }

    @Test(priority = 3)
    public void test01(){
        System.out.println("Test 1");
    }

    //Ignore : SKIPS TEST CASE

    @Ignore
    @Test
    public void test02(){
        System.out.println("Test 2");
    }
    @Test(priority = 1)
    public void test03(){
        System.out.println("Test 3");
    }
    @Test(priority = 2)
    public void test04(){
        System.out.println("Test 1");
    }

    //@AfterMethod : Runs after each @Test annotation(after each method)
    //Same as @ After in Junit
    @AfterMethod
    public void tearDown(){
        System.out.println("Tear Down");
    }
    // By default, @Test runs in alphabetical order
    // @Test(priority=1) -> priority prioritize test cases
}
