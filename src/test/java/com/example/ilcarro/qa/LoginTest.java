package com.example.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        /*if user logged in, logout*/
        if(isUserLoggedIn()){
            clickLogoutButtonOnHeader();
        }
    }


    @Test
    public void testLogin() throws InterruptedException {
        clickLoginButton();
        // click(By.cssSelector("[href='/login']"));
        fillLoginForm("Ro+1610997475872@gmail.com", "Aa1234567");
        pause(2000);
        clickYallaButtom();

        Assert.assertTrue(isUserLoggedIn());


    }

}
