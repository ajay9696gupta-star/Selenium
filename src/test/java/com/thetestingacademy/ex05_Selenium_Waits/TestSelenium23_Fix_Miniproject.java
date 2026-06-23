package com.thetestingacademy.ex05_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium23_Fix_Miniproject {

    @Test
    public void testVwoLoginNegative() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.navigate().to("https://app.vwo.com");

        System.out.println(driver.getTitle());

        WebElement emailInputBox =
                driver.findElement(By.id("login-username"));

        emailInputBox.sendKeys("admin@admin.com");

        WebElement passwordInputBox =
                driver.findElement(By.name("password"));

        passwordInputBox.sendKeys("password321");

        WebElement buttonSubmit =
                driver.findElement(By.id("js-login-btn"));

        buttonSubmit.click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("js-notification-box-msg")
                )
        );

        driver.quit();
    }
}