package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    WebDriver driver;

    @Given("I open the Chrome browser 1")
    public void I_open_the_Chrome_browser_1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I navigate to web practice test automation")
    public void I_navigate_to_web_practice_test_automation() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        pause(1000);
    }

    @When("I Input Username and Password")
    public void I_Input_Username_and_Password() {
        driver.findElement(By.id("username")).sendKeys("student");
        pause(2000);
        driver.findElement(By.id("password")).sendKeys("Password123");
        pause(2000);
    }

    @When("I Input Not Valid Username and Valid Password")
    public void I_Input_Not_Valid_Username_and_Valid_Password() {
        driver.findElement(By.id("username")).sendKeys("incorrectUser");
        pause(2000);
        driver.findElement(By.id("password")).sendKeys("Password123");
        pause(2000);
    }

    @When("I Input Valid Username and Not Valid Password")
    public void I_Input_Valid_Username_and_Not_Valid_Password() {
        driver.findElement(By.id("username")).sendKeys("student");
        pause(2000);
        driver.findElement(By.id("password")).sendKeys("incorrectPassword");
        pause(2000);
    }

    @When("I Click Submit")
    public void I_Click_Submit() {
        driver.findElement(By.id("submit")).click();
        pause(2000);
    }

    @Then("I Verify appears wording successfully logged in")
    public void I_Verify_appears_wording_successfully_logged_in() {
        WebElement message = driver.findElement(By.className("post-title"));
        String actualText = message.getText();
        Assert.assertTrue("Expected success message not found!", actualText.contains("Logged In Successfully"));
        driver.quit();
    }

    @Then("I Verify error massage 'Your username is invalid!'")
    public void I_Verify_error_massage_Your_username_is_invalid() {
        WebElement message = driver.findElement(By.id("error"));
        String actualText = message.getText();
        Assert.assertTrue("Expected success message not found!", actualText.contains("Your username is invalid!"));
        driver.quit();
    }

    @Then("I Verify error massage 'Your password is invalid!'")
    public void I_Verify_error_massage_Your_password_is_invalid() {
        WebElement message = driver.findElement(By.id("error"));
        String actualText = message.getText();
        Assert.assertTrue("Expected success message not found!", actualText.contains("Your password is invalid!"));
        driver.quit();
    }

    // Reusable wait method
    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
