package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;

public class Driver {
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = getWebDriver();
        }
        return driver;
    }

    protected static Config config =
            Optional.ofNullable(System.getProperty("CONFIG")).isEmpty() ?
                    Config.CHROME : Config.valueOf(System.getProperty("CONFIG"));

    private static WebDriver getWebDriver() {
        return switch (config) {
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default -> getChromeDriver();
        };
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
//        caps.setExperimentalOption("excludeSwitches",
//                Collections.singletonList("enable-automation"));
        return new ChromeDriver(caps);
    }

    private static WebDriver getFFDriver() {
        return null;
    }

    private static WebDriver getRemoteDriver() {
        return null;
    }

    public static void closeBrowser() {
        driver.quit();
    }
}
