package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium07_Selenium_Commands {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://wccqa.on24.com/webcast/login");


        System.out.println("This is page title: " + driver.getTitle());
        System.out.println("This is page URLs: " + driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.quit();

    }
}
