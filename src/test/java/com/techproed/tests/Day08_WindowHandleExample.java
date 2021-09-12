package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day08_WindowHandleExample extends TestBase {

    @Test
    public void windowHandle(){
        //Create a new Class Tests package: Day08_WindowHandleExample
        //Method name:windowHandle
        //Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //Then user verifies the text : “Opening a new window”
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
        //Then user verifies the title of the page is “The Internet”
        Assert.assertEquals(driver.getTitle(),"The Internet");
        //When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();


        //Then user verifies the new window title is “New Window”
        //Then user verifies the text:  “New Window”
        //When user goes back to the previous window and then verifies the title : “The Internet”


        // Driver is on the Window 1:
      //  System.out.println(driver.getCurrentUrl());
        String window1 = driver.getWindowHandle();//returns the id of the current window

        Set<String> allWindows=driver.getWindowHandles();//returns all windows.
        //How do you handle multiple windows?
        //switch to the windows.

        for(String eachWindow:allWindows){
            //System.out.println("Window Handles :" +eachWindow);
            //If driver is already on window1 then do not switch
            //if driver is not on window1 then switch to the other window
            if(!eachWindow.equals(window1)){
            driver.switchTo().window(eachWindow);
            System.out.println(driver.getCurrentUrl());
        }

    }

        //Now driver is on window 2
        //Then user verifies the new window title is "New Window"
        Assert.assertEquals(driver.getTitle(),"New Window");

        //print the heading text New Window
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        // When user goes back to the previous window and then verifies the title : "The Internet"

        //DRIVER IS ON WINDOW 2
        String window2 = driver.getWindowHandle();
        for(String eachWindow:allWindows){
            //System.out.println("Window Handles :" +eachWindow);
            //If driver is already on window2 then do not switch
            //if driver is not on window2 then switch to the other window
            if(!eachWindow.equals(window2)){
                driver.switchTo().window(eachWindow);
                System.out.println(driver.getCurrentUrl());
            }

        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"The Internet");

}

}
