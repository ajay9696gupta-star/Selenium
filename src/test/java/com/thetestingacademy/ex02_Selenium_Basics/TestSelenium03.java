package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium03 {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        // New FirefoxDriver(); - This START of the selenium session
        // Session - Fresh copy of th browser is started.
        //POST request to the server - Firefox Driver.

        driver.get("https://wccqa.on24.com/webcast/login");
        // Command number 2 : POST request to give the driver to navigate to URL
    }
}
