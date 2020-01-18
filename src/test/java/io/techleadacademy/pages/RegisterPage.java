package io.techleadacademy.pages;

import io.techleadacademy.base.TestBase;
import io.techleadacademy.testData.NewUserInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends TestBase {
    public RegisterPage () {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@class='form-control']")
    public List<WebElement> inputs;

    @FindBy (xpath = "//input[@name='firstname']")
    public WebElement firstNameField;

    @FindBy (xpath = "//input[@name='lastname']")
    public WebElement lastNameField;

    @FindBy (xpath = "//input[@name='phone']")
    public WebElement phnNumField;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy (xpath = "//input[@name='confirmpassword']")
    public WebElement confirmPWField;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signUp_Btn;

    public String getTitle () {
        return driver.getTitle();
    }

    public void fillSignUpForm () {
        NewUserInfo user = new NewUserInfo();
//        firstNameField.sendKeys(user.getFirstName());
//        lastNameField.sendKeys(user.getLastName());
//        phnNumField.sendKeys(user.getPhnNum());
//        emailField.sendKeys(user.getEmail());
//        passwordField.sendKeys(user.getPassword());
//        confirmPWField.sendKeys(user.getPassword());
        inputs.get(0).sendKeys(user.getFirstName());
        inputs.get(1).sendKeys(user.getLastName());
        inputs.get(2).sendKeys(user.getPhnNum());
        inputs.get(3).sendKeys(user.getEmail());
        inputs.get(4).sendKeys(user.getPassword());
        inputs.get(5).sendKeys(user.getPassword());
    }

    public void clickSignUpBtn () {
        signUp_Btn.click();
    }
}
