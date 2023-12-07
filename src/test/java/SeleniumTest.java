import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);
    @BeforeTest
    void Setup(){

        options.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");

        driver.get("https://www.selenium.dev");
    }

    @Test
    void testSteps(){

    }
}
