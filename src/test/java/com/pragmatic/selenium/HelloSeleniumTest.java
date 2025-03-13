package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSeleniumTest {


    @Test
    public void testHelloSelenium() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to the sauce login page
        driver.get("https://www.saucedemo.com/");

        //Type username
        WebElement txtUsername = driver.findElement(By.id("user-name"));
        txtUsername.clear();
        txtUsername.sendKeys("standard_user");
        //Type password
        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.clear();
        txtPassword.sendKeys("secret_sauce");
        //Click login button
        driver.findElement(By.id("login-button")).click();

        //Verify the error message
        String actualTitle = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(actualTitle, "Products", "Login failed - Page title mismatch.");
        driver.quit();
    }

}
