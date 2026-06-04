package com.thetestingacademy.ex03_Selenium_Locators;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium15_Project_Locators_Selenium_ID_CLASSNAME_Name extends CommonToAll {

    @Description("TC1 - Verify that with invalid login, error message is displayed")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void elite_invalid_login() throws InterruptedException {

        // Step 1 - Find the EMAIL ID and enter the admin@admin.com.
// Step 2 - Find the Password and enter the 1234.
// Step 3 - Find the Submit and click on the button.
// Step 4 - Wait some time.
// Step 5 - Verify the message error message.

        //<input aria-invalid="false" id="username" name="username" placeholder="Username"
        // type="text" maxlength="50" class="MuiInputBase-input MuiInput-input css-1unfm2x" value="">

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wccqa.on24.com/webcast/login");
        Thread.sleep(3000);


        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("ajayorion1");

       WebElement password_input_box = driver.findElement(By.id("password"));
       password_input_box.sendKeys("Password1");

       driver.findElement(By.className("css-va8es8")).click();

        Thread.sleep(3000);


     WebElement error_message =  driver.findElement(By.cssSelector(".MuiAlert-message.css-127h8j3"));
        System.out.println(error_message.getText());

        driver.close();

       Assert.assertEquals(error_message.getText(), "Username/Password combination not found. Please try again or reset your password using \"Can't Access Your Account?\". Note: Username and Password are case sensitive");

    }

    @Description("TC2 - Verify that with invalid login, error message is displayed")
    @Test

    public void elite_valid_login()  throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wccqa.on24.com/webcast/login");
        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("msqa1");

        WebElement password_input_box = driver.findElement(By.id("password"));
        password_input_box.sendKeys("Password12");

        driver.findElement(By.className("css-va8es8")).click();

        Thread.sleep(9000);

       WebElement event_label = driver.findElement(By.cssSelector("h1.MuiTypography-root"));
        System.out.println(event_label.getText());
        Assert.assertEquals(event_label.getText(),"Events");

        driver.quit();



    }

    @Test
    public void create_event() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wccqa.on24.com/webcast/login");
        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("gouravclient5");

        WebElement password_input_box = driver.findElement(By.id("password"));
        password_input_box.sendKeys("Password10");

        driver.findElement(By.className("css-va8es8")).click();

        Thread.sleep(9000);


        WebElement host1 = driver.findElement(By.cssSelector("on24-elite-top-nav-bar"));

        SearchContext shadowRoot1 = host1.getShadowRoot();

        WebElement host2 = shadowRoot1.findElement(By.cssSelector("on24-top-nav-main-navigation"));

        SearchContext shadowRoot2 = host2.getShadowRoot();

        WebElement engagementHub = shadowRoot2.findElement(By.cssSelector("[data-testid='navEngagementHub']"));

        engagementHub.click();
        Thread.sleep(5000);


        // Select content tab
        driver.findElement(By.xpath("//span[text()='Content']")).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//button[@aria-label='add content button']")).click();
        Thread.sleep(5000);


       WebElement Search_content = driver.findElement(By.xpath("//input[@placeholder='Search for content']"));
       Search_content.sendKeys("Copy of Ajay Webcast 15 july 2026");


       // Select checkbox
       driver.findElement(By.xpath("//input[@type='checkbox']")).click();
       Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        Thread.sleep(5000);

       // Click publish button
       driver.findElement(By.xpath("//button[contains(@class,'save-btn')]")).click();

        Thread.sleep(9000);

       WebElement enter_text_in_search_field = driver.findElement(By.xpath("//input[@placeholder='Search']"));
       enter_text_in_search_field.sendKeys("Copy of Ajay Webcast 15 july 2026");



        closeBrowser(driver);

    }
}
