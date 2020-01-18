package io.techleadacademy.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.techleadacademy.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils extends TestBase {
    public static void sleep(int milliSeconds){
        try{
            Thread.sleep(milliSeconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void waitForClickability(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibilityOfAll(List<WebElement> list){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public static void waitForVisibility(WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void clickElement (WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static void sendKeys (WebElement element, String input) {
        waitForVisibility(element);
        element.sendKeys(input);
    }

    public static String getText (WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    public static void moveIntoView (WebElement element) {
        try {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public WebDriver webDriverSetup (String url) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static void highlightElement (WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //moveElementIntoView(element);
        for(int i = 0; i < 2; i++){
            try {
                if (i == 0) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 3px solid red; background: yellow");
                }else{
                    sleep(1000);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
