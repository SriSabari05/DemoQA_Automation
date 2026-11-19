package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import java.time.Duration;

public class AppTest {

    WebDriver driver;

    String Uname = "Usname";
    String pass = "Password";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://leetcode.com/");
    }

    @Test(priority = 1)
    public void login() {

        driver.findElement(By.linkText("Sign in")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_login"))).sendKeys(Uname);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_password"))).sendKeys(pass);

        driver.findElement(By.xpath("//button[@id='signin_btn']")).click();

    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}