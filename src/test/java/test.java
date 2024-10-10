import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class test {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramya\\Desktop\\new\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qafitnessapp.ccbp.tech/gym/login");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(priority = 1)
    public void testemptyinputfields(){
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("error-message-text"))));
        WebElement erroromessage = driver.findElement(By.className("error-message-text"));
        String error = erroromessage.getText().trim();
        String expect = "Invalid user ID";
        Assert.assertEquals(error,expect,"Error text with empty input fields does not match");

    }
    @Test(priority = 2)
    public void testemptyuseridfields(){
        WebElement pin = driver.findElement(By.id("pinInput"));
        pin.sendKeys("231225");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("error-message-text"))));
        WebElement erroromessage = driver.findElement(By.className("error-message-text"));
        String error = erroromessage.getText().trim();
        String expect = "Invalid user ID";
        Assert.assertEquals(error,expect,"Error text with empty input fields does not match");

    }
    @Test(priority = 3)
    public void testemptypinfields(){
        WebElement userid = driver.findElement(By.id("userIdInput"));
        userid.sendKeys("142420");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("error-message-text"))));
        WebElement erroromessage = driver.findElement(By.className("error-message-text"));
        String error = erroromessage.getText().trim();
        String expect = "Invalid PIN";
        Assert.assertEquals(error,expect,"Error text with empty input fields does not match");

    }
    @Test(priority = 4)
    public void testinvalidfields(){
        WebElement userid = driver.findElement(By.id("userIdInput"));
        userid.sendKeys("142420");
        WebElement pin = driver.findElement(By.id("pinInput"));
        pin.sendKeys("123456");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("error-message-text"))));
        WebElement erroromessage = driver.findElement(By.className("error-message-text"));
        String error = erroromessage.getText().trim();
        String expect = "User ID and PIN didn't match";
        Assert.assertEquals(error,expect,"Error text with empty input fields does not match");

    }
    @Test(priority = 5)
    public void testvalidfields(){
        WebElement userid = driver.findElement(By.id("userIdInput"));
        userid.sendKeys("142420");
        WebElement pin = driver.findElement(By.id("pinInput"));
        pin.sendKeys("231225");
        WebElement login = driver.findElement(By.tagName("button"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qafitnessapp.ccbp.tech/"));
        String current = driver.getCurrentUrl();
        String expect = "https://qafitnessapp.ccbp.tech/";
        Assert.assertEquals(current,expect,"Error text with empty input fields does not match");

    }

}

