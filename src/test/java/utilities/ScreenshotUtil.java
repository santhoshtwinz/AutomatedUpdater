package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        // Take screenshot and store it in a temporary file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the directory where the screenshot will be saved
        String directoryPath = "target/screenshots/";

        // Create a timestamp for unique screenshot names
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        
        File destination = new File(directoryPath + fileName);

        try {
            // Create the screenshots folder if it doesn't exist
            File dir = new File(directoryPath);
            if (!dir.exists()) {
                dir.mkdirs();  // Create the directory if it doesn't exist
            }
            
            // Copy the screenshot to the specified location
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
