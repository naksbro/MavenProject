package io.techleadacademy.tests;

import io.techleadacademy.pages.HomePage;
import io.techleadacademy.pages.RegisterPage;
import io.techleadacademy.util.UtilityMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends RegisterPage {
    @Test
    public void verifyRegistration () {
        HomePage home = new HomePage();
        RegisterPage reg = new RegisterPageTest();
        UtilityMethods util = new UtilityMethods();
        home.clickSignUp();
        String regTitle = getTitle();
        reg.fillSignUpForm();
        reg.clickSignUpBtn();
        util.sleep(2000);
        String myAccTitle = getTitle();
        Assert.assertNotEquals(regTitle, myAccTitle);
    }
}
