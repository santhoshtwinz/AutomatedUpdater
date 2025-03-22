package AutomatedUpdater.stepDefinitions;  // Use the correct package name

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",  // Path to your feature files
    glue = "AutomatedUpdater.stepDefinitions",  // Path to your step definition classes
    plugin = {"pretty", "html:target/cucumber-report.html"}  // Optional reporting
)
public class CucumberTestRunner {
}
