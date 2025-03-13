package com.sauce.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * LoginTest class to perform automated login tests on Sauce Demo.
 * Demonstrates basic Selenium WebDriver usage with TestNG.
 * Includes positive and negative test cases to validate login functionality.
 *
 * Test Scenarios:
 * 1. Valid login
 * 2. Locked out user
 * 3. Blank username
 * 4. Blank password
 * 5. Blank username and password
 * 6. Invalid password
 * 7. Case-sensitive password
 * 8. SQL injection attempt
 */
public class LoginTest {

    private WebDriver driver;

    /**
     * Set up the browser before each test.
     * Launches the Chrome browser, maximizes the window, and navigates to the login page.
     */
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
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

    /**
     * Test valid login with correct username and password.
     */
    @Test
    public void testValidLogin() {
        enterCredentials("standard_user", "secret_sauce");
        clickLoginButton();

        String actualTitle = getPageTitle();
        Assert.assertEquals(actualTitle, "Products", "Login failed: Unexpected page title.");
    }

    /**
     * Test login with a locked-out user.
     */
    @Test
    public void testLoginWithLockedUser() {
        enterCredentials("locked_out_user", "secret_sauce");
        clickLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }

    /**
     * Test login with a blank username.
     */
    @Test
    public void testLoginWithBlankUsername() {
        enterCredentials("", "secret_sauce");
        clickLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }

    /**
     * Test login with a blank password.
     */
    @Test
    public void testLoginWithBlankPassword() {
        enterCredentials("standard_user", "");
        clickLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
    }

    /**
     * Test login with both username and password blank.
     */
    @Test
    public void testLoginWithBlankUsernameAndPassword() {
        enterCredentials("", "");
        clickLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }

    /**
     * Test login with an invalid password.
     */
    @Test
    public void testLoginWithInvalidPassword() {
        enterCredentials("standard_user", "invalid");
        clickLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    /**
     * Test login with a case-sensitive password (valid but different case).
     */
    @Test
    public void testLoginWithCaseSensitivePassword() {
        enterCredentials("standard_user", "SECRET_SAUCE");
        clickLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    /**
     * Test login with an SQL injection attempt in the password field.
     */
    @Test
    public void testLoginWithSQLInjection() {
        enterCredentials("standard_user", "' OR '1'='1");
        clickLoginButton();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    /**
     * Enters the given username and password into the login form.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    private void enterCredentials(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    private void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    /**
     * Gets the title of the current page after login.
     *
     * @return The page title as a string.
     */
    private String getPageTitle() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    /**
     * Retrieves the displayed error message.
     *
     * @return The error message as a string.
     */
    private String getErrorMessage() {
        return driver.findElement(By.cssSelector("[data-test='error']")).getText();
    }
}