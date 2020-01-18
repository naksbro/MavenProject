package io.techleadacademy.tests;

import io.techleadacademy.pages.HomePage;
import io.techleadacademy.pages.MyAccountPage;
import io.techleadacademy.pages.RegisterPage;
import io.techleadacademy.testData.NewUserInfo;
import io.techleadacademy.util.DateUtils;
import io.techleadacademy.util.UtilityMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPageTest extends MyAccountPage {
    @Test
    public void verifyMyAccount () {
        HomePage home = new HomePage();
        RegisterPage reg = new RegisterPage();
        MyAccountPage acc = new MyAccountPage();
        NewUserInfo user = new NewUserInfo();
        UtilityMethods util = new UtilityMethods();
        DateUtils date = new DateUtils();
        home.clickSignUp();
        reg.fillSignUpForm();
        reg.clickSignUpBtn();
        util.sleep(2000);
        Assert.assertEquals(acc.actualHi.getText(),"Hi, "+user.getFirstName()+" "+user.getLastName());
        Assert.assertEquals(acc.actualDate.getText(), date.getCurrentFormattedDate());
    }
}
