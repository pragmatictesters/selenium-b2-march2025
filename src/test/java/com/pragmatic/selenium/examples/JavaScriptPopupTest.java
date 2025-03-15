package com.pragmatic.selenium.examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptPopupTest {

    private WebDriver driver;

    /**
     * Set up the browser before each test.
     * Launches the Chrome browser, maximizes the window, and navigates to the login page.
     */
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pragmatictesters.github.io/selenium-webdriver-examples/javascript-popups.html");
    }

    /**
     * Tear down the browser after each test.
     * Ensures that the browser is closed even if the test fails.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testJavascriptAlert() {
        driver.findElement(By.xpath("//button[text()='Show Alert']")).click();
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, "This is a simple alert!", "Alert message is incorrect");
        alert.accept();
        String message = driver.findElement(By.cssSelector("#outputMessage")).getText();
        Assert.assertEquals(message, "Alert displayed.");
    }

    @Test
    public void testJavascriptConfirmationOK() {
        driver.findElement(By.xpath("//button[text()='Show Confirmation']")).click();
        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, "Do you confirm this action?", "Confirmation message is incorrect");
        alert.accept();

        String message = driver.findElement(By.cssSelector("#outputMessage")).getText();
        Assert.assertEquals(message, "Action confirmed.");
    }

    @Test
    public void testJavascriptConfirmationCancel() {
        driver.findElement(By.xpath("//button[text()='Show Confirmation']")).click();
        Alert alert = driver.switchTo().alert();

        alert.dismiss();

        String message = driver.findElement(By.cssSelector("#outputMessage")).getText();
        Assert.assertEquals(message, "Action canceled.");
    }


    @Test
    public void testJavascriptPrompt() {
        String inputText = "Selenium";
        driver.findElement(By.xpath("//button[text()='Show Prompt']")).click();
        Alert alert = driver.switchTo().alert();

        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, "Please enter your message:", "Prompt message is incorrect");

        alert.sendKeys(inputText);

        alert.accept();

        String message = driver.findElement(By.cssSelector("#outputMessage")).getText();
        Assert.assertEquals(message, "You entered: " + inputText);
    }





}
