package stepdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    @And("I Input Photo Profile")
    public void iInputPhotoProfile() {
        WebElement InputProfile = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input"));
        String Photo = "D:\\FILE\\FILE DANDI\\FOTO\\PAS FOTO\\dANDI.jpg";
        InputProfile.sendKeys(Photo);
    }
    @And("I Click Button Down Fill")
    public void iClickButtonDownFill() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]/button/i")).click();
    }
    @And("I Fill Field Employee Name")
    public void iFillFieldEmployeeName() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("Dandi");
    }
    @And("I Click Button Search")
    public void iClickButtonSearch() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
    }
    @Then("I Verify Appears Name = Dandi")
    public void iVerifyAppearsNameDandi() {
        pause(3000);
        WebElement Firstname = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div/div[2]/div[1]/div/div[2]"));
        String ActualName = Firstname.getText();
        String ExpectedName = "Muhamad Dandi";
        Assert.assertEquals("Seharunya Muhamad",ExpectedName,ActualName);
        driver.quit();
    }
    @And("I Fill Field Employee ID")
    public void iFillFieldEmployeeID() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys("0385");
    }
    @Then("I Verify Appears ID")
    public void iVerifyAppearsID() {
        pause(3000);
        WebElement Value = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div/div[1]/div[1]/div/div/div[2]"));
        String ActualValue = Value.getText();
        String ExpectedValue = "0385";
        Assert.assertEquals(ExpectedValue,ActualValue);
    }
    @And("I click button Edit")
    public void iClickButtonEdit() {
        pause(3000);
        driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill")).click();
    }
    @And("I Update Lastname")
    public void iUpdateLastname() {
        pause(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("lastName")));
        lastNameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        pause(4000);
        driver.findElement(By.name("lastName")).sendKeys("Setiawan");
    }
    @And("I Click Button Save")
    public void iClickButtonSave() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")).click();
    }
    @Then("I Verify Update LastName")
    public void iVerifyUpdateLastName() {
        pause(4000);
        WebElement value = driver.findElement(By.name("lastName"));
        String ActualValue = value.getDomProperty("value");
        String Expected = "Setiawan";
        Assert.assertEquals(Expected,ActualValue);
    }
    @And("I click button Delete")
    public void iClickButtonDelete() {
        pause(3000);
        driver.findElement(By.cssSelector(".oxd-icon.bi-trash")).click();
    }
    @And("I click Yes, Delete")
    public void iClickYesDelete() {
        pause(3000);
        driver.findElement(By.cssSelector(".oxd-icon.bi-trash.oxd-button-icon")).click();
    }
    @Then("I Verify name was Delete is not Appear")
    public void iVerifyNameWasDeleteIsNotAppear() {
        pause(4000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        pause(4000);
        WebElement value = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
        String ActualValue = value.getText();
        String ExpectedValue = "No Records Found";
        Assert.assertEquals(ExpectedValue,ActualValue);
    }
}
