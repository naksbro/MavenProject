package io.techleadacademy.tests;

import io.techleadacademy.pages.HomePage;
import io.techleadacademy.pages.MyAccountPage;
import io.techleadacademy.pages.RegisterPage;
import io.techleadacademy.testData.NewUserInfo;
import io.techleadacademy.util.DateUtils;
import io.techleadacademy.util.Screenshots;
import io.techleadacademy.util.SeleniumUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPageTest extends MyAccountPage {
    @Test
    public void verifyMyAccount () {
        HomePage home = new HomePage();
        RegisterPage reg = new RegisterPage();
        NewUserInfo user = new NewUserInfo();
        DateUtils date = new DateUtils();
        Screenshots.captureScreenShot("shot1");
        home.clickSignUp();
        reg.fillSignUpForm();
        reg.clickSignUpBtn();
        SeleniumUtils.sleep(2000);
        Screenshots.captureScreenShot("shot2");
        Assert.assertEquals(home.getTitle(),"My Account");
        Assert.assertEquals(actualHi.getText(),"Hi, "+user.getFirstName()+" "+user.getLastName());
        Assert.assertEquals(actualDate.getText(), date.getCurrentFormattedDate());
    }
}
