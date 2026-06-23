package com.thetestingacademy.ex05_Selenium_Waits;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium_waits {

    @Test

    public void test_verify_print_impc_price(){

        EdgeDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://app.vwo.com");


    }
}
