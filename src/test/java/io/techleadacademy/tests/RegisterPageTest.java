package io.techleadacademy.tests;

import io.techleadacademy.pages.HomePage;
import io.techleadacademy.pages.RegisterPage;
import io.techleadacademy.util.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends RegisterPage {
    @Test
    public void verifyRegistration () {
        HomePage home = new HomePage();
        home.clickSignUp();
        String regTitle = getTitle();
        fillSignUpForm();
        clickSignUpBtn();
        SeleniumUtils.sleep(2000);
        String myAccTitle = getTitle();
        Assert.assertNotEquals(regTitle, myAccTitle);
    }
}
