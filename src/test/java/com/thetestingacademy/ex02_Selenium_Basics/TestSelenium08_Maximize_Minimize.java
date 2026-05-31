package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium08_Maximize_Minimize {

    @Test
    public void test_1() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://wccqa.on24.com/webcast/login");
        //driver.manage().window().minimize();
        driver.manage().window().maximize();

        Thread.sleep(8000);
        Assert.assertEquals(driver.getTitle(),"Login | Webcast Elite");
        driver.quit();
    }
}
