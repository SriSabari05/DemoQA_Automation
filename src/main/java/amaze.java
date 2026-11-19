import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amaze {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open Amazon
        driver.get("https://www.amazon.in");

        // Search Galaxy M37
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("twotabsearchtextbox"))).sendKeys("Samsung Galaxy M37");

        // Click Search
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("nav-search-submit-button"))).click();

        // Open first search result
        By firstResult = By.xpath(
                "(//div[@data-component-type='s-search-result']//a[contains(@class,'a-link-normal') and .//h2])[1]");

        wait.until(ExpectedConditions.elementToBeClickable(firstResult)).click();

        // Wait for product page
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("productTitle")));

        // Scroll down to RAM / Storage options
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 500);");

        // Select 8GB RAM + 128GB Storage
        By storageOption = By.xpath(
                "//*[contains(normalize-space(.),'8GB') and contains(normalize-space(.),'128GB')]");

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(storageOption));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", option);

        option.click();

        System.out.println("8GB + 128GB variant selected!");

        // Scroll to Add to Cart
        By addToCart = By.id("add-to-cart-button");

        WebElement cartButton = wait.until(
                ExpectedConditions.elementToBeClickable(addToCart));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", cartButton);

        cartButton.click();

        System.out.println("Add to Cart clicked!");

        driver.quit();
    }
}