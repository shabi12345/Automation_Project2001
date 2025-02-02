package stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Add_Employee {

	WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup() {
        // Initialize WebDriver before running the tests
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
    }
    @Given("I am logged in as an Administrator")
    public void i_am_logged_in_as_an_administrator() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	
    	WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The user was not redirected to the dashboard page!");
    }
@When("I navigate to the PIM page")
public void i_navigate_to_the_pim_page() {
    // Write code here that turns the phrase above into concrete actions
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement PIM_Navigation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")));
	PIM_Navigation.click();
}

@When("I click the Add button")
public void i_click_the_add_button() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement AddBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
	AddBtn.click();
}

@When("I enter {string} in the FirstName field")
public void i_enter_in_the_first_name_field(String firstname) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement Firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
	Firstname.sendKeys(firstname);
}

@When("I enter {string} in the LastName field")
public void i_enter_in_the_last_name_field(String lastname) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement Lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastName")));
	Lastname.sendKeys(lastname);
}

@When("I enter {string} in the Employee-id field")
public void i_enter_in_the_employee_id_field(String empid) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement Employee_id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")));
	Employee_id.sendKeys(empid);
}

@Then("I click on the Create Login Details toggle button")
public void i_click_on_the_create_login_details_toggle_button() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement togglebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")));
	togglebtn.click();
}

@Then("I enter {string} in the Username field")
public void i_enter_in_the_username_field(String username) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")));
	Username.sendKeys(username);
}

@Then("I enter {string} in the Password field")
public void i_enter_in_the_password_field(String password) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")));
	Password.sendKeys(password);
}



@After
public void tearown() {

	driver.close();
	
}
}