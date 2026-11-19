

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DemoQAActions {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/dynamic-properties");
        WebElement visibleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        System.out.println("Visible button text: " + visibleButton.getText());


        WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        enableButton.click();
        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"), "class", "text-danger"));
        WebElement colorButton = driver.findElement(By.id("colorChange"));
        System.out.println("Color change button class: " + colorButton.getAttribute("class"));
        System.out.println("Dynamic Properties completed!");

        driver.get("https://demoqa.com/resizable");
        WebElement resizeBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resizableBoxWithRestriction")));
        WebElement resizeHandle = resizeBox.findElement(By.cssSelector(".react-resizable-handle"));
        actions.clickAndHold(resizeHandle).moveByOffset(150, 100).release().perform();

        System.out.println("Resizable box resized!");

        driver.get("https://demoqa.com/alerts");
        WebElement simpleAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));
        simpleAlertButton.click();

        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Simple Alert: " + alert1.getText());
        alert1.accept();

        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Timer Alert: " + alert2.getText());
        alert2.accept();

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirm Alert: " + alert3.getText());
        alert3.dismiss();
        WebElement confirmResult = driver.findElement(By.id("confirmResult"));
        System.out.println("Confirm result: " + confirmResult.getText());

        WebElement promptButton = driver.findElement(By.id("promtButton"));
        promptButton.click();

        Alert alert4 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Prompt Alert: " + alert4.getText());
        alert4.sendKeys("Selenium Testing");
        alert4.accept();

        WebElement promptResult = driver.findElement(By.id("promptResult"));
        System.out.println("Prompt result: " + promptResult.getText());
        System.out.println("All tasks completed successfully!");

        driver.quit();
    }
}