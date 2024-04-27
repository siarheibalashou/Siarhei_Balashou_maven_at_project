package tests.junit4;

import pages.google.GoogleMainPage;
import pages.google.GoogleSearchResultsPage;
import pages.w3schools.W3SchoolsMainPage;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

public class W3SchoolsTest {
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
        assertEquals(String.format("Element not contains text %s", PART_OF_SEARCH_RESULTS), true, containsText);
    }

}
