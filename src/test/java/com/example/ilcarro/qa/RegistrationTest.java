package com.example.ilcarro.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{


    @Test
    public void testRegistration() throws InterruptedException {
        openRegForm();
        String email = "Ro+"+System.currentTimeMillis()+"@gmail.com";
        fillRegistrationForm("Katya", "Test", email, "Aa1234567");
        selectCheckBox();
        pause(3000);
        clickYallaButtom();
        pause(2000);

        Assert.assertFalse(isRegistrationFromPresent());

    }
    @Test
    public void testRegistration2() throws InterruptedException {
        openRegForm();
        String email = "Ro1+"+System.currentTimeMillis()+"@yahoo.com";
        fillRegistrationForm("Melina", "Rahmaninov", email, "Aa7654321");
        selectCheckBox();
        pause(2000);
        clickYallaButtom();
        pause(3000);

        Assert.assertFalse(isRegistrationFromPresent());

    }

    @Test
    public void testRegistrationNegative() throws InterruptedException {
        openRegForm();
        String email = "Ro+"+System.currentTimeMillis();
        fillRegistrationForm("Katya", "Test", email, "Aa1234567");
        selectCheckBox();
        pause(2000);
        clickYallaButtom();
        pause(3000);

        Assert.assertTrue(isRegistrationFromPresent());

    }

}
