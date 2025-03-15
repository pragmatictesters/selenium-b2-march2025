# Naming Conventions

Consistent and meaningful naming conventions improve code readability and maintainability. The following conventions are recommended for packages, classes, test methods, directories, and variables in Selenium WebDriver Java projects.

---

## Package Naming
- Use **lowercase letters only**, without numbers.
- Start with the **reverse of the company domain** (e.g., `com.pragmatictesters`).
- Group packages based on functionality or module.

**Example:**
```java
com.pragmatictesters.login
com.pragmatictesters.checkout
com.pragmatictesters.utils
```

---

## Class Naming
- Class names should be **PascalCase** (capitalize the first letter of each word).
- Test classes should end with the **`Test`** suffix.
- Use **descriptive names** that clearly indicate the purpose.

**Example:**
- Login**Test**
- CheckoutPage
- UserDetailsHelper

---

## Test Method Naming
- Test methods should have the **`test`** prefix followed by the action and expected outcome.
- Use **camelCase** for method names.
- Be specific about the scenario being tested.

**Example:**
```java
public void testLoginWithValidUserCredentials()  {}
public void testCheckoutWithEmptyCart()  {}
public void testAddProductToCart()  {}
```

---
## Variable Naming 
* Use lower camelCase for variable names.
* Keep names meaningful and concise.
```java
String employeeNumber;  
int maxLoginAttempts;  
boolean isUserLoggedIn;
```

---
## Constant Naming 
* Use ALL CAPS with words separated by an underscore (_).
* Constant names should clearly indicate the value they hold.
```java
public static final String BASE_URL = "https://www.saucedemo.com";  
public static final int MAX_RETRY = 3;
```


Reference 
1. [Coding conventions for Java Programming Language](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)



