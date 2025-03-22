package AutomatedUpdater;  // Use the correct package for your project

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Specify that JUnit should run this class with Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",  // Path to your feature files
    glue = "src/test/java/stepDefinitions",  // Correct package where your step definitions are
    plugin = {"pretty", "html:target/cucumber-report.html"} // Optional: Generate a report
)
public class CucumberTestRunner {
}
