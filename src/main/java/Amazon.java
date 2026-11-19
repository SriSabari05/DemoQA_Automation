import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class Amazon{
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement locationBtn = wait.until( ExpectedConditions.elementToBeClickable(By.id("nav-global-location-popover-link")) );
        locationBtn.click();

        WebElement Input = wait.until( ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdateInput")) );
        Input.clear();
        Input.sendKeys("624001");

        System.out.println("Location Changed");

        WebElement apply = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("GLUXZipUpdate"))
        );
        apply.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("GLUXZipUpdateInput")));

        WebElement dropdownElement = wait.until( ExpectedConditions.presenceOfElementLocated(By.id("searchDropdownBox")) );

        Select dropdown = new Select(dropdownElement);

        List<WebElement> options = dropdown.getOptions();

        System.out.println("Total options: " + options.size());
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        dropdown.selectByVisibleText("Books");

        driver.quit();
    }
}