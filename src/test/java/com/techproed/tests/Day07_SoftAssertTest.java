package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Day07_SoftAssertTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }
    @Test
    public void softAssertTest(){
        //TC01: search for 'iphone 12' and verify title contains 'iphone'
        driver.findElement(By.name("q")).sendKeys("iphone 12"+ Keys.ENTER);
        String title1= driver.getTitle();

        //STEP 1: Create SoftAssert Object
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(title1.contains("iphone"));
        //Assert.assertTrue(title1.contains("iphone"));//Hard Assert
        //TC02: verify title contains 'porcelain teapot'
        softAssert.assertTrue(title1.contains("porcelain teapot"));
        //Assert.assertTrue(title1.contains("porcelain teapot"));
        //Since line 32 FAILED, rest of the code WILL NOT RUN. EXECUTION STOPS ON LINE 32

        //TC03: search for 'flower' and verify title contains 'flower'
        softAssert.assertTrue(title1.contains("flower"));
        //Assert.assertTrue(title1.contains("flowers"));

        //STEP 3: AssertAll to mark the test case as PASS or FAIL
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
