package Jan12;

import com.github.javafaker.Faker;
import io.techleadacademy.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task1 {

    ReusableMethods methods = new ReusableMethods();
    WebDriver driver = methods.webDriverSetUp("https://www.phptravels.net/index.php");
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String phnNum = faker.phoneNumber().cellPhone();
    String email = firstName+lastName+"@gmail.com";
    String password = "drowssap";
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
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phnNum);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys(password);
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        String profilePage = driver.getTitle();
        Assert.assertNotEquals(signUpPage, profilePage, "Previous Title: "+signUpPage+" | Current Title: "+profilePage);
    }

    @Test
    public void _003verifyProfilePage () {
        methods.sleep(5000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "My Account";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual: "+actualTitle+" | Expected: "+expectedTitle);

        String actualHi = driver.findElement(By.xpath("//h3[@class='text-align-left']")).getText();
        String expectedHi = "Hi, "+firstName+" "+lastName;
        Assert.assertTrue(actualHi.equals(expectedHi), "Actual: "+actualHi+" | Expected: "+expectedHi);

        String actualDate = driver.findElement(By.xpath("//span[@class='h4']")).getText();
        Assert.assertEquals(actualDate, today,"Actual: "+actualDate+" | Expected: "+today);
    }
}
