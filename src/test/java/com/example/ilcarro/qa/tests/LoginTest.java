package com.example.ilcarro.qa.tests;

import com.example.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        /*if user logged in, logout*/
        if (app.getUserHelper().isUserLoggedIn()) {
            app.getUserHelper().clickLogoutButtonOnHeader();
        }
    }


    @Test(dataProvider = "validLogin")
    public void testLoginDataProvider(String email, String password) throws InterruptedException {
        logger.info("\n user name is" + email + "\n user password" + password);
        app.getUserHelper().clickLoginButton();
        // click(By.cssSelector("[href='/login']"));
        app.getUserHelper().fillLoginForm(new User()
                .setEmail(email)
                .setPassword(password));
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButtom();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

        logger.info("Test Passed");

        String screenshot = "src/test/screenshorts-" +System.currentTimeMillis()+".png";
        app.getUserHelper().takeScreenShort(screenshot);


    }

    @Test(dataProvider = "validLoginCsv")
    public void testLoginDataProviderCsv(User user) throws InterruptedException {
        logger.info("\nuser name is " + user.getEmail() + "\n user password is " + user.getPassword());        app.getUserHelper().clickLoginButton();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButtom();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

        logger.info("Test Passed");

        String screenshot = "src/test/screenshorts-" + System.currentTimeMillis() + ".png";
        app.getUserHelper().takeScreenShort(screenshot);
    }
    @Test
    public void testLoginSanity() throws InterruptedException {
        logger.info("\n user name is Ro+1610997475872@gmail.com \n user password is Aa1234567");
        app.getUserHelper().clickLoginButton();
    // click(By.cssSelector("[href='/login']"));
        app.getUserHelper().fillLoginForm(new User()
                .setEmail("Ro+1610997475872@gmail.com")
                .setPassword("Aa1234567"));
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButtom();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());

        logger.info("Test Passed");

    String screenshot = "src/test/screenshorts-" +System.currentTimeMillis()+".png";
        app.getUserHelper().takeScreenShort(screenshot);




}
    @DataProvider
    public Iterator<Object []> validLogin (){
        List <Object []> list = new ArrayList<>();
        list.add(new Object[]{"Ro+1610997475872@gmail.com","Aa1234567"});
        list.add(new Object[]{"Ro+1611853505339@gmail.com","Aa1234567"});
        list.add(new Object[]{"Ro+1611853575479@gmail.com","Aa1234567"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object []> validLoginFromCSV () throws IOException {
        List <Object []> list = new ArrayList<>();
        BufferedReader reader  = new BufferedReader (new FileReader(new File("src/test/resources/validLoginCsv")));

       String line =  reader.readLine();
       while(line != null){
           String[] split = line.split(";");
           list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
           line = reader.readLine();
       }

        return list.iterator();
    }
}
