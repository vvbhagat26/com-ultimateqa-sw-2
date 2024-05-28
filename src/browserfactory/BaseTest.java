package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;//decalre driver

    public void openBrowser(String baseUrl) {
        driver = new FirefoxDriver();

        driver.get(baseUrl);//assign to driver

        driver.manage().window().maximize();//maximise

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//wait
    }

    public void closeBrowser() {
        driver.quit();
    }
}
