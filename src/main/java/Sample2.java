import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("JAVA")).click();
        Thread.sleep(3000);
        //driver.findElement(By.cssSelector("a[title='Menu']")).click();
        driver.findElement(By.cssSelector("a[href='java_conditions.asp']")).click();
        driver.navigate().back();
        driver.navigate().to("https://www.w3schools.com/python/default.asp");
        driver.quit();
    }
}
