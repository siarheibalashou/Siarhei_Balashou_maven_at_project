package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingSearchPage {
    WebDriver driver = Driver.getDriver();

    public void checkboxRatingEnable(int reviewScore) {
        WebElement checkBoxRating = driver.findElement(By.xpath(String.format("//input[@value='review_score=%s' and contains(@id,'r')]", reviewScore)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBoxRating);
        checkBoxRating.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        new WebDriverWait(driver, Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='skeleton-loader-card'][1]")));

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

    public void openHotelDetailsPAge() {
        WebElement hotelDetailsLink = driver.findElement(By.xpath("//h3[@class='aab71f8e4e'][1]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotelDetailsLink);
        hotelDetailsLink.click();
    }

    public void scrollToHotelNumber(int positionOnPage) {
        WebElement hotelCard = driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]", positionOnPage)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotelCard);
    }

    public void changeHotelElement(int positionOfHotelInSearchResults, String backgroundColor, String fontColor) {
        WebElement hotelCard = driver.findElement(By.xpath(String.format("//div[@data-testid='property-card'][%s]", positionOfHotelInSearchResults)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hotelCard);
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].style.backgroundColor='%s'", backgroundColor), hotelCard);
        ((JavascriptExecutor) driver).executeScript(String.format("arguments[0].style.color='%s'", fontColor), hotelCard);
    }
}
