package tests.JUnit4;

import objects.booking.BookingHotelDetailsPage;
import objects.booking.BookingMainPage;
import objects.booking.BookingSearchPage;
import org.junit.After;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookingTest {
    BookingMainPage bookingMainPage = new BookingMainPage();
    BookingSearchPage bookingSearchPage = new BookingSearchPage();
    BookingHotelDetailsPage bookingHotelDetailsPage = new BookingHotelDetailsPage();
    final double HOTEL_SCORE_EXPECTED = 6.4;
    final String CURRENCY_TOOLTIP_TEXT_EXPECTED = "Select your currency";
    final String LANGUAGE_TOOLTIP_TEXT_EXPECTED = "Select your language";

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
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        bookingMainPage.inputPlace("Prague");
        bookingMainPage.inputPersons(2, 1);
        bookingMainPage.clickSearchButton();
        bookingSearchPage.checkboxRatingEnable(90);
        bookingSearchPage.openHotelDetailsPAge();
        //TODO
        bookingHotelDetailsPage.getRatingOnHotelDetailsPage();
        System.out.println(bookingHotelDetailsPage.getRatingOnHotelDetailsPage());
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
}
