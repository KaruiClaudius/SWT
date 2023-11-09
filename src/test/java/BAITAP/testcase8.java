package BAITAP;

import POM.TC_08_CheckOutPage;
import POM.TC_08_PAGE;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Random;

public class testcase8 {
    @Test
    public void TC08() {

        // Create a WebDriver instance
        WebDriver driver = driverFactory.getChromeDriver();

        TC_08_PAGE page = new TC_08_PAGE(driver);
        TC_08_CheckOutPage chkout = new TC_08_CheckOutPage(driver);

        // Step 1: Go to http://live.techpanda.org/
        page.goToHomePage();

        // Step 2: Click on My Account link
        page.clickMyAccount();

        // Step 3: Login in application using previously created credential
        page.login("quangnm@gmail.com", "123456");

        // Step 4: Click on 'REORDER' link , change QTY & click Update
        page.clickReorder();
        String OldgrandTotal = page.getOldGrandTotal();
        Random rnd = new Random();
        int randomQty = rnd.nextInt(250) + 1;
        page.changeQty(String.valueOf(randomQty));
        page.clickUpdate();

        // Step 5: Verify Grand Total is changed


        String grandTotal = page.getGrandTotal();
        System.out.println("Old Grand Total: " + OldgrandTotal);
        System.out.println("New Grand Total: " + grandTotal);
        assert !grandTotal.equals(OldgrandTotal) : "Failed update Grand Total!";
        System.out.println("Grand Total Updated");

        // Step 6: Complete Billing & Shipping Information
        chkout.clickProceedToCheckout();

        chkout.enterBillingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "20 Jump Street",
                "22 Jump Street", "Chicago", "Alabama", "123456",
                "United States", "1234567890", "654321");

        chkout.enterShippingInformation("New Address", "aaa",
                "aaa", "aaa", "FPT", "20 Jump Street",
                "22 Jump Street", "Chicago", "Alabama", "123456",
                "United States", "1234567890", "654321");

        chkout.selectShippingMethod();
        chkout.selectPaymentMethod();
        chkout.clickPaymentInfo();
        chkout.clickPlaceOrder();

        // Step 7: Verify order is generated and note the order number
        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = chkout.getOrderRecievedMessage();
        assert actualMessage.equals(expectedMessage) : "Order failed!";
        System.out.println("Order sent succeed");

        String orderNumber = chkout.getOrderNumber();
        System.out.println(orderNumber);


        // Close the browser
        driver.quit();
    }
}
