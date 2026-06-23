package com.thetestingacademy.ex05_Selenium_Waits;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class TestSelenium25_Fluent_Wait extends CommonToAll {

    @Test
    public void test_FW(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wccqa.on24.com/webcast/login");

       // Thread.sleep(5000);

        // Login
        WebElement user_name = driver.findElement(By.id("username"));
        user_name.sendKeys("OrionSphere");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Password123");

        WebElement click_login_button =
                driver.findElement(By.xpath("//button[@data-testid='Login_submitButton']"));

        click_login_button.click();

       // Thread.sleep(9000);

        // Explicit wait
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement errorMessage = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//button[@data-testid='Login_submitButton']"));
            }
        });


    }

}
