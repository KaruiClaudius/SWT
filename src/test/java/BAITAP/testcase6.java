package BAITAP;
import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class testcase6 {
    @Test
    public void main() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");
        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckOutPage checkoutPage = new CheckOutPage(driver);

        loginPage.clickOnMyAccountLink();
        loginPage.login("quangnm@gmail.com", "123456");

        cartPage.clickOnMyWishlistLink();
        cartPage.clickOnMyAddToCartLink();
        cartPage.enterShippingInformation("United States", "New York", "2000");
        cartPage.clickOnEstimateLink();

        String shippingCost = cartPage.getShippingCost();
        System.out.println("Shipping cost: " + shippingCost);

        cartPage.selectShippingCost();

        cartPage.updateTotalCost();
        String totalCost = cartPage.getTotalCost();
        System.out.println("Total cost: " + totalCost);

        checkoutPage.clickProceedToCheckout();

        checkoutPage.enterBillingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "20 Jump Street",
                "22 Jump Street", "Chicago", "Alabama", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.enterShippingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "20 Jump Street",
                "22 Jump Street", "Chicago", "Alabama", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.click();

        checkoutPage.selectShippingMethod();

        checkoutPage.selectPaymentMethod();

        checkoutPage.clickPaymentInfo();

        checkoutPage.clickPlaceOrder();

        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = checkoutPage.getOrderRecievedMessage();
        assert actualMessage.equals(expectedMessage) : "Order failed!";
        System.out.println("Order sent succeed");

        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println(orderNumber);

        driver.quit();
    }
}
