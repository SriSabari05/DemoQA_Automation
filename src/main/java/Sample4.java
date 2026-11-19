import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Sample4 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Continue shopping')]"))).click();

        WebElement option = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("searchDropdownBox")));

        Select select=new Select(option);

        select.selectByVisibleText("Books");
        List<WebElement> options=select.getOptions();
        for(WebElement opption: options){
            System.out.println(opption.getText());
        }

        driver.close();


    }
}
