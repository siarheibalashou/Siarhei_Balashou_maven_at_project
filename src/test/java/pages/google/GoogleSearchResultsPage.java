package pages.google;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchResultsPage {
    WebDriver driver = Driver.getDriver();

    //TODO
    public List<WebElement> getSearchResults() {
        return driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
    }
}
