package com.sauce.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Launch (create an instance of) a web browser
        driver = new ChromeDriver();
        //Navigate to the sauce login page
        driver.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testLoginWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Type username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Type password
        driver.findElement(By.id("login-button")).click(); //Click login button

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(errorMessage, "Products");
    }


    @Test
    public void testLoginWithValidCredentialsLockedUser() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user"); //Type username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Type password
        driver.findElement(By.id("login-button")).click(); //Click login button

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testLoginWithBlankUsername() {
        driver.findElement(By.id("user-name")).sendKeys(""); //Type username
        driver.findElement(By.id("password")).sendKeys("secret"); //Type password
        driver.findElement(By.id("login-button")).click(); //Click login button

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithBlankPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Type username
        driver.findElement(By.id("password")).sendKeys(""); //Type password
        driver.findElement(By.id("login-button")).click(); //Click login button

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
    }


    @Test
    public void testLoginWithBlankUsernameAndBlankPassword() {
        driver.findElement(By.id("user-name")).sendKeys(""); //Type username
        driver.findElement(By.id("password")).sendKeys(""); //Type password
        driver.findElement(By.id("login-button")).click(); //Click login button

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }


    @Test
    public void testLoginWithInvalidPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Type username
        driver.findElement(By.id("password")).sendKeys("invalid"); //Type password
        driver.findElement(By.id("login-button")).click(); //Click login button

        //Verify the error message
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }








}
