package tests.junit4;

import objects.demoqa.DemoQaSelectPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DemoQaTest {
    DemoQaSelectPage demoQaSelectPage = new DemoQaSelectPage();
    private final String COLOR= "Green";

    @Test
    public void colorDropdownTest() {
        demoQaSelectPage.openDemoQaPage();
        demoQaSelectPage.selectColorMenu();
        //TODO
        assertEquals(String.format("Selected color is not %s",COLOR),COLOR,true);
    }
}
