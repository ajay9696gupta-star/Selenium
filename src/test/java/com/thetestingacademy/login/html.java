package com.thetestingacademy.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class html {

    @Test
    public void test_login_page(){

        WebDriver driver = new ChromeDriver();

        driver.get("C:\\Users\\ADMIN\\IdeaProjects\\LearningSeleniumATB14x\\src\\html\\login.html");

        System.out.println(driver.getTitle());

        //driver.quit();
    }
}
