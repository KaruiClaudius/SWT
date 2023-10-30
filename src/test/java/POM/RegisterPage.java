package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    private By firstNameLocator = By.id("firstname");
    private By middleNameLocator = By.id("middlename");
    private By lastNameLocator = By.id("lastname");
    private By emailLocator = By.id("email_address");
    private By passwordLocator = By.id("password");
    private By confirmPasswordLocator = By.id("confirmation");
    private By registerButtonLocator = By.cssSelector("button[title='Register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void setMiddleName(String middleName) {
        driver.findElement(middleNameLocator).sendKeys(middleName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);
    }

    public void clickRegister() {
        driver.findElement(registerButtonLocator).click();
    }
}
