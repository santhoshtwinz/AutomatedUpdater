package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Files;
import java.nio.file.Path;

public class DriverConfig {

    public static WebDriver driver;

    public void setUp() {
        // Create a unique temporary directory for each session
        try {
            Path tempDir = Files.createTempDirectory("chrome-user-data-dir");

            // Set ChromeOptions to specify the user-data-dir argument
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=" + tempDir.toString());  // Unique user data directory
            options.addArguments("--remote-allow-origins=*");  // This argument allows cross-origin requests

            // Initialize WebDriver with ChromeOptions
            driver = new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println("Error setting up the WebDriver: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
