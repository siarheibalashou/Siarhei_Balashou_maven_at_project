package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit4.BookingTest;
import tests.junit4.DemoQaTest;
import tests.junit4.W3SchoolsTest;

public class JUnitRunner {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({BookingTest.class, DemoQaTest.class, W3SchoolsTest.class})

    public class RunnerForJUnitTests {
    }
}
