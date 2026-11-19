import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sample3 {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.geeksforgeeks.org/software-testing/selenium-handling-drop-downs-using-java/");

        // Click Widgets
       wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Types of Testing']"))).click();

        // Click Select Menu

        driver.findElement(By.xpath("//span[contains(text(),'Automation Testing')]")).click();
        System.out.println("Done");


        driver.quit();
    }
}
