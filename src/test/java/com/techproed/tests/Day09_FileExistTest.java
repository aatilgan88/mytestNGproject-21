package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExistTest extends TestBase {
    @Test
    public void isExist(){
        //We can not automate desktop applications with selenium
        //But we can use JAVA to understand a file path exist in our computers


        //OR WE CAN GET THE PATH NAMICALLY USING JAVA
        String homePath=System.getProperty("user.home");
        System.out.println(homePath);
//     String pathOfFile="C:\\Users\\aatil\\Desktop";
        String pathOfFile=homePath+"\\Desktop";

        boolean isExist=Files.exists(Paths.get(pathOfFile));//Returns true if pathOfFile exist on the computer, returns false otherwise
        Assert.assertTrue(isExist);
    }

}
