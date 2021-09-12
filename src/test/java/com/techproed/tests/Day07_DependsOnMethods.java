package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07_DependsOnMethods {

    @Test
    public void logIn(){
        System.out.println("Login Test");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "logIn")//logIn runs before the homePage
    public void homePage(){          //hemPage method only runs if logIn PASS.
                                     // Otherwise homePage will be SKIPPED
                                     //homePage depends on logIn
        System.out.println("Home Page Test");
    }
    @Test(priority = 1)
    public void search(){
        System.out.println("Search Test");
    }
    @Test(priority = 2)
    public void searchResultTest(){
        System.out.println("Search Result Test");
    }
}
