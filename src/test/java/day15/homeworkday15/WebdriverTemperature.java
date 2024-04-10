package day15.homeworkday15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebdriverTemperature {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-us");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("погода минск");
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).submit();
        driver.findElement(By.xpath("//a[text()='Change to English']")).click();
        String tomorrowName = driver.findElement(By.xpath("//div[@id='wob_dp']//div[@class='wob_df'][1]//div[@class='Z1VzSb']")).getAttribute("aria-label");
        String tomorrowTemperatureLocator = String.format("//div[@class='DYO8ie']/*[name()='svg']/*[name()='text' and contains(@aria-label,'Celsius %s 12:00')]", tomorrowName);
        //  WebElement textElem = driver.findElement(By.xpath(tomorrowTemperatureLocator));
        // System.out.println("Text from textelem - " + textElem.getText());
        System.out.println(driver.findElement(By.xpath(tomorrowTemperatureLocator)).getAttribute("aria-label"));
    }
}
