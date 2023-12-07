import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {
    public static ChromeOptions options;
    public static WebDriver driver;
    @BeforeTest
    void Setup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");

        driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev");
    }

    @Test
    void testSteps(){
        driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"m-documentationide\"]/span")).click();

        driver.findElement(By.xpath("//*[@id=\"docsearch-1\"]/button/span[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"docsearch-input\"]")).sendKeys("grid");

        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"docsearch-item-0\"]/a/div"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> firstItem.isDisplayed());

        firstItem.click();

    }
}
