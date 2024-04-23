package tests.junit4;

import pages.booking.BookingHotelDetailsPage;
import pages.booking.BookingMainPage;
import pages.booking.BookingSearchPage;
import org.junit.Test;
import utils.Utils;

import static junit.framework.TestCase.assertEquals;


public class BookingTest {
    private BookingMainPage bookingMainPage = new BookingMainPage();
    private BookingSearchPage bookingSearchPage = new BookingSearchPage();
    private BookingHotelDetailsPage bookingHotelDetailsPage = new BookingHotelDetailsPage();
    private final double HOTEL_SCORE_EXPECTED = 6.1;
    private final String CURRENCY_TOOLTIP_TEXT_EXPECTED = "Select your currency";
    private final String LANGUAGE_TOOLTIP_TEXT_EXPECTED = "Select your language";

    @Test
    public void lowRatingTest() {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        bookingMainPage.inputPlace("Paris");
        bookingMainPage.inputPersons(4, 2);
        bookingMainPage.inputDate();
        bookingMainPage.clickSearchButton();
        bookingSearchPage.checkboxRatingEnable(60);
        bookingSearchPage.sortingEnable();
        assertEquals(String.format("Rating of first hotel is not %s", HOTEL_SCORE_EXPECTED), String.format("Scored %s", HOTEL_SCORE_EXPECTED), bookingSearchPage.getRating());
    }

    @Test
    public void highRatingTest() {
        double limitScore = 9.0;
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        bookingMainPage.inputPlace("Prague");
        bookingMainPage.inputPersons(2, 1);
        bookingMainPage.clickSearchButton();
        bookingSearchPage.checkboxRatingEnable(90);
        bookingSearchPage.openHotelDetailsPAge();
        //TODO
        bookingHotelDetailsPage.getRatingOnHotelDetailsPage();
        boolean result = bookingHotelDetailsPage.getRatingOnHotelDetailsPage() >= limitScore;
        assertEquals("Rating less than expected", true, result);
    }

    @Test
    public void currencyTooltipTest() {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        assertEquals("Incorrect currency tooltip text", CURRENCY_TOOLTIP_TEXT_EXPECTED, bookingMainPage.getCurrencyTooltipText());
    }

    @Test
    public void languageTooltipTest() {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        assertEquals("Incorrect currency tooltip text", LANGUAGE_TOOLTIP_TEXT_EXPECTED, bookingMainPage.getLanguageTooltipText());
    }

    @Test
    public void changeBookingColors() throws InterruptedException {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        bookingMainPage.inputPlace("London");
        bookingMainPage.clickSearchButton();
        bookingSearchPage.changeHotelElement(10, "green", "red");
        Utils.makeCurrentPageScreenshot("C:\\CoursesProject\\screenshots_at\\screenshot1.png");
    }
}
