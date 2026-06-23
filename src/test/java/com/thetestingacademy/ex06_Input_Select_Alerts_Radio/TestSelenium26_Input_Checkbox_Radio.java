package com.thetestingacademy.ex06_Input_Select_Alerts_Radio;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium26_Input_Checkbox_Radio extends CommonToAll {

    @Test
    public void testHtmlTag(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");

        // Input Box
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ajay");

        //Radio
        WebElement radioButton = driver.findElement(By.id("sex-0"));
        radioButton.click();

        //Checkbox
        WebElement checkBox = driver.findElement(By.id("profession-1"));
        checkBox.click();

        closeBrowser(driver);

    }
}
