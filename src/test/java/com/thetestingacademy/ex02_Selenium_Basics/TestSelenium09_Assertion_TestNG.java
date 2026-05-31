package com.thetestingacademy.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium09_Assertion_TestNG {

    @Description("Open the URL")
    @Test
    public void test_Selenium01(){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://wccqa.on24.com/webcast/login");

        //TestNG
        Assert.assertEquals(driver.getCurrentUrl(),"https://wccqa.on24.com/webcast/login");
        //AssertJ validation
        assertThat(driver.getCurrentUrl()).isNotNull().isEqualTo("https://wccqa.on24.com/webcast/login");

        driver.quit();
    }
}
