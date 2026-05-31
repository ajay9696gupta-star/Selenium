package com.thetestingacademy.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestSelenium14_Mini_Project_2_Add_Extension {

    @Description("Option Class")
    @Test
    public void test_Selenium01() throws Exception{

        ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("--windows-size=1920,1080");
        // chromeOptions.addArguments("--incognito");


        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.youtube.com/watch?v=-v6V3T1iZqI&list=RD-v6V3T1iZqI&start_radio=1");

        Thread.sleep(50000);

        driver.quit();

    }


}
