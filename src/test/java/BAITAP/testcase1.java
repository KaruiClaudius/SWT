package BAITAP;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

public class testcase1 {
    @Test
    public void test() {
        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 2. Open target page - Login Form
            driver.get("http://live.techpanda.org/index.php/");
            // 3: Verify Title of the page
            String expectedTitle = "Home page";
            String actualTitle = driver.getTitle();
            if (actualTitle.contains(expectedTitle)) {
                System.out.println("Title matches: " + actualTitle);
            } else {
                System.out.println("Title doesn't match: " + actualTitle);
            }
            // 4: Click on MOBILE menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();
            TakesScreenshot beforeSC =((TakesScreenshot)driver);
            File srcFile1= beforeSC.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile1, new File("D:\\selenium-webdriver-java-master\\src\\test\\java\\BAITAP\\BeforeSort.png"));
            // 5: Select SORT BY dropdown as name
            WebElement sortDropdown = driver.findElement(By.xpath("//select[@title='Sort By']"));
            Select sortSelect = new Select(sortDropdown);
            sortSelect.selectByVisibleText("Name");
            // 6: Take a screenshot after sort
            TakesScreenshot afterSC =((TakesScreenshot)driver);
            File srcFile2= afterSC.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile2, new File("D:\\selenium-webdriver-java-master\\src\\test\\java\\BAITAP\\AfterSort.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
        // }
    }
}
