package tests.testng;

import objects.google.GoogleMainPage;
import objects.google.GoogleSearchResultsPage;
import objects.w3schools.W3SchoolsMainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class W3SchoolsTestNG {
    W3SchoolsMainPage w3SchoolsMainPage = new W3SchoolsMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();

    @Test
    public void googleContainsTextTest() {
        w3SchoolsMainPage.openW3SchoolsPage();
        w3SchoolsMainPage.copyHeaderText();
        String PART_OF_SEARCH_RESULTS = w3SchoolsMainPage.getHeaderText();
        w3SchoolsMainPage.redirectToGoogle();
        googleMainPage.switchLanguage();
        googleMainPage.pasteTextAndSearch();
        boolean containsText = true;
        for (WebElement searchElement : googleSearchResultsPage.getSearchResults()) {

            String headerText = searchElement.getText().toLowerCase();
            if (!headerText.contains(PART_OF_SEARCH_RESULTS.toLowerCase())) {
                containsText = false;
                break;
            }
        }
        Assert.assertEquals(containsText, true, String.format("Element not contains text %s", PART_OF_SEARCH_RESULTS));
    }
}
