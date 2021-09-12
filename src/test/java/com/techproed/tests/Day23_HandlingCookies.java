package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class Day23_HandlingCookies extends TestBase {

    @Test
    public void handleCookies(){
        /*
        -It is created by the browser temporarily.
        -Cookies are stored in our computers as we visit the websites
        -We can automate handling cookies:
                -find the cookies
                -add new cookies
                -delete cookies
         */
        driver.get("https://www.amazon.com");
        //getCookies() returns all of the cookies
        Set<Cookie> allCookies =driver.manage().getCookies();

        // 1. find total number of cookies.
        int numOfCookies = allCookies.size();
        System.out.println("Num Of Cookies: "+ numOfCookies);

        //2.Print akk cookies
        for(Cookie eachCookies:allCookies){
            System.out.println("Name : "+ eachCookies.getName());
            System.out.println("Value :"+ eachCookies.getValue());
        }

        //3. Get cookies by name
        System.out.println("Cookie named i18n-prefs :"+driver.manage().getCookieNamed("i18n-prefs"));


        //4. Add new cookie
        Cookie myCookies=new Cookie("MyBestCookies","123456");
        driver.manage().addCookie(myCookies);
        allCookies = driver.manage().getCookies();
        int newNumberOfCookies=allCookies.size();
        System.out.println("New Number of Cookies :"+newNumberOfCookies);//8

        //5. Delete cookies
        driver.manage().deleteCookieNamed("session-token");
        allCookies=driver.manage().getCookies();
        System.out.println("Number of cookies :"+ allCookies.size());//7


        //6. Delete all cookies
        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("Number of Cookies : "+allCookies.size());//0
    }

}
