package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {
//Create a class:FileDownloadTest
//downloadTest()
//In the downloadTest() method, do the following test:
//Go to https://the-internet.herokuapp.com/download
//Download flower.jpeg file
//Then verify if the file downloaded successfully
//Collapse
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        //  Download flower.jpeg file
        driver.findElement(By.linkText("flower.jpeg")).click();
        //   Then verify if the file downloaded successfully
        Thread.sleep(3000);

        //   I know the flower.jpeg will be in downloads folder if download is successful
        // to verify if a path exist in our download folder I follow these steps:
        //1. Find the path of flower.jpeg file
        //filePath=home directory+/Downloads folder + file name with extentions
        String flowerPath=System.getProperty("user.home")+"\\Desktop";

        boolean isExist = Files.exists(Paths.get(flowerPath));
        Assert.assertTrue(isExist);


    }
}
