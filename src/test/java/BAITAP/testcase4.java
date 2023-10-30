package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class testcase4 {
    @Test
    public void tc04() {
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

        // Step 2: Click on "MOBILE" menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        // Step 3: Click on "Add To Compare" for 2 mobiles (Sony Xperia & iPhone)

        WebElement sonyXperiaCompareBtn = driver.findElement(By.cssSelector(".item:nth-child(2) .link-compare"));
        sonyXperiaCompareBtn.click();

        WebElement iPhoneCompareBtn = driver.findElement(By.cssSelector(".item:nth-child(3) .link-compare"));
        iPhoneCompareBtn.click();

        // Step 4: Click on "COMPARE" button
        WebElement compareBtn = driver.findElement(By.cssSelector("button[title='Compare']"));
        compareBtn.click();

        // Step 5: Verify the pop-up window and check the selected products
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
//            for (String handle : driver.getWindowHandles()) {
//                driver.switchTo().window(handle);
//            }

        // Verify heading "COMPARE PRODUCTS" and selected products in it
//            WebElement compareHeading = driver.findElement(By.cssSelector("h1.product-comparison-heading"));
        WebElement compareHeading = driver.findElement(By.cssSelector("h1"));
        String expectedHeading = "COMPARE PRODUCTS";
        String actualHeading = compareHeading.getText();

//        if (actualHeading.equals(expectedHeading)) {
//            System.out.println("Pop-up window is displayed with correct heading: " + actualHeading);
//        } else {
//            System.out.println("Pop-up window is not displayed correctly. Expected heading: " + expectedHeading);
//        }
        AssertJUnit.assertEquals(expectedHeading, actualHeading);
//
//            WebElement selectedProducts = driver.findElement(By.cssSelector("td.product-name"));
//            String selectedProductsText = selectedProducts.getText();
//
//            if (selectedProductsText.contains("Sony Xperia") && selectedProductsText.contains("iPhone")) {
//                System.out.println("Selected products are reflected in the pop-up window: " + selectedProductsText);
//            } else {
//                System.out.println("Selected products are not reflected correctly in the pop-up window.");
//            }

        // Step 6: Close the pop-up window
        driver.close();

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);

        // Close the browser
        driver.quit();
    }
}
