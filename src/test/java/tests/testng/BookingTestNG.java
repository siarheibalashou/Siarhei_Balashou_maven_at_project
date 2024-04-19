package tests.testng;

import objects.booking.BookingHotelDetailsPage;
import objects.booking.BookingMainPage;
import objects.booking.BookingSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;


public class BookingTestNG {
    BookingMainPage bookingMainPage = new BookingMainPage();
    BookingSearchPage bookingSearchPage = new BookingSearchPage();
    BookingHotelDetailsPage bookingHotelDetailsPage = new BookingHotelDetailsPage();
    final double HOTEL_SCORE_EXPECTED = 6.1;
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
        Assert.assertEquals(bookingSearchPage.getRating(), String.format("Scored %s", HOTEL_SCORE_EXPECTED), String.format("Rating of first hotel is not %s", HOTEL_SCORE_EXPECTED));
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
        Assert.assertEquals(result, true, "Rating less than expected");
    }

    @Test
    public void currencyTooltipTest() {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        Assert.assertEquals(bookingMainPage.getCurrencyTooltipText(), CURRENCY_TOOLTIP_TEXT_EXPECTED, "Incorrect currency tooltip text");
    }

    @Test
    public void languageTooltipTest() {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        Assert.assertEquals(bookingMainPage.getLanguageTooltipText(), LANGUAGE_TOOLTIP_TEXT_EXPECTED, "Incorrect currency tooltip text");
    }

    @Test
    public void changeBookingColors() throws InterruptedException {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
        bookingMainPage.inputPlace("London");
        bookingMainPage.clickSearchButton();
        bookingSearchPage.changeHotelElement(10, "green", "red");
        Utils.makeCurrentPageScreenshot("C:\\CoursesProject\\screenshots_at\\screenshot1.png");
        Assert.assertTrue(true);
    }
}