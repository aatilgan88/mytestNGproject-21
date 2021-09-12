package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day09_ActionsClass3 extends TestBase {
    //Create a class: ActionsClass3
    //Create test method : keysUpDown()
    //Go to google
    //Send iPhone X prices => convert small letter capital vice versa.
    //Highlight the search box by double clicking
    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        //searchBox.sendKeys("iPhone X prices");  //Normal Search
        Actions actions = new Actions(driver);
        //actions.keyDown("WEBELEMENT","COMMAND LIKE KeysUp OR KeysDown");
        actions.
                keyDown(searchBox, Keys.SHIFT).  // Pressing SHIFT on keyboard
                sendKeys("iPhone X prices").     //sending small letter and expecting capitol letters being typed
                keyUp(searchBox,Keys.SHIFT).     //Unpressing SHIFT on keyboard
                sendKeys().                      //sending normal letters because no longer pressing shift
                perform();                       //performing the task


    }
}
