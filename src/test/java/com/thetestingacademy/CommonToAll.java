package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAll {

    // Common function for all tests

    public ChromeDriver driver;

    public void openBrowser(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeBrowser(WebDriver driver){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void customwait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForVisiblisty(WebDriver driver, int timeInSecond, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }

}
