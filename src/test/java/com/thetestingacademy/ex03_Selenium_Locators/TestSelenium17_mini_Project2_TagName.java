package com.thetestingacademy.ex03_Selenium_Locators;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestSelenium17_mini_Project2_TagName extends CommonToAll {

    @Owner("Ajay Gupta")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify the error message comes with invalid email on signup page")
    @Test
    public void vwo_free_trial_error_verify(){

        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://app.vwo.com/#/login");

      WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("TRIAL"));
      a_tag_partial_match.click();

   Set<String> window_handles = driver.getWindowHandles();

     for(String handle : window_handles)
     {
        driver.switchTo().window(handle);
     }

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

       WebElement email = driver.findElement(By.id("page-v1-step1-email"));
       email.sendKeys("abc");

        // <input class="W(100%) Py(14px) input-text" placeholder="name@yourcompany.com" type="email"
        // id="page-v1-step1-email" name="email" data-qa="page-su-step1-v1-email" required="">


        //<div class="C(--common-color-red) Fz(--common-font-size-12) Trsp(--common-Op) Trsdu(0.15s) Op(0) invalid-input+Op(1)
        // invalid-reason">The email address you entered is incorrect.</div>

        // <input class="Cur(p) Flxs(0) M(0) Pos(r) T(2px)" type="checkbox"
        // name="gdpr_consent_checkbox" id="page-free-trial-step1-cu-gdpr-consent-checkbox"
        // value="true" data-qa="page-free-trial-step1-gdpr-consent-checkbox">

        //<button type="submit" disabled=""
        // class="button button--disabled-primary W(100%) btn-modal-form-submit"
        // data-qa="page-su-submit">Create a Free Trial Account</button>

       WebElement checkbox_policy = driver.findElement(By.id("page-free-trial-step1-cu-gdpr-consent-checkbox"));
       checkbox_policy.click();

       WebElement button_create_account =  driver.findElement(By.tagName("button"));
       button_create_account.click();

       WebElement error_message =  driver.findElement(By.className("invalid-reason"));

       Assert.assertEquals(error_message.getText(),"The email address you entered is incorrect.");


    }
}
