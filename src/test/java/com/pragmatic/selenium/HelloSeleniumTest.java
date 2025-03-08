package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSeleniumTest {


    @Test
    public void testHelloSelenium() {
        WebDriver driver = new ChromeDriver();

        //Navigate to the sauce login page
        driver.get("https://www.saucedemo.com/");

        //Type username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Type password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click login button
        driver.findElement(By.id("login-button")).click();

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(errorMessage, "Products");
        driver.quit();
    }

}
