package com.example.ilcarro.qa.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logIn() throws InterruptedException {
        clickByCss("[href='/login']");
        fillLoginForm("Ro+1610997475872@gmail.com", "Aa1234567");
        pause(2000);
        clickByCss("[type=submit]");

    }


    public boolean isRegistrationFromPresent() {
        return isElementPresent(By.xpath("//h2[contains(., 'Registration')]"));
    }


    public void selectCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void fillRegistrationForm(String fName, String lName, String email, String password) {
        type(By.cssSelector("#first_name"), fName);
        type(By.cssSelector("#second_name"), lName);


        System.out.println("email is: " + email);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }


    public void fillLoginForm(String email, String password) {
        typeByCss("[name=email]", email);
        typeByCss("[name=password]", password);
    }


    public void clickLogoutButtonOnHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void clickLoginButton() {
        clickByCss("[href='/login']");
    }

}
