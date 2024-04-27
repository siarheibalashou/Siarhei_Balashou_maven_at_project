package pages.booking;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingMainPage {
    WebDriver driver = Driver.getDriver();

    public void openBookingInitialPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");
    }

    public void dismissSignInPopup() {
        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
    }

    public void inputPlace(String cityName) {
        driver.findElement(By.xpath("//input[@name='ss']")).sendKeys(cityName);
        driver.findElement(By.xpath(String.format("//div[contains(@class,'a3332d346a') and text()='%s']", cityName))).click();
    }

    public void inputPersons(int personsAmount, int roomsAmount) {
        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
        if (personsAmount >= 3) {
            for (int i = 0; i < personsAmount - 2; i++) {
                driver.findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div//button[2]")).click();
            }
        } else if (personsAmount == 1) {
            driver.findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div//button[1]")).click();
        }
        if (roomsAmount >= 2) {
            for (int y = 0; y < roomsAmount - 1; y++) {
                driver.findElement(By.xpath("//label[@for='no_rooms']/../following-sibling::div//button[2]")).click();
            }
        }
        driver.findElement(By.xpath("//div[@data-testid='occupancy-popup']/button")).click();

    }

    public void inputDate() {
        driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']")).click();
        LocalDate dateStartRent = LocalDate.parse(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LocalDate dateFinishRent = LocalDate.parse(dateStartRent.plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", dateStartRent))).click();
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", dateFinishRent))).click();
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public String getCurrencyTooltipText() {
        WebElement currencyButton = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyButton);
        actions.perform();
        WebElement tooltipOfCurrencyButton = driver.findElement(By.xpath("//div[text()='Select your currency']"));
        return tooltipOfCurrencyButton.getText();
    }

    public String getLanguageTooltipText() {
        WebElement languageButton = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(languageButton);
        actions.perform();
        WebElement tooltipOfCurrencyButton = driver.findElement(By.xpath("//div[text()='Select your language']"));
        return tooltipOfCurrencyButton.getText();
    }
}
