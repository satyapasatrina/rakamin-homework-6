package cucumber.step;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    protected WebDriver driver;

    public Driver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--headless");

        driver = new ChromeDriver(opts);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
