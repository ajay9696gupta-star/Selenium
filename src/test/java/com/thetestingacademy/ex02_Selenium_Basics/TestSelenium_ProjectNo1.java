package com.thetestingacademy.ex02_Selenium_Basics;

import com.beust.ah.A;
import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium_ProjectNo1 extends CommonToAll {


    @Description("TC#1 - Verify that a particular text exists on the Katalon website")
    @Link("https://bugz.atlassian.net/browse/VP-1")
    @Test
    public void test_verify_text(){

        WebDriver driver1 = new FirefoxDriver();
        openBrowser(driver1,"https://katalon-demo-cura.herokuapp.com/");
        if(driver1.getPageSource().contains("CURA Healthcare Service")){
            System.out.println("Test Cases PASSED");
            Assert.assertTrue(true);
        } else {
            System.out.println("Test Cases Failed");
            Assert.assertTrue(false);
        }

        closeBrowser(driver1);
    }

}
