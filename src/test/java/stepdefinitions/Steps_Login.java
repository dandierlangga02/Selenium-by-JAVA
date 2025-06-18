package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps_Login {
    WebDriver driver;

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Given("user open web {string}")
    public void UserOpenWeb(String Web){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pause(1000);
        driver.get(Web);
        pause(2000);
    }
    @When("user Input Valid Username & Valid Password")
    public void userInputValidUsernameValidPassword() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        pause(2000);
        driver.findElement(By.name("password")).sendKeys("admin123");
        pause(2000);
    }
    @When("user Input invalid Username & Valid Password")
    public void userInputInvalidUsernameValidPassword() {
        driver.findElement(By.name("username")).sendKeys("Dandi");
        pause(2000);
        driver.findElement(By.name("password")).sendKeys("Admin123");
        pause(2000);
    }
    @When("user Input valid Username & invalid Password")
    public void userInputValidUsernameInvalidPassword() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        pause(2000);
        driver.findElement(By.name("password")).sendKeys("Error123");
        pause(2000);
    }
    @When("user Input valid Username Empty")
    public void userInputValidUsernameEmpty() {
        driver.findElement(By.name("username")).sendKeys("");
        pause(2000);
        driver.findElement(By.name("password")).sendKeys("admin123");
        pause(2000);
    }
    @And("user Click button Login")
    public void userClickButtonLogin() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        pause(3000);
    }
    @Then("user verify Home Page")
    public void userVerifyHomePage() {
        String ActualUrl = driver.getCurrentUrl();
        String ExceptionUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(ExceptionUrl, ActualUrl);
    }
    @Then("user verify Error Message")
    public void userVerifyErrorMessage() {
        WebElement errorusername = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
        String actualError = errorusername.getText();
        Assert.assertTrue(actualError.contains("Invalid credentials"));
        driver.quit();
    }
    @Then("user verify Error Message Empty")
    public void userVerifyErrorMessageEmpty() {
        WebElement errorusername = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
        String actualError = errorusername.getText();
        Assert.assertTrue(actualError.contains("Required"));
    }
    @Then("user verify Color Text field change to red")
    public void userVerifyColorTextFieldChangeToRed() {
        WebElement inputField = driver.findElement(By.name("username"));
        String borderColor = inputField.getCssValue("border-color");
        String expectedColor = "rgb(235, 9, 16)";
        Assert.assertEquals("Expected border color to be red", expectedColor, borderColor);
    }
}
