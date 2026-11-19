import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DriverTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://leetcode.com");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Sign in"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("id_login"))).sendKeys("srisabari5824@gmail.com");

        driver.findElement(By.id("id_password"))
                .sendKeys("Tessaract@5824");

        System.out.println("Page title: " + driver.getTitle());


        //driver.quit();
    }
}
