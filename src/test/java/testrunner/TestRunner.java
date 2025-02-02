package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\finds\\Downloads\\com.training.cucumber\\com.training.cucumber\\src\\test\\resources\\features\\Add_Employee.feature",  // Path to feature files
    glue = "stepdefinition/Add_Employee",                 // Path to step definitions
    plugin = {
        "pretty",                              // Pretty console output
        "html:target/cucumber-reports.html",   // HTML report
        "json:target/cucumber-reports.json"    // JSON report
    },
    monochrome = true                         // Better console output readability
)
public class TestRunner {
}