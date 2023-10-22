package cucumber.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends Driver {

    @Given("user is on saucedemo login page")
    public void user_is_on_saucedemon_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user input {string} as username")
    public void user_input_string_as_username(String username) {
        driver.findElement(new By.ByXPath("/html//input[@id='user-name']")).sendKeys(username);
    }

    @When("user input {string} as password")
    public void user_input_string_as_password(String password) {
        driver.findElement(new By.ByXPath("/html//input[@id='password']")).sendKeys(password);
    }

    @When("user click login")
    public void user_click_login() {
        driver.findElement(new By.ByXPath("/html//input[@id='login-button']")).click();
    }

    @Then("user verify {string} login result")
    public void user_verify_login_result(String result) {
        if ("success".equalsIgnoreCase(result)) {
            driver.getCurrentUrl();
            Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

        } else if ("failed".equalsIgnoreCase(result)) {
            try {
                Assert.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());
                WebElement elErrorMessage = driver.findElement(new By.ByXPath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
                Assert.assertTrue(null != elErrorMessage.getText() && !"".equalsIgnoreCase(elErrorMessage.getText()));
            } catch (Exception e) {
                Assert.fail();
            }

        }
    }
}
