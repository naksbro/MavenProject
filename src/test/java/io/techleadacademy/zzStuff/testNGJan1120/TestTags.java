package io.techleadacademy.zzStuff.testNGJan1120;

import io.techleadacademy.util.UtilityMethods;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;

public class TestTags {

    @Test(description = "Adding positive numbers")
    public void add1 (Method meth) {
        int actual = 6;
        Assert.assertTrue(actual == 6);
        Test test = meth.getAnnotation(Test.class);
        System.out.println(test.description());
    }

    @Test
    public void add2 () {
        int actual = -5;
        Assert.assertTrue(actual == -10 + 5);
    }
    @Test(priority = -2, groups = {"smoke","regression"}) // reorder
    public void subtract () {
        int actual = 3;
        Assert.assertEquals(actual, 6-3);
    }

    @Test(priority = -1, groups = {"smoke"}) // reorder
    public void subtract2 () {
        int actual = -2;
        Assert.assertEquals(actual, -1-1);
    }

    @Test()
    public void _001multiply () { // _001 reorder test cases

    }

    @Test(expectedExceptions = Exception.class, groups = {"regression"})
    public void divide () {
        Assert.assertEquals(4/0,0);
    }

    @Test(expectedExceptions = {NoSuchElementException.class, ElementNotVisibleException.class, ElementNotInteractableException.class, ArithmeticException.class})
    public void divide2 () {
        Assert.assertEquals(4/0,0);
    }

    @Test(enabled = false)
    public void signUpTest () {
        String invalidPW = " ";
        String validPW = "123456";
        Assert.assertTrue(invalidPW.equals(validPW));
    }

    @Test(invocationCount = 3, invocationTimeOut = 5000) // runs specified test multiple times
    public void logInPerformanceTest () {
        System.out.println("Checking log in time");
        new UtilityMethods().sleep(1000);
    }

    @Test(invocationCount = 10, skipFailedInvocations = true)
    public void logInPerformanceTest2 () {
        Assert.fail();
    }

    @Parameters({"username", "password"})
    @Test
    public void testUserName (String username, String password) {
        Reporter.log("Testing log in functionality using valid credentials");
        String actual = "Your name";
        Assert.assertEquals(actual, username);
        System.out.println("username: "+ username);
    }

    @Parameters({"username", "password"})
    @Test
    public void testUserName1 (@Optional("XxX") String username, @Optional("abcdef") String password) {
        Reporter.log("Testing log in functionality using valid credentials");
        String actual = "Your name";
        Assert.assertEquals(actual, username);
        System.out.println("username: "+ username);
    }
 }
