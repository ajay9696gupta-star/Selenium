package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium10_Change_Driver {

    @Test
    public void change_Driver(){
        WebDriver driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://wccqa.on24.com/webcast/login");

    }
}
