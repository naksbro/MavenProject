package io.techleadacademy.tests;

import io.techleadacademy.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test
    public void verifyTitle () {
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "PHPTRAVELS | Travel Technology Partner");
    }
}
