package com.thetestingacademy.ex03_Selenium_Locators;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestSelenium15_Ehub_Add_Content extends CommonToAll {

    @Test
    public void verfiy_add_content() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wccqa.on24.com/webcast/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       // Thread.sleep(5000);

        // Login
        WebElement user_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        user_name.sendKeys("OrionSphere");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Password123");

        WebElement click_login_button =
                driver.findElement(By.xpath("//button[@data-testid='Login_submitButton']"));

        click_login_button.click();

        Thread.sleep(15000);

        WebElement host1 = driver.findElement(By.cssSelector("on24-elite-top-nav-bar"));

        SearchContext shadowRoot1 = host1.getShadowRoot();

        WebElement host2 = shadowRoot1.findElement(By.cssSelector("on24-top-nav-main-navigation"));

        SearchContext shadowRoot2 = host2.getShadowRoot();

        WebElement engagementHub = shadowRoot2.findElement(By.cssSelector("[data-testid='navEngagementHub']"));

        engagementHub.click();

        Thread.sleep(5000);

        // Close Pendo popup if required

        List<WebElement> pendo =
                driver.findElements(By.xpath("//button[@class='_pendo-close-guide']"));

        if (!pendo.isEmpty()) {
            pendo.get(0).click();
        }


        // Open Content section
        driver.findElement(By.xpath("//span[text()='Content']")).click();

        Thread.sleep(15000);

        // Click on  Add Content button
        driver.findElement(By.cssSelector("button[aria-label='add content button']")).click();

        // Thread.sleep(5000);

        // Verify Select all visible results label
        WebElement selectAllVisibleResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Select all visible results']")));
        Assert.assertEquals(selectAllVisibleResults.getText(),"Select all visible results");
        System.out.println(selectAllVisibleResults.getText());

        // check the checkbox of Select all visible results
        WebElement selectAllVisibleResultsCheckbox = driver.findElement(By.id("select-all-visible-results"));
        selectAllVisibleResultsCheckbox.click();

        WebElement enablePublishButton = driver.findElement(By.xpath("//button[contains(text(),'Publish')]"));
        Assert.assertTrue(enablePublishButton.isEnabled(),"Publish button should be enabled after selecting the checkbox");
        System.out.println("Publish button is enabled");

        // Uncheck the checkbox of Select all visible results
        WebElement unSelectAllVisibleResultsCheckbox = driver.findElement(By.id("select-all-visible-results"));
        unSelectAllVisibleResultsCheckbox.click();

        // Search Ajay
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search for content']"));

        searchBox.sendKeys("Ajay");

        // Verify Ajay document
        WebElement verify_title = driver.findElement(By.xpath("//h3[text()='Ajay Document 15-june']"));

        Thread.sleep(3000);

        Assert.assertEquals(verify_title.getText(), "Ajay Document 15-june");

        System.out.println("Verified Title: " + verify_title.getText());

        // Clear Search Field
        searchBox.click();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);

        Thread.sleep(2000);

        System.out.println("Search value after clear: " + searchBox.getAttribute("value"));

        // Select Article from Type dropdown
        WebElement type_dropdown = driver.findElement(By.id("filter-content-type"));
        Select select = new Select(type_dropdown);
        select.selectByVisibleText("Article");

        // Wait for Article title
        WebElement article_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.title")));
        Assert.assertEquals(article_title.getText(), "Automation Article-16-June-2026");
        System.out.println("Article Title: " + article_title.getText());
        Thread.sleep(3000);

        // Select Document from Type dropdown
         //type_dropdown = driver.findElement(By.id("filter-content-type"));
        //select = new Select(type_dropdown);
        select.selectByVisibleText("Document");
        // Wait for Article
        WebElement document_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.title")));
        Assert.assertEquals(document_title.getText(),"Automation PDF-OrionSphere-15/June/2026");
        System.out.println("Document Title: " + document_title.getText());
        Thread.sleep(3000);

        // Select Podcast from Type dropdown
       // type_dropdown = driver.findElement(By.id("filter-content-type"));
       // select = new Select(type_dropdown);
        select.selectByVisibleText("Podcast");
       WebElement no_result_message = driver.findElement(By.xpath("//h1[text()='No results found. Try adjusting your search or filters.']"));
      Assert.assertEquals(no_result_message.getText(),"No results found. Try adjusting your search or filters.");
        System.out.println("Content not found message " + no_result_message.getText());

        // Select Video from Type dropdown
       // type_dropdown = driver.findElement(By.id("filter-content-type"));
      //  select = new Select(type_dropdown);
        select.selectByVisibleText("Video");
        // Wait for Video
        WebElement video_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.title")));
        Assert.assertEquals(video_title.getText(),"Ajay video");
        System.out.println("Video Title: " + video_title.getText());
        Thread.sleep(3000);

        // Select Webcast from Type dropdown
        //type_dropdown = driver.findElement(By.id("filter-content-type"));
       // select = new Select(type_dropdown);
        select.selectByVisibleText("Webcast");
        // Wait for Video
        WebElement webcast_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.title")));
        Assert.assertEquals(webcast_title.getText(),"Automation upcoming webcast");
        System.out.println("Webcast Title: " + webcast_title.getText());
        Thread.sleep(3000);

        // Select Webcast Video from Type dropdown
      //  type_dropdown = driver.findElement(By.id("filter-content-type"));
       // select = new Select(type_dropdown);
        select.selectByVisibleText("Webcast Video");
        no_result_message = driver.findElement(By.xpath("//h1[text()='No results found. Try adjusting your search or filters.']"));
        Assert.assertEquals(no_result_message.getText(),"No results found. Try adjusting your search or filters.");
        System.out.println("Content not found message " + no_result_message.getText());

        // Select Webpage from Type dropdown
       // type_dropdown = driver.findElement(By.id("filter-content-type"));
       // select = new Select(type_dropdown);
        select.selectByVisibleText("Webpage");
        // Wait for Video
        WebElement webpage_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.title")));
        Assert.assertEquals(webpage_title.getText(),"Getting Started");
        System.out.println("Webpage Title: " + webpage_title.getText());
        Thread.sleep(3000);

        // Select ALL from Type dropdown
       // type_dropdown = driver.findElement(By.id("filter-content-type"));
       // select = new Select(type_dropdown);
        select.selectByVisibleText("All");

        //Verify all the Date options in view dropdown
        WebElement viewDropdown = driver.findElement(By.id("filter-content-view"));
        Select select2 = new Select(viewDropdown);
        List<WebElement> viewDateOptions = select2.getOptions();

        for(WebElement dateOption: viewDateOptions){
            //Assert.assertEquals(dateOption.getText(),"");
            System.out.println(dateOption.getText());
        }

        // Verify custom tag label
        WebElement customTagLabel = driver.findElement(By.xpath("//label[text()='Custom Tag']"));
        Assert.assertEquals(customTagLabel.getText(),"Custom Tag");
        System.out.println(customTagLabel.getText());

        // Select custom tag from Type dropdown
       WebElement customTagDropdown = driver.findElement(By.id("filter-custom-tag"));
       Select select1 = new Select(customTagDropdown);
       select1.selectByVisibleText("Ajay");

       // Wait for custom tag content by Ajay
        WebElement firstCustomTagContent = driver.findElement(By.cssSelector("h3[class='title']"));
        Assert.assertEquals(firstCustomTagContent.getText(),"Ajay Document 15-june");
        System.out.println("This is first custom tagged content " +firstCustomTagContent.getText());

        // Select custom tag from custom tag dropdown
        customTagDropdown = driver.findElement(By.id("filter-custom-tag"));
        select1 = new Select(customTagDropdown);
        select1.selectByVisibleText("Document1");

        // Wait for custom tag content by Document1
        WebElement secondCustomTagContent = driver.findElement(By.cssSelector("h3[class='title']"));
        Assert.assertEquals(secondCustomTagContent.getText(),"Automation PDF-OrionSphere-15/June/2026");
        System.out.println("This is second custom tagged content " +secondCustomTagContent.getText());

        // Verify funnel tag label
        WebElement funnelTagLabel = driver.findElement(By.xpath("//label[text()='Funnel Tag']"));
        Assert.assertEquals(funnelTagLabel.getText(),"Funnel Tag");
        System.out.println("Verify the funnel tag label: " +funnelTagLabel.getText());

        //Verify all the funnel tag options in funnel tag dropdown
        WebElement funnelTagDropdown = driver.findElement(By.id("filter-funnel-tag"));
        Select select3 = new Select(funnelTagDropdown);
        List<WebElement> funnelTagOptions = select3.getOptions();

        for(WebElement option: funnelTagOptions){
            System.out.println(option.getText());

        }
        // Select custom tag & funnel tagged content from custom tag & funnel dropdown
        select3.selectByVisibleText("Awareness");

        WebElement customAndFunnelTagContent = driver.findElement(By.cssSelector("h3[class='title']"));
        Assert.assertEquals(customAndFunnelTagContent.getText(),"Automation PDF-OrionSphere-15/June/2026");
        System.out.println("Both custom tag & funnel tagged Applied in this content: " +customAndFunnelTagContent.getText());


        // Select default options in custom tag and funnel tag
        select3.selectByVisibleText("All stages");
        select1.selectByVisibleText("All");

        // Search content from search field
        searchBox = driver.findElement(By.cssSelector("input[placeholder='Search for content']"));
        searchBox.sendKeys("Automation Video");

        WebElement selectIndividualContent = driver.findElement(By.xpath("//input[@aria-label='Automation Video']"));
        selectIndividualContent.click();

       selectAllVisibleResultsCheckbox = driver.findElement(By.id("select-all-visible-results"));
       // selectAllVisibleResultsCheckbox.click();

        Assert.assertEquals(selectAllVisibleResultsCheckbox.isEnabled(),true);
        System.out.println("Select all visible results check box is Checked: " +selectAllVisibleResultsCheckbox);

        driver.findElement(By.xpath("//button[@class='save-btn on24-btn md primary']")).click();
        Thread.sleep(8000);

        // Then verify Total All content Count should be 3

 /*       WebElement allContent = driver.findElement(By.xpath("//span[@class='category-content-count' and text()='2 Items']"));
        Assert.assertEquals(allContent.getText(),"3 Items");
        System.out.println("Total content published in Ehub: " +allContent.getText());*/

        //Verify content is published in ehub
        WebElement verifyContentInEhub= driver.findElement(By.cssSelector("span[title='Automation Video']"));
        Assert.assertEquals(verifyContentInEhub.getText(),"Automation Video");
        System.out.println("This is published content: " +verifyContentInEhub.getText());

        verifyContentInEhub.click();
        Thread.sleep(3000);

        // verify flyout panel should be opened
       WebElement thumbnailLabel = driver.findElement(By.xpath("//h2[text()='Thumbnail']"));
      Assert.assertEquals(thumbnailLabel.getText(),"Thumbnail");
        System.out.println("Verify thumbnail label in flyout panel: " +thumbnailLabel.getText());

        // Unpublish "Automation Video" content from ehub
        driver.findElement(By.xpath("//button[@title='Un-publish this content from Engagement Hub']")).click();

        Thread.sleep(3000);
        // Verify Remove Content model window displays
      WebElement removeContentLabel =  driver.findElement(By.cssSelector("span[class='title']"));
      Assert.assertEquals(removeContentLabel.getText(),"Remove Content");
        System.out.println("Verify Remove Content title in Remove content  model window: "  +removeContentLabel.getText());

        // Click OK button to unpublish the content
        driver.findElement(By.cssSelector("button[data-testid='elite-confirmation-modal-ok-button']")).click();

        Thread.sleep(3000);

        // Then verify All content Count should be 2
        WebElement allContent = driver.findElement(By.xpath("//span[@class='category-content-count' and text()='2 Items']"));
        Assert.assertEquals(allContent.getText(),"2 Items");
        System.out.println("Total content published in Ehub: " +allContent.getText());

        driver.quit();
    }
}