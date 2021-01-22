package com.example.ilcarro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @Test
    public void testRegistration() throws InterruptedException {
        app.getUserHelper().openRegForm();
        String email = "Ro+" + System.currentTimeMillis() + "@gmail.com";
        app.getUserHelper().fillRegistrationForm("Katya", "Test", email, "Aa1234567");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(3000);
        app.getUserHelper().clickYallaButtom();
        app.getUserHelper().pause(2000);

        Assert.assertFalse(app.getUserHelper().isRegistrationFromPresent());

    }

    @Test
    public void testRegistration2() throws InterruptedException {
        app.getUserHelper().openRegForm();
        String email = "Ro1+" + System.currentTimeMillis() + "@yahoo.com";
        app.getUserHelper().fillRegistrationForm("Melina", "Rahmaninov", email, "Aa7654321");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButtom();
        app.getUserHelper().pause(3000);

        Assert.assertFalse(app.getUserHelper().isRegistrationFromPresent());

    }

    @Test
    public void testRegistrationNegative() throws InterruptedException {
        app.getUserHelper().openRegForm();
        String email = "Ro+" + System.currentTimeMillis();
        app.getUserHelper().fillRegistrationForm("Katya", "Test", email, "Aa1234567");
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButtom();
        app.getUserHelper().pause(3000);

        Assert.assertTrue(app.getUserHelper().isRegistrationFromPresent());

    }

}
