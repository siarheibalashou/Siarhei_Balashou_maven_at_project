package tests.JUnit4;

import objects.booking.BookingMainPage;
import objects.booking.BookingSearchPage;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BookingTest {
    BookingMainPage bookingMainPage = new BookingMainPage();
    BookingSearchPage bookingSearchPage = new BookingSearchPage();
    final double HOTEL_SCORE_EXPECTED = 6.0;

    @Test
    public void ratingTest() {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.inputPlace();
        bookingMainPage.inputPersons();
        bookingMainPage.inputDate();
        bookingMainPage.clickSearchButton();
        bookingSearchPage.checkboxRatingEnable();
        bookingSearchPage.sortingEnable();
        assertEquals(String.format("Rating of first hotel is not %s", HOTEL_SCORE_EXPECTED), String.format("Scored %s", HOTEL_SCORE_EXPECTED), bookingSearchPage.getRating());
    }
}
