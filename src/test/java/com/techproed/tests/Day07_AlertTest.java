package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day07_AlertTest {
    //Go to https://the-internet.herokuapp.com/javascript_alerts
    //Create a class: AlertTest
    //Create setUp method
    //Create 3 test methods:
    //acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert”
    //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
    //sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void acceptAlert(){
        //acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfully clicked an alert”
        WebElement firstButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        firstButton.click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();//accept()=ok

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }
    @Test
    public void dismissAlert(){
        //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
        WebElement dismissButtton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        dismissButtton.click();
        String confirmText = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();

        String dismissResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(dismissResult, "You clicked: Cancel");
    }
    @Test
    public void sendKeysAlert(){
        //click on the third alert
        WebElement thirdAlert = driver.findElement((By.xpath("//button[@onclick='jsPrompt()']")));
        thirdAlert.click();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"I am a JS prompt");

        driver.switchTo().alert().sendKeys("Hello Word");

        driver.switchTo().alert().accept();

        String result =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "Hello Word");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
