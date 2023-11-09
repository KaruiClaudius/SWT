package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import pom.TC_10_PAGE;

import java.io.File;
import java.io.IOException;

public class testcase10 {
    @Test
    public void TC10() throws IOException {
        WebDriver driver = driverFactory.getChromeDriver();
        pom.TC_10_PAGE page = new TC_10_PAGE(driver);

        // Step 1: Go to backend login page
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        // Step 2: Login with provided credentials
        page.login("user01", "guru99com");

        // Step 3: Navigate to Sales -> Orders menu
        page.closeMsgBox();
        page.goToOrders();

        page.EnterToOrderID();
        page.EnterFindDate();
        page.SearchButtonClick();
//     Take screenshot
        TakesScreenshot mobilePage =((TakesScreenshot)driver);
        File srcFile1= mobilePage.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile1, new File("D:\\selenium-webdriver-java-master\\src\\test\\java\\BAITAP\\backend.png"));


        driver.quit();
    }
}
