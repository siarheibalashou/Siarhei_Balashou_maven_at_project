package tests.junit4;

import pages.demoqa.DemoQaSelectPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DemoQaTest {
    private DemoQaSelectPage demoQaSelectPage = new DemoQaSelectPage();
    private final String COLOR = "Green";

    @Test
    public void colorDropdownTest() {
        demoQaSelectPage.openDemoQaPage();
        demoQaSelectPage.selectColorMenu();
        //TODO
        assertEquals(String.format("Selected color is not %s", COLOR), COLOR, true);
    }
}
