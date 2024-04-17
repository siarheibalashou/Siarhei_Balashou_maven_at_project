package objects.booking;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void inputPlace() {
        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        driver.findElement(By.xpath("//input[@name='ss']")).sendKeys("Paris");
        driver.findElement(By.xpath("//div[contains(@class,'a3332d346a') and text()='Paris']")).click();
    }

    public void inputPersons() {
        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();

        for (int numberOfAdults = 1; numberOfAdults <= 2; numberOfAdults++) {
            driver.findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div//button[2]")).click();
        }

        driver.findElement(By.xpath("//label[@for='no_rooms']/../following-sibling::div//button[2]")).click();
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
}
