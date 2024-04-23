package utils;

import driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {
    private static WebDriver driver = Driver.getDriver();

    public static void makeCurrentPageScreenshot(String screenshotFilePath) {
        File asfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(asfile, new File(screenshotFilePath));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
