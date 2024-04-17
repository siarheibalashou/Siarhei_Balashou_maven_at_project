package objects.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingSearchPage {
    WebDriver driver = Driver.getDriver();

    public void checkboxRatingEnable() {
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
    }

    public void sortingEnable() {
        WebElement sortButton = driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sortButton);
        sortButton.click();
        driver.findElement(By.xpath("//span[text()='Property rating (low to high)']")).click();
    }

    public String getRating() {
        return driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div")).getText();
    }
}
