import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Amazon {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in");

            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
            searchBox.sendKeys("Samsung Galaxy M37");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();

            By firstProduct = By.xpath("(//div[@data-component-type='s-search-result']//a[.//h2])[1]");

            wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));

            js.executeScript("window.scrollBy(0, 500);");

            By variant = By.xpath(
                    "//*[self::li or self::button or self::span][contains(.,'8GB') and contains(.,'128GB')]");

            WebElement variantOption = wait.until(
                    ExpectedConditions.elementToBeClickable(variant));

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", variantOption);
            variantOption.click();

            System.out.println("Variant selected successfully");

            By addToCart = By.id("add-to-cart-button");

            WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCart));

            js.executeScript("arguments[0].scrollIntoView({block:'center'});", cartButton);
            cartButton.click();

            System.out.println("Add to Cart clicked");

            By cartLink = By.id("nav-cart");
            wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-active-cart")));

            System.out.println("Cart page opened successfully");

        } catch (Exception e) {
            System.out.println("Automation failed: " + e.getMessage());

        } finally {
            driver.quit();
        }
    }
}