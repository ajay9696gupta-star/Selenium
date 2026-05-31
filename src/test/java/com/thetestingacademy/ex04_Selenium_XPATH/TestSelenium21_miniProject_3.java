package com.thetestingacademy.ex04_Selenium_XPATH;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21_miniProject_3 extends CommonToAll {

    @Owner("Ajay")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that with valid email, pass, appointment page is loaded")

    @Test
    public void test_katalon_login(){

        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://katalon-demo-cura.herokuapp.com/");

       WebElement make_appointment_btn_xpath = driver.findElement(By.xpath("//a[contains(text(), 'Make Appointment')]"));
       make_appointment_btn_xpath.click();

        List<WebElement> username_inputs = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_inputs.get(1).sendKeys("John Doe");

        List<WebElement> password_inputs = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password_inputs.get(1).sendKeys("ThisIsNotAPassword");

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        customwait(5000);

        WebElement h2 = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));

        Assert.assertEquals(h2.getText(), "Make Appointment");
        Assert.assertTrue(h2.isDisplayed());
        Assert.assertTrue(true);

        closeBrowser(driver);





    }


}
