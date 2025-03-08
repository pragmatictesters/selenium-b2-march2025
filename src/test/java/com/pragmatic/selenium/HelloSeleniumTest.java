package com.pragmatic.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HelloSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Launch (create an instance of) a web browser
        driver = new ChromeDriver();

        //Navigate to the sauce login page
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testHelloSelenium() {

        //Launch (create an instance of) a web browser
        WebDriver driver = new ChromeDriver();

        //Navigate to the sauce login page
        driver.get("");

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window(windowHandles.toArray()[1].toString()); //Switch to new window
        //work with the new windows

        driver.switchTo().window(currentWindowHandle);


        //Type username

        //Type password

        //Click login button


        //Verify title Products in the landing page

        driver.quit();
    }


    @Test
    public void testLoginWithBlankUsername() {


        //Type username
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.id("login-button")).click();

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
        driver.quit();
    }

    @Test
    public void testLoginWithBlankPassword() {

    }


  


}
