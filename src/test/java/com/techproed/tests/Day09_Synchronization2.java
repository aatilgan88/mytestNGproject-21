package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_Synchronization2 extends TestBase {
    //Create a class:Day09_Synchronization2. Create a method: isEnabled
    //Go to https://the-internet.herokuapp.com/dynamic_controls
    //Click enable Button
    //And verify the message is equal to “It's enabled!”
    //And verify the textbox is enabled (I can type in the box)

    //HOMEWORK:
    //And click on Disable button
    //And verify the message is equal to “It's disabled!”
    //And verify the textbox is disabled (I cannot type in the box)
    @Test
    public void synchronization2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Click enable button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        //And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement enabledMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String enabledMessageText=enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

        //And verify the textbox is enabled (I can type in the box)
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());//isEnabled checks if an element is enabled. Returns true if enabled, returns false if disabled

}}
