package tests.testng;

import driver.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.booking.BookingHotelDetailsPage;
import pages.booking.BookingMainPage;
import pages.booking.BookingSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;


public class BookingTestNG {
    private BookingMainPage bookingMainPage = new BookingMainPage();
    private BookingSearchPage bookingSearchPage = new BookingSearchPage();
    private BookingHotelDetailsPage bookingHotelDetailsPage = new BookingHotelDetailsPage();

    @BeforeTest
    public void before() {
        bookingMainPage.openBookingInitialPage();
        bookingMainPage.dismissSignInPopup();
    }

    @Test
    public void lowRatingTest() {
        final double HOTEL_SCORE_EXPECTED = 6.1;
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
        final String CURRENCY_TOOLTIP_TEXT_EXPECTED = "Select your currency";
        Assert.assertEquals(bookingMainPage.getCurrencyTooltipText(), CURRENCY_TOOLTIP_TEXT_EXPECTED, "Incorrect currency tooltip text");
    }

    @Test
    public void languageTooltipTest() {
        final String LANGUAGE_TOOLTIP_TEXT_EXPECTED = "Select your language";
        Assert.assertEquals(bookingMainPage.getLanguageTooltipText(), LANGUAGE_TOOLTIP_TEXT_EXPECTED, "Incorrect language tooltip text");
    }

    @Test
    public void changeBookingColors() {
        bookingMainPage.inputPlace("London");
        bookingMainPage.clickSearchButton();
        bookingSearchPage.changeHotelElement(10, "green", "red");
        Utils.makeCurrentPageScreenshot("screenshot1123123213.png");
        Assert.assertTrue(true);
    }

    @AfterTest
    public void after() {
        Driver.closeBrowser();
    }
}