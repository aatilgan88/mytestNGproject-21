package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_FileUploadTest extends TestBase {
    @Test
    public void fileUploadTest() throws InterruptedException {
        //Class Name: FileUploadTest
        //Method Name: fileUploadTest
        //When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        //And click on the chooseFile button
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));

        //And selects an image from the computer
        //To handle input type="file", We send the path of the file to this input

        //FIND THE PATH OF THE FILE
        String homePath=System.getProperty("user.home");
        System.out.println(homePath);
        Thread.sleep(5000);
//     String pathOfFile="C:\\Users\\aatil\\Desktop";
        String pathOfFile=homePath+"\\Desktop";
        //SEND THE pathOfFile in the chooseFileButton
        chooseFileButton.sendKeys(pathOfFile);
        Thread.sleep(5000);

        //And click on the upload button
        driver.findElement(By.id("file-submit")).click();

        //Then verify the File uploaded!  Message displayed

        String uploadSuccessMessage= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(uploadSuccessMessage,"File uploaded!");

    }
}
