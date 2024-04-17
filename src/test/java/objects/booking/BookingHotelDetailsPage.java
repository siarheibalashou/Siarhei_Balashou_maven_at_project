package objects.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingHotelDetailsPage {
    WebDriver driver = Driver.getDriver();

    public String getRatingOnHotelDetailsPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='review-score-right-component']"))
                );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement hotelDetailsScore = driver.findElement(By.xpath("//div[@data-testid='review-score-right-component']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotelDetailsScore);
        return hotelDetailsScore.getText();

    }
}
