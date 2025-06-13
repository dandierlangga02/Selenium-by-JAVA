package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogleSteps {
    WebDriver driver;

    @Given("I open the Chrome browser")
    public void i_open_the_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("I navigate to the Google homepage")
    public void i_navigate_to_the_google_homepage() {
        driver.get("https://www.google.com");
    }

    @Then("The Google homepage should be displayed")
    public void the_google_homepage_should_be_displayed() {
        String title = driver.getTitle();

        if (title == null || !title.contains("Google")) {
            throw new AssertionError("Google homepage not displayed. Title was: " + title);
        }
        driver.quit();
    }
}