package io.techleadacademy.zzStuff.Jan12;

import com.github.javafaker.Faker;
import io.techleadacademy.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {
    SeleniumUtils utils = new SeleniumUtils();
    WebDriver driver = utils.webDriverSetup("https://www.phptravels.net/index.php");
    Faker faker = new Faker();
    String[] fakes = {faker.name().firstName(), faker.name().lastName(), faker.phoneNumber().cellPhone(),
            faker.internet().emailAddress(), faker.internet().password()};
    LocalDate date = LocalDate.now();
    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    String today = df.format(date);

    @Test
    public void _001verifyTitle () {
        String actualTitle = driver.getTitle();
        String expectedTitle = "PHPTRAVELS | Travel Technology Partner";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual: "+actualTitle+" | Expected: "+expectedTitle);
    }

    @Test
    public void _002verifySignUp () {
        String signUpPage = driver.getTitle();

        driver.findElement(By.xpath("(//a[@id='dropdownCurrency'])[2]")).click();
        driver.findElement(By.xpath("//a[@class='dropdown-item tr']")).click();
        List<WebElement> inputFields = driver.findElements(By.xpath("//div[@class='form-group']/input"));
        for (int i = 0; i < inputFields.size(); i++) {
            if (i == inputFields.size()-1) inputFields.get(i).sendKeys(fakes[i-1]);
            else inputFields.get(i).sendKeys(fakes[i]);
        }
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        String profilePage = driver.getTitle();
        Assert.assertNotEquals(signUpPage, profilePage, "Previous Title: "+signUpPage+" | Current Title: "+profilePage);
    }

    @Test
    public void _003verifyProfilePage () {
        utils.sleep(5000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Account";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual: "+actualTitle+" | Expected: "+expectedTitle);

        String actualHi = driver.findElement(By.xpath("//h3[@class='text-align-left']")).getText();
        String expectedHi = "Hi, "+fakes[0]+" "+fakes[1];
        Assert.assertEquals(expectedHi, actualHi, "Actual: " + actualHi + " | Expected: " + expectedHi);

        String actualDate = driver.findElement(By.xpath("//span[@class='h4']")).getText();
        Assert.assertEquals(actualDate, today,"Actual: "+actualDate+" | Expected: "+today);
    }
}
