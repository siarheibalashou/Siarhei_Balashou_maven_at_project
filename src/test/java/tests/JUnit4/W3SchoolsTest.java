package tests.JUnit4;

import objects.google.GoogleMainPage;
import objects.google.GoogleSearchResultsPage;
import objects.w3schools.W3SchoolsMainPage;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

public class W3SchoolsTest {
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
        //TODO
        assertEquals(String.format("Element not contains text %s", PART_OF_SEARCH_RESULTS), true, containsText);
    }

}
