package com.thetestingacademy.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium11_Navigation_GET_Navigate {

    @Description("Open the URLs")
    @Test

    public void test_Selenium01(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://wccqa.on24.com/webcast/login");

        //Use Navigation commands
        // driver.get("URL") --> Navigate to a URL

        driver.navigate().to("https://google.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
    }
}
