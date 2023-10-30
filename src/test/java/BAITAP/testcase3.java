package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class testcase3 {
    @Test
    public void tc03() {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

//     // Create a new instance of the ChromeDriver
//     WebDriver driver = new ChromeDriver();
        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();


        // Step 1: Go to the website
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on "MOBILE" menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        // Step 3: Click on "ADD TO CART" for Sony Xperia mobile
//           WebElement addToCartBtn = driver.findElement(By.xpath("//button[@title='Add to Cart' and @class='button btn-cart']"));
        WebElement addToCartBtn = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
        addToCartBtn.click();
//       WebElement productInfo = driver.findElement(By.xpath("//div[@class='product-info']"));
//       WebElement addToCartBtn = productInfo.findElement(By.xpath(".//button[@title='Add to Cart']"));
//       WebElement h2Element = productInfo.findElement(By.xpath(".//h2//a[@title='Samsung']"));
//
//       addToCartBtn.click();


        // Step 4: Change "QTY" value to 1000 and click "UPDATE" button
//           WebElement qtyInput = driver.findElement(By.cssSelector("input[name='qty']"));
        WebElement qtyInput = driver.findElement(By.cssSelector("input[title='Qty']"));
        qtyInput.clear();
        qtyInput.sendKeys("1000");

        WebElement updateBtn = driver.findElement(By.cssSelector("button[title='Update']")); //Update Quantity
        updateBtn.click();

        // Step 5: Verify the error message
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-msg"));
        String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available.";
        String actualErrorMessage = errorMessage.getText();


//        if (actualErrorMessage.equals(expectedErrorMessage)) {
//            System.out.println("Error message is displayed correctly: " + actualErrorMessage);
//        } else {
//            System.out.println("Error message is not displayed correctly. Expected: " + expectedErrorMessage);
//        }
        AssertJUnit.assertEquals(expectedErrorMessage,actualErrorMessage);

        // Step 6: Click on "EMPTY CART" link
        WebElement emptyCartLink = driver.findElement(By.linkText("EMPTY CART"));
        emptyCartLink.click();

        // Step 7: Verify cart is empty
        WebElement emptyCartMessage = driver.findElement(By.cssSelector(".cart-empty"));
        String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
        String actualEmptyCartMessage = emptyCartMessage.getText();

//        if (actualEmptyCartMessage.equals(expectedEmptyCartMessage)) {
//            System.out.println("Cart is empty: " + actualEmptyCartMessage);
//        } else {
//            System.out.println("Cart is not empty. Expected: " + expectedEmptyCartMessage);
//        }
        AssertJUnit.assertEquals(expectedEmptyCartMessage, actualEmptyCartMessage);
        // Close the browser
        driver.quit();
    }
}
