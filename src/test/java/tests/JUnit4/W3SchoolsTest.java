package tests.JUnit4;

import objects.google.GoogleMainPage;
import objects.google.GoogleSearchResultsPage;
import objects.w3schools.W3SchoolsMainPage;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class W3SchoolsTest {
    W3SchoolsMainPage w3SchoolsMainPage = new W3SchoolsMainPage();
    GoogleMainPage googleMainPage = new GoogleMainPage();
    GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage();

    @Test
    public void googleContainsTextTest() {
        w3SchoolsMainPage.openW3SchoolsPage();
        w3SchoolsMainPage.copyHeaderText();
        w3SchoolsMainPage.redirectToGoogle();
        googleMainPage.switchLanguage();
        googleMainPage.pasteTextAndSearch();
        assertEquals(String.format("Element not contains text %s", w3SchoolsMainPage.getHeaderText()), true, googleSearchResultsPage.allSearchResultsContainText());
    }

}
