package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium13_Close_vs_Quit {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(5000);

        // driver.close();

        // Close - will close the current tab. Not the session
        // session id != null

        driver.quit();
        // It will close all the tabs - session id == null


    }
}
