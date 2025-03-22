package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.StandardCopyOption;

public class DriverConfig {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setUp();
        }
        return driver;
    }

    public static void setUp() {
        try {
            // Create a unique temporary directory for each session
            Path tempDir = Files.createTempDirectory("chrome-user-data-dir-" + System.currentTimeMillis() + "-" + Thread.currentThread().getId());

            // Log the directory being used for the user-data-dir argument
            System.out.println("Using user data dir: " + tempDir.toString());

            // Set ChromeOptions
            ChromeOptions options = new ChromeOptions();

            // Add the user-data-dir argument for a unique session
            options.addArguments("user-data-dir=" + tempDir.toString());  

            // Add arguments for headless mode and other necessary flags
            options.addArguments("--headless");  // Enable headless mode
            options.addArguments("--no-sandbox");  // Disable sandboxing (required for CI environments)
            options.addArguments("--disable-dev-shm-usage");  // Prevent issues with shared memory in Docker containers
            options.addArguments("--remote-allow-origins=*");  // Allow cross-origin requests

            // Optionally, you can add other Chrome flags as needed
            // options.addArguments("--window-size=1920x1080");  // Set window size if needed in headless mode

            // Initialize WebDriver with ChromeOptions
            driver = new ChromeDriver(options);

        } catch (IOException e) {
            System.out.println("Error setting up the WebDriver: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to clean up the WebDriver after the test is finished
    public static void tearDown() {
        if (driver != null) {
            driver.quit();  // Ensure the WebDriver is properly closed
            driver = null;
        } else {
            System.out.println("WebDriver was not initialized properly.");
        }
    }

    // Optional: You can call this method to clean up temporary directories if needed
    private static void cleanUpTempDir(Path tempDir) throws IOException {
        if (Files.exists(tempDir)) {
            Files.walk(tempDir)
                .map(Path::toFile)
                .forEach(file -> {
                    if (file.isDirectory()) {
                        file.delete();
                    } else {
                        file.delete();
                    }
                });
        }
    }
}
