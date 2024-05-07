package tests.testng;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ReportTestListener;

@Listeners(ReportTestListener.class)
public class ReportTestNG {

    @Test(description = "157857")
    public void testPassed1() {
        Assert.assertTrue(true);
    }

    @Test(description = "157859")
    public void testPassed2() {
        Assert.assertTrue(true);
    }

    @Test(description = "157860")
    public void testPassed3() {
        Assert.assertTrue(true);
    }

    @Test(description = "157861")
    public void testFailed() {
        Assert.assertTrue(false);
    }
}
