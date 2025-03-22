package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverConfig {

    public static WebDriver driver;

    public void setUp() {
        try {
            // Create a unique temporary directory for each session
            Path tempDir = Files.createTempDirectory("chrome-user-data-dir");

            // Log the directory being used for the user-data-dir argument
            System.out.println("Using user data dir: " + tempDir.toString());

            // Set ChromeOptions to specify the user-data-dir argument
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=" + tempDir.toString());  // Unique user data directory
            options.addArguments("--remote-allow-origins=*");  // This argument allows cross-origin requests

            // Initialize WebDriver with ChromeOptions
            driver = new ChromeDriver(options);

            // Optional: Maximize the window
            driver.manage().window().maximize();

        } catch (Exception e) {
            // Catch any exceptions and log them
            System.out.println("Error setting up the WebDriver: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void tearDown() {
        // Ensure that the driver is not null before quitting
        if (driver != null) {
            driver.quit();
        } else {
            System.out.println("WebDriver was not initialized properly.");
        }
    }
}
