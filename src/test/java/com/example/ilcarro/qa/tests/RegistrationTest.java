package com.example.ilcarro.qa.tests;

import com.example.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @Test
    public void testRegistrationNegative() throws InterruptedException {
        app.getUserHelper().openRegForm();
        String email = "Ro+" + System.currentTimeMillis();
        app.getUserHelper().fillRegistrationForm(new User()
                .setfName("Katya")
                .setlName("Test")
                .setEmail(email)
                .setPassword("Aa7654321"));
        app.getUserHelper().selectCheckBox();
        app.getUserHelper().pause(2000);
        app.getUserHelper().clickYallaButtom();
        app.getUserHelper().pause(3000);

        Assert.assertTrue(app.getUserHelper().isRegistrationFromPresent());

    }

}
