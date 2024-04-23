package tests.testng;

import pages.google.GoogleMainPage;
import pages.google.GoogleSearchResultsPage;
import pages.w3schools.W3SchoolsMainPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class W3SchoolsTestNG {
    private W3SchoolsMainPage w3SchoolsMainPage = new W3SchoolsMainPage();
    private GoogleMainPage googleMainPage = new GoogleMainPage();
    private GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();

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
