package objects.google;

import driver.Driver;
import objects.w3schools.W3SchoolsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchResultsPage {
    WebDriver driver = Driver.getDriver();
    W3SchoolsMainPage w3SchoolsMainPage = new W3SchoolsMainPage();

    public boolean allSearchResultsContainText() {
        List<WebElement> tutorialElementsText = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        System.out.println(tutorialElementsText.size());

        boolean containsText = true;
        for (WebElement listElement : tutorialElementsText) {
            System.out.println(listElement.getText());
            String headerText = listElement.getText().toLowerCase();
            if (!headerText.contains(w3SchoolsMainPage.getHeaderText().toLowerCase())) {
                containsText = false;
                break;
            }
        }
        return containsText;
    }
}
