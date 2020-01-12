package io.techleadacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class orangeNews {
    @Test
    public void projectDay() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Actions act = new Actions(driver);
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");

        LocalDate day = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String today = df.format(day);
        String name = "Mark";

        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[2]")).click();
        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[28]")).click();
        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[29]")).click();

        driver.switchTo().frame("noncoreIframe");

        List<WebElement> rows = driver.findElements(By.className("dataRaw"));
        System.out.println(rows.size());

        Map<String, List<String>> news = new LinkedHashMap<>();

        for(WebElement we : rows) {
            String topic = we.findElement(By.className("newsTopic")).getText();
            List<String> ls = new ArrayList<>();
            ls.add(we.findElement(By.xpath(".//td[3]")).getText());
            ls.add(we.findElement(By.xpath(".//td[6]")).getText());
            if (we.findElement(By.xpath(".//td/i")).isEnabled()) {
                ls.add("YES");
            } else {
                ls.add("NO");
            }
            news.put(topic, ls);
        }

        for(Map.Entry each : news.entrySet()) {
            System.out.println(each.getKey()+" | "+each.getValue());
        }

        driver.findElement(By.xpath("//i[@class='large material-icons']")).click();

        driver.switchTo().parentFrame();
        driver.switchTo().frame("noncoreIframe");

        driver.findElement(By.xpath("//input[@class='formInputText']")).sendKeys("Congratulations "+name);

        driver.switchTo().frame("news_description_ifr");

        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Promotion was awarded to "+name+" on "+today);

        driver.switchTo().parentFrame();

        driver.findElement(By.id("nextBtn")).click();

        driver.findElement(By.xpath("//label[@for='news_publish_all']")).click();

        driver.findElement(By.xpath("//button[@btn-type='publish']")).click();

        String expectedText = "Congratulations Mark";
        String actualText = driver.findElement(By.xpath("//tr[@class='dataRaw'][32]/td/a")).getText();
        Assert.assertEquals(actualText,expectedText);

        driver.findElement(By.xpath("//i[@class='material-icons']")).click();
        driver.findElement(By.xpath("//a[@id='logoutLink']")).click();

        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("//a[@data-username='kevin']")).click();

        List<WebElement> dashNews = driver.findElements(By.xpath("(//ul[@class='collection'])[4]/li"));
        int actualCount = dashNews.size();
        int expectedCount = 18;
        Assert.assertEquals(actualCount, expectedCount);

        String actualTopic = driver.findElement(By.xpath("(//ul[@class='collection'])[4]/li[18]/div/span/a")).getText().trim();
        String expectedTopic = "Congratulations Mark";
        Assert.assertEquals(actualTopic, expectedTopic);

        String actualDesc = driver.findElement(By.xpath("(//ul[@class='collection'])[4]/li[18]/div[2]/div/span")).getText().trim();
        String expectedDesc = "Promotion was awarded to Mark on 01/08/2020";
        Assert.assertEquals(actualDesc, expectedDesc);

        driver.findElement(By.xpath("//i[@class='material-icons']")).click();
        driver.findElement(By.xpath("//a[@id='logoutLink']")).click();
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[2]")).click();
        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[28]")).click();
        driver.findElement(By.xpath("(//span[@class='left-menu-title'])[29]")).click();

        driver.switchTo().frame("noncoreIframe");

        act.moveToElement(driver.findElement(By.xpath("(//tr[@class='dataRaw'])[39]"))).perform();
        driver.findElement(By.xpath("(//tr[@class='dataRaw'])[39]/td/input")).click();
        act.moveToElement(driver.findElement(By.xpath("//i[@class='material-icons icons-color handCurser']"))).click().perform();
        driver.findElement(By.id("newsDelete")).click();

        List<WebElement> newsRows = driver.findElements(By.className("dataRaw"));
        int actualNewsCount = newsRows.size();
        int expectedNewsCount = 38;
        Assert.assertEquals(actualNewsCount,expectedNewsCount);
    }
}
