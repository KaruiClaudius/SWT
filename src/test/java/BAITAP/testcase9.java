package BAITAP;

import POM.TC_09_PAGE;
import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testcase9 {
    @Test
    public void TC9() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        TC_09_PAGE page = new TC_09_PAGE(driver);

        page.clickOnMobileMenu();
        page.addToCartIphone();
        page.enterCouponCode("GURU50");
        page.clickApplyCouponButton();

        // Verify the discount and print old/new grand totals
        page.verifyDiscountAndPrintGrandTotals();

        driver.quit();
    }


}
