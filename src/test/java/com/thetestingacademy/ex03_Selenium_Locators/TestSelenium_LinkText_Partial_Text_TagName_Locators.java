package com.thetestingacademy.ex03_Selenium_Locators;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium_LinkText_Partial_Text_TagName_Locators extends CommonToAll {

    @Description("Verify Vwo create account negative TC")
    @Test
    public void vwo_login_page(){

        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://app.vwo.com/#/login");

        // <a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
        // class="btn Brds(1px) Bdc(--color-gray-5) Bds(s) W(100%)"
        // target="_blank" rel="noreferrer" style="display:flex; align-items:center;
        // justify-content:center; text-decoration:none;">
        //      <span>Start a FREE TRIAL</span>
        //    </a>

        // LinkText - full text match
        // partial Linktext  partial match

      // WebElement a_tag_free_trial_full_match = driver.findElement(By.linkText("Start a FREE TRIAL"));
       // a_tag_free_trial_full_match.click();

        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("Start a"));
        a_tag_partial_match.click();

        // Start a free trail
        // Start a free
        // Start a
        // Start, Trial, free, a, Star..


        closeBrowser(driver);
    }
}
