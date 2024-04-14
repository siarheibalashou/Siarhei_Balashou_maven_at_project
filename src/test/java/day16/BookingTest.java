package day16;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class BookingTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        driver.findElement(By.xpath("//input[@name='ss']")).sendKeys("Paris");
        driver.findElement(By.xpath("//div[contains(@class,'a3332d346a') and text()='Paris']")).click();
        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();

        for (int numberOfAdults = 1; numberOfAdults <= 2; numberOfAdults++) {
            driver.findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div//button[2]")).click();
        }

        driver.findElement(By.xpath("//label[@for='no_rooms']/../following-sibling::div//button[2]")).click();
        driver.findElement(By.xpath("//div[@data-testid='occupancy-popup']/button")).click();
        driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']")).click();
        LocalDate dateStartRent = LocalDate.parse(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LocalDate dateFinishRent = LocalDate.parse(dateStartRent.plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", dateStartRent))).click();
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", dateFinishRent))).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement checkBoxRating = driver.findElement(By.xpath("//input[@value='review_score=60' and contains(@id,'r1')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBoxRating);
        checkBoxRating.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='skeleton-loader-card'][1]"))
                );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement sortButton = driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sortButton);
        sortButton.click();
        driver.findElement(By.xpath("//span[text()='Property rating (low to high)']")).click();

        //driver.quit();

    }
}

//span[@data-testid='preferred-badge']