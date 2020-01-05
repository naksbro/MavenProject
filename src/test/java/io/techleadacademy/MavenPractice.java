package io.techleadacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MavenPractice {
    public static void main(String[] args) {
        TestData td = new TestData();
        System.out.println(td.firstName());
        System.out.println(td.lastName());
        System.out.println(td.phoneNumber());
        System.out.println(td.address());
    }
}
