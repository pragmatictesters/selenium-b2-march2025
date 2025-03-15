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



