package io.techleadacademy.zzStuff;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UtilityMethods {
    public void sleep(int milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void waitForClickability(WebElement element, WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForVisibilityOfAll(List<WebElement> list, WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public WebDriver webDriverSetup (String url) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
