package com.example.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver wd;


    @BeforeMethod
    public void setUp (){
        wd = new ChromeDriver();
    wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    @Test
    public void testRegistration (){
        //open reg Form
        wd.findElement(By.cssSelector("[href='/signup']")).click();

        //wd.findElement(By.cssSelector("[href='/car']")).click();
        wd.findElement(By.id("first_name")).click();
        wd.findElement(By.id("first_name")).clear();
        wd.findElement(By.id("first_name")).sendKeys("Katya");



        //fill RegForm
        wd.findElement(By.name("address")).click();



    }

    @AfterMethod
    public void tearDown (){

    }

}
