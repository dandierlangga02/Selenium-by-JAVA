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

public class CRUD {
    WebDriver driver ;

    @Given("I open the Chrome browser 3")
        public void I_open_the_Chrome_browser_3 (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pause(1000);
        }

    @When("I navigate to website 2 {string}")
    public void I_navigate_to_website_2 (String url){
        driver.get(url);
        pause(1000);
    }

    @And("I Click Button Add")
    public void I_Click_Button_Add (){
        driver.findElement(By.id("addNewRecordButton")).click();
        pause(2000);
    }

    @And("I Input First Name 1")
    public void I_Input_First_Name (){
        driver.findElement(By.id("firstName")).sendKeys("Muhamad Dandi");
    }

    @And("I Input Last Name 1")
    public void I_Input_Last_Name (){
        driver.findElement(By.id("lastName")).sendKeys("Erlangga");
    }

    @And("I Input email 1")
    public void I_Input_Email (){
        driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
    }

    @And("I Input Age 1")
    public void I_Input_Age (){
        driver.findElement(By.id("age")).sendKeys("20");
    }

    @And("I Input salary")
    public void I_Input_salary (){
        driver.findElement(By.id("salary")).sendKeys("100000");
    }

    @And("I Input Department")
    public void I_Input_Department (){
        driver.findElement(By.id("department")).sendKeys("Test");
    }

    @And("I Click Button Submit")
    public void I_Click_Button_Submit (){
        driver.findElement(By.id("submit")).click();
    }

    @Then("I verify Data")
    public void I_verify_data (){
        WebElement element = driver.findElement(By.className("rt-tbody"));
        String Actual = element.getText();
        Assert.assertTrue("Data Dandi tidak ditemukan", Actual.contains("Dandi"));
        driver.quit();
    }


    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
