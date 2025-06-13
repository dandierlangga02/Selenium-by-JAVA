package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Register_account{
    WebDriver driver;

    @Given("I open the Chrome browser 2")
        public void I_open_the_Chrome_browser_2(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        }

    @When("I navigate to website {string}")
    public void I_navigate_to_website(String url){
        driver.get(url);
    }

    @And("I input Name and Email")
    public void I_input_Name_and_Email(){
        driver.findElement(By.name("name")).sendKeys("Muhamad Dandi Erlangga");
        pause(1000);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys("testautomation1@dandi.erlangga");
        pause(2000);
    }

    @And("I Click Signup")
    public void I_Click_Signup(){
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        pause(1000);
    }

    @And("I Choose Mr. in Radio Bottom")
    public void I_Choose_Radio_Bottom(){
        driver.findElement(By.id("id_gender1")).click();
        pause(1000);
    }

    @And("I Input Password")
    public void I_Input_Password(){
        driver.findElement(By.id("password")).sendKeys("TestAutomation123@");
        pause(1000);
    }

    @And("I Set Date Birth 02 December 1998")
    public void I_Set_Date_Birth(){
        Select DDDay = new Select(driver.findElement(By.id("days")));
        Select DDMonth = new Select(driver.findElement(By.id("months")));
        Select DDYear = new Select(driver.findElement(By.id("years")));

        DDDay.selectByValue("2");
        pause(1000);
        DDMonth.selectByValue("12");
        pause(1000);
        DDYear.selectByValue("1998");
        pause(1000);
    }

    @And("I Input First Name")
    public void I_Input_FN(){
        driver.findElement(By.id("first_name")).sendKeys("Muhamad Dandi");
        pause(1000);
    }

    @And("I Input Last Name")
    public void I_Input_LN(){
        driver.findElement(By.id("last_name")).sendKeys("Erlangga");
        pause(1000);
    }

    @And("I Input Company")
    public void I_Input_Company(){
        driver.findElement(By.id("company")).sendKeys("Tester Company");
        pause(1000);
    }

    @And("I Input Address")
    public void I_Input_Address(){
        driver.findElement(By.id("address1")).sendKeys("Singapore");
        pause(1000);
    }

    @And("I Input Address 2")
    public void I_Input_Address_2(){
        driver.findElement(By.id("address2")).sendKeys("Thailand");
        pause(1000);
    }

    @And("I Choose Country")
    public void I_Choose_Country(){
        Select DDCountry = new Select(driver.findElement(By.id("country")));

        DDCountry.selectByValue("Singapore");
    }

    @And("I Input State")
    public void I_Input_State(){
        driver.findElement(By.id("state")).sendKeys("DKI JAKARTA");
        pause(1000);
    }

    @And("I Input City")
    public void I_Input_City(){
        driver.findElement(By.id("city")).sendKeys("JAKARTA TIMUR");
        pause(1000);
    }

    @And("I Input Zipcode")
    public void I_Input_ZC(){
        driver.findElement(By.id("zipcode")).sendKeys("13110");
        pause(1000);
    }

    @And("I Input Mobile Number")
    public void I_Input_Mobile_Number(){
        driver.findElement(By.id("mobile_number")).sendKeys("081212341234");
        pause(1000);
    }

    @And("I click Create Account Bottom")
    public void click_Create_Account(){
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
        pause(6000);
    }

    @Then("I Verify wording Account Created!")
    public void I_Verify_wording() {
        WebElement message = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p[1]"));
        String actualText = message.getText();
        Assert.assertTrue("Expected success message not found!", actualText.contains("Congratulations! Your new account has been successfully created!"));
        pause(2000);
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
