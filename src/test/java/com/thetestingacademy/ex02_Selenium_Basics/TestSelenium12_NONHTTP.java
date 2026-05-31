package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium12_NONHTTP {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
       // driver.get("google.com"); IT will not work
        driver.get("https://google.com");
    }
}
