package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TC_09_PAGE {
    private WebDriver driver;

    public TC_09_PAGE(WebDriver driver) {
        this.driver = driver;
    }

    private final By mobileMenu = By.linkText("MOBILE");
    private final By addToCartIphone = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)");
    private final By couponCodeInput = By.cssSelector("input[name='coupon_code']");
    private final By applyCouponButton = By.cssSelector("button[value='Apply']");
    private final By totalPrice = By.cssSelector("strong span[class='price']");

    // Step 2: Navigate to the 'Mobile' section
    public void clickOnMobileMenu() {
        driver.findElement(mobileMenu).click();
    }

    // Step 3: Add 'IPHONE' to cart
    public void addToCartIphone() {
        driver.findElement(addToCartIphone).click();
    }

    // Step 4: Enter the coupon code
    public void enterCouponCode(String code) {
        driver.findElement(couponCodeInput).sendKeys(code);
    }

    public void clickApplyCouponButton() {
        driver.findElement(applyCouponButton).click();
    }

    // Step 5: Get the original price
    public double getOriginalPrice() {
        return Double.parseDouble(driver.findElement(totalPrice).getText().replace("$", ""));
    }

    // Step 6: Get the discounted price
    public double getDiscountedPrice() {
        double originalPrice = getOriginalPrice();
        double discountedPrice = Double.parseDouble(driver.findElement(totalPrice).getText().replace("$", ""));
        // Step 6.4: Verify the discounted price
        Assert.assertEquals(discountedPrice, originalPrice * 0.95);

        return discountedPrice;
    }
    public void verifyDiscountAndPrintGrandTotals() {
        double originalPrice = getOriginalPrice();
        double discountedPrice = getDiscountedPrice();

        Assert.assertEquals(discountedPrice, originalPrice * 0.95);
        System.out.println("Price is discounted by 5%");

        System.out.println("Old Grand Total: $" + originalPrice);
        System.out.println("New Grand Total: $" + discountedPrice);
    }
}
