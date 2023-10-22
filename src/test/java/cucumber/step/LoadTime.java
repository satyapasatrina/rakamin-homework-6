package cucumber.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadTime extends Driver {

    private long start_time;
    private long end_time;

    @Given("user is on saucedemo login page for LoadTime")
    public void user_is_on_saucedemo_login_page_for_loadtime() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user input {string} and {string}")
    public void user_input_username_and_password(String username, String password) {
        driver.findElement(new By.ByXPath("/html//input[@id='user-name']")).sendKeys(username);
        driver.findElement(new By.ByXPath("/html//input[@id='password']")).sendKeys(password);
    }

    @When("start timer")
    public void start_timer() {
        start_time = System.currentTimeMillis();
    }

    @When("user click login for loadtime")
    public void user_click_login() {
        driver.findElement(new By.ByXPath("/html//input[@id='login-button']")).click();
    }

    @When("stop timer")
    public void stop_timer() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ExpectedCondition<WebElement> footerCondition = ExpectedConditions.presenceOfElementLocated(By.xpath("//footer[@class='footer']//ul[@class='social']"));
        webDriverWait.until(footerCondition);
        end_time = System.currentTimeMillis();
    }

    @Then("total load time after login is under {long}")
    public void total_load_time_after_login_is_acceptable(long max_loadtime) {
        long total_time = end_time - start_time;

        if(total_time > max_loadtime) {
            Assert.fail("Load time is " + total_time);
        }
    }
}
