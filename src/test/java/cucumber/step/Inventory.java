package cucumber.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Inventory extends Driver {

    @Given("user is on logged in using standard_user")
    public void user_is_logged_in_using_standard_user() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(new By.ByXPath("/html//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(new By.ByXPath("/html//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(new By.ByXPath("/html//input[@id='login-button']")).click();
    }

    @Given("user is on logged in using problem_user")
    public void user_is_logged_in_using_problem_user() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(new By.ByXPath("/html//input[@id='user-name']")).sendKeys("problem_user");
        driver.findElement(new By.ByXPath("/html//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(new By.ByXPath("/html//input[@id='login-button']")).click();
    }

    @When("user is on inventory page")
    public void user_is_on_inventory_page() {
        Assert.assertTrue("https://www.saucedemo.com/inventory.html".equals(driver.getCurrentUrl()));
    }

    @Then("user can view images correctly")
    public void user_can_view_images_correctly() {
        List<WebElement> elements = driver.findElements(new By.ByXPath("//img[@class='inventory_item_img']"));
        for (WebElement imgElement : elements) {
            String imgSrc = imgElement.getAttribute("src");
            Assert.assertNotEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", imgSrc);
        }
    }

    @Then("user can view images incorrectly")
    public void user_can_view_images_incorrectly() {
        List<WebElement> elements = driver.findElements(new By.ByXPath("//img[@class='inventory_item_img']"));
        for (WebElement imgElement : elements) {
            String imgSrc = imgElement.getAttribute("src");
            Assert.assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", imgSrc);
        }
    }
}
