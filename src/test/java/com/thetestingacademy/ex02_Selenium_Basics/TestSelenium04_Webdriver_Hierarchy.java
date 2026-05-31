package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestSelenium04_Webdriver_Hierarchy {
    public static void main(String[] args) {

        //Webdriver hierarchy
        // SearchContent(I) -> (2) -> webdriver(I)(10) -> RemoteWebdriver(c) (15)
        // chromiumDriver(c) 25 ->" EdgeDriver(c) (45)

       // SearchContext driver = new FirefoxDriver();
       // SearchContext driver1 = new EdgeDriver();
       // SearchContext driver2 = new ChromeDriver();

       // WebDriver driver = new FirefoxDriver();
       // RemoteWebDriver driver1 = new FirefoxDriver();
       // FirefoxDriver driver2 = new FirefoxDriver();


        // Scenarios
        // 1. Do want to run on chrome or Edge?

       // ChromeDriver driver = new ChromeDriver();
        // driver = new FirefoxDriver();

        // 2. Do you want to rub on chrome then change to Edge?

        WebDriver driver = new ChromeDriver();
        driver = new EdgeDriver(); //97%
        driver = new FirefoxDriver(); //97%
        driver = new SafariDriver(); //97%

        // 3. Do you want to run on multiple browser
       // RemoteWebDriver driver1 (with GRID) - Advance (Last 2 Sessions)

    }
}
