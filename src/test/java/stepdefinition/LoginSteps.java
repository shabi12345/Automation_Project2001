package stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    

    @Given("the user is on the login page")
    public void userOnLoginPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/"); // Replace with the actual login page URL
    }

    @When("the user enters valid credentials {string} and {string}")
    public void theUserEntersValidCredentials(String username, String password) {
        // Locate username and password fields using updated locators
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void theUserEntersInvalidCredentials(String username, String password) {
        // Locate username and password fields using updated locators
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("the user leaves the username and password fields blank")
    public void theUserLeavesTheUsernameAndPasswordFieldsBlank() {
        // Leave both fields blank
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        usernameField.clear();
        passwordField.clear();
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        // Locate the login button using updated locator and click it

        WebElement loginButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        loginButton.click();
    }

    @Then("the user should be redirected to the dashboard page")
    public void theUserShouldBeRedirectedToTheDashboardPage() {
        // Validate successful redirection to the dashboard page
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The user was not redirected to the dashboard page!");
        driver.quit();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        // Validate that an error message is displayed for invalid credentials
        WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }

    @Then("an error message should be displayed indicating required fields")
    public void anErrorMessageShouldBeDisplayedIndicatingRequiredFields() {
        // Validate that an error message is displayed for blank fields
        WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(),'Required')]"));
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
