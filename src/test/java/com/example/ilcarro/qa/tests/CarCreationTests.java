package com.example.ilcarro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarCreationTests extends TestBase {
    @Test
    public void testCarCreation() throws InterruptedException {
        app.getCarHelper().initAddingNewCar();
        //Assert.assertTrue(app.getCarHelper().isCarCreationFormPresent());
        app.getCarHelper().fillCarForm("Israel", "Herzel1", "500", "233-67-22", "Honda", "Civic", "2015", "HC325679YH",
                "6.5", "petrol", "full Drive", "4WD", "149", "120", "5", "5", "C", "Very good car",
                "no smoking", "55");
        app.getCarHelper().pause(3000);
        app.getCarHelper().clickYallaButtom();
    }

}
