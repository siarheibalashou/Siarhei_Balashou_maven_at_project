package objects.google;

import driver.Driver;
import objects.w3schools.W3SchoolsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchResultsPage {
    WebDriver driver = Driver.getDriver();

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
    }
}
