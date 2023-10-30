package BAITAP;

import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.UUID;

public class testcase5 {
    @Test
    public void tc05() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\118.0.5993.118");
//
//        // Create a new instance of the ChromeDriver
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//         1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();

        // Step 1: Go to the website
        driver.get("http://live.techpanda.org/");

        // Step 3: Click on ACCOUNT
        WebElement accountMenu = driver.findElement(By.cssSelector(".account-cart-wrapper .label"));
        accountMenu.click();

        //Step 4: Click on Register
        WebElement registerMenu = driver.findElement(By.cssSelector("a[title='Register']"));
        registerMenu.click();

        //Step 5: Input fields
        RegisterPage registerPage = new RegisterPage(driver);

        // Step 5: Input fields using the Page Object Model
        registerPage.setFirstName("Quang");
        registerPage.setMiddleName("Nguyen Minh");
        registerPage.setLastName("Nguyen");
//        registerPage.setEmail("quangnm@gmail.com");
        String randomEmail = generateRandomEmail();
        registerPage.setEmail(randomEmail);
        registerPage.setPassword("123456");
        registerPage.setConfirmPassword("123456");
//        registerPage.setFirstName(generateRandomString());
//        registerPage.setMiddleName(generateRandomString());
//        registerPage.setLastName(generateRandomString());

        // Generate a random email to avoid the registered one

//        String randomPassword = generateRandomPassword();
//        registerPage.setPassword(randomPassword);
//        registerPage.setConfirmPassword(randomPassword);
        // Step 6: Click on REGISTER
        registerPage.clickRegister();

        //Step 7: Click on TV
        WebElement tvMenu = driver.findElement(By.linkText("TV"));
        tvMenu.click();

        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 8: Click on Add To Wishlist
        WebElement wishList = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
        wishList.click();

        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 9: Click on Share WishList
        WebElement shareWishList = driver.findElement(By.cssSelector("button[title='Share Wishlist']"));
        shareWishList.click();

        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 10: Input shared Email
        WebElement sharedEmail = driver.findElement(By.cssSelector("#email_address"));
        sharedEmail.click();
        sharedEmail.sendKeys("quangnm@gmail.com");

        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 11: Input message
        WebElement sharedMessage = driver.findElement(By.cssSelector("#message"));
        sharedMessage.click();
        sharedMessage.sendKeys("See yah");

        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Step 12: Share WishList
        WebElement share = driver.findElement(By.cssSelector("button[title='Share Wishlist']"));
        share.click();

        //Step 13: Check
        WebElement successMessageElement = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span"));
        String successMessage = successMessageElement.getText();
        String expectedMessage = "Your Wishlist has been shared.";

//        if (successMessage.equals(expectedMessage)) {
//            System.out.println("Wishlist shared successfully.");
//        } else {
//            System.out.println("Failed to share wishlist.");
//        }
        AssertJUnit.assertEquals(successMessage,expectedMessage);
        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Quit
        driver.quit();
    }
//    private String generateRandomString() {
//        // Generate a random string using UUID
//        return UUID.randomUUID().toString();
//    }

    private String generateRandomEmail() {
        // Generate a random email using UUID
        String emailPrefix = UUID.randomUUID().toString().substring(0, 10);
        return emailPrefix + "@example.com";
//        return UUID.randomUUID().toString() + "@example.com";
    }

//    private String generateRandomPassword() {
//        // Generate a random password using UUID
//        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8); // Adjust length as needed
//    }
}
