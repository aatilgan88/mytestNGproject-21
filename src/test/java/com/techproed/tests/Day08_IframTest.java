package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day08_IframTest extends TestBase {

    //Create a class: Day08_IFrameTest
    //Create a method: iframeTest
    //Go to https://the-internet.herokuapp.com/iframe
    //Verify the Bolded text contains “Editor”
    //Locate the text box
    //Delete the text in the text box
    //Type “This text box is inside the iframe”
    //Verify the text Elemental Selenium text is displayed on the page

    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        //Verify the Bolded text contains “Editor”
        WebElement verifyBolded = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(verifyBolded.getText().contains("Editor"));

        //iframe xpath for iframe

        //1) switching using id
     //   driver.switchTo().frame("mce_0_ifr");//switching using id

        //2) switching using the 1st ipframe using index
       // driver.switchTo().frame(0);//switching using the 1st ipframe using index
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

        //3) switching to iframe using the iframe WebElement
        driver.switchTo().frame(iframeElement);//switching to iframe using the iframe WebElement

        //Locate the text box

        WebElement textBox=driver.findElement(By.xpath("//p"));

        //Delete the text in the text box

        textBox.clear();

        //Type "This text box is inside the iframe
        textBox.sendKeys("This text box is inside the iframe");


        //Verify the text Elemental Selenium text is displayed on the page
        //NOTE: Elemental Selenium Element is outside of the iframe, SO DRIVER MUST BE OUTSIDE OF IFRAME
        //driver.switchTo().parentFrame();//takes 1 level up
        driver.switchTo().defaultContent();//takes all the way up

        WebElement elementSelenium= driver.findElement(By.linkText("Element Selenium"));
        Assert.assertTrue(elementSelenium.isDisplayed());
        //<html>
        //               Element 1
        //<iframe>
        //               Element 2
        //    <iframe>
        //                Element 3
        //    </iframe>
        //</iframe>
        //</html>
    }





}
