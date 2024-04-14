package day15.homeworkday15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


public class WebdriverTemperature {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-US");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("погода минск");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).submit();
        driver.findElement(By.xpath("//a[text()='Change to English']")).click();
        String tomorrowName = LocalDate.now().plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
        String tomorrowTemperatureLocator = String.format("//*[name()='text' and contains(@aria-label,'Celsius %s 12:00')]", tomorrowName);
        WebElement textElem = driver.findElement(By.xpath(tomorrowTemperatureLocator));
        System.out.println("Text from textelem - " + textElem.getText());
        System.out.println(driver.findElement(By.xpath(tomorrowTemperatureLocator)).getAttribute("aria-label"));
    }
}