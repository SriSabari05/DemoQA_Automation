import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Sample5 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for dropdown to be clickable
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("searchDropdownBox"))
        );

        dropdown.click();

        // Wait for option to be clickable
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//option[@value='search-alias=amazon-pharmacy']")
                )
        );

        option.click();
    }
}