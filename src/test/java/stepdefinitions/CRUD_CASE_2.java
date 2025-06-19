package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRUD_CASE_2 {
    WebDriver driver;

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Given("I Open Website {string}")
    public void IOpenWebsite(String Web){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Web);
        pause(2000);
    }
    @When("I Login Website and Click Submit")
    public void ILoginWebsite(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        pause(3000);
    }
    @And("I Click Sub Menu PIM")
    public void iClickSubMenuPIM() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
        pause(2000);
    }
    @And("I Click +Add")
    public void iClickAdd() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        pause(2000);
    }
    @And("I Fill Data First Name, Middle Name, & Last name")
    public void iFillFirstName() {
        driver.findElement(By.name("firstName")).sendKeys("Muhamad");
        pause(1000);
        driver.findElement(By.name("middleName")).sendKeys("Dandi");
        pause(1000);
        driver.findElement(By.name("lastName")).sendKeys("Erlangga");
        pause(1000);
    }
    @And("I Click Create Login Details")
    public void iClickCreateLoginDetails() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")).click();
        pause(1000);
    }
    @And("I Fill Username, Password, & Confirm Password")
    public void iFillUsernamePasswordConfirmPassword() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")).sendKeys("danditest02");
        pause(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")).sendKeys("dandi123");
        pause(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")).sendKeys("dandi123");
        pause(1000);
    }
    @And("I click Bottom Save")
    public void iClickBottomSave() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
        pause(4000);
    }
    @Then("I Verify Data Add Employee")
    public void iVerifyDataAddEmployee() {
        WebElement Firstname = driver.findElement(By.name("firstName"));
        String ActualName = Firstname.getDomProperty("value");
        String ExpectedName = "Muhamad";
        Assert.assertEquals("Seharunya Muhamad",ExpectedName,ActualName);
        driver.quit();
    }
}
