package com.example.ilcarro.qa.tests;

import com.example.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        /*if user logged in, logout*/
        if (app.getUserHelper().isUserLoggedIn()) {
            app.getUserHelper().clickLogoutButtonOnHeader();
        }
    }


    @Test
    public void testLogin() throws InterruptedException {
        app.getUserHelper().clickLoginButton();
        // click(By.cssSelector("[href='/login']"));
        app.getUserHelper().fillLoginForm(new User()
                .setEmail("Ro+1610997475872@gmail.com")
                .setPassword("Aa1234567"));
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButtom();

        Assert.assertTrue(app.getUserHelper().isUserLoggedIn());


    }

}