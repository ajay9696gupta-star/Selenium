package com.thetestingacademy.ex04_Selenium_XPATH;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_MediaManager extends CommonToAll {

    @Owner("Ajay")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the MM page is working")
    @Test
    public void Test_MM_Page(){

        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://wccqa.on24.com/webcast/login");
        customwait(5000);

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("gouravclient5");

        WebElement password_input_box = driver.findElement(By.id("password"));
        password_input_box.sendKeys("Password10");

        driver.findElement(By.className("css-va8es8")).click();
        customwait(8000);

        WebElement host1 = driver.findElement(By.cssSelector("on24-elite-top-nav-bar"));
        SearchContext shadowRoot1 = host1.getShadowRoot();

        WebElement host2 = shadowRoot1.findElement(By.cssSelector("on24-top-nav-main-navigation"));
        SearchContext shadowRoot2 = host2.getShadowRoot();

        WebElement host3 = shadowRoot2.findElement(By.cssSelector("on24-top-nav-tools-dropdown"));
        SearchContext shadowRoot3 = host3.getShadowRoot();

        WebElement platform_tools = shadowRoot3.findElement(By.id("tools-toggle-button"));
        platform_tools.click();
        customwait(3000);

        WebElement mediaManager = shadowRoot3.findElement(By.cssSelector("a[href*='mediamanager']"));

        mediaManager.click();
       customwait(9000);


       WebElement content_text = driver.findElement(By.xpath("//label[text()='Content']"));

        Assert.assertEquals(content_text.getText(),"Content");
        System.out.println(content_text.getText());

        WebElement search_content =   driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search_content.sendKeys("9000706179");

        driver.findElement(By.xpath("//button[@title='Publish']")).click();
        customwait(3000);

        driver.findElement(By.xpath("(//div[@class='btn-actions'])[2]")).click();
        customwait(3000);

      //  WebElement model_text = driver.findElement(By.xpath("//header[@data-testid='modal-on24-modal-1780420128537-title']"));
               // Assert.assertEquals(model_text.getText(),"Publish Settings: EHub  003-reverse-proxy-support(Don't change anything)");

    //    System.out.println(model_text.getText());

        driver.findElement(By.xpath("//button[@data-testid='select categories-toggle']")).click();
        customwait(3000);
        driver.findElement(By.xpath("(//input[@class='on24-input md custom-checkbox-input'])[1]")).click();
        customwait(3000);

        driver.findElement(By.xpath("//label[@class='select-options-box-text']")).click();

        customwait(3000);
        driver.findElement(By.xpath("//button[@class='on24-btn md primary']")).click();


WebElement unpublish_button =  driver.findElement(By.xpath("(//button[@class='on24-btn sm destructive-secondary'])[2]"));
Assert.assertEquals(unpublish_button.getText(),"Unpublish");
        System.out.println(unpublish_button.getText());

        //driver.findElement(By.xpath("(//button[@class='on24-btn sm destructive-secondary'])[2]")).click();

     //   driver.findElement(By.xpath("//button[text()='Unpublish Now']")).click();
      //  customwait(5000);

    //    driver.findElement(By.xpath("//button[@data-testid='elite-confirmation-modal-ok-button']")).click();









        closeBrowser(driver);


    }

}
