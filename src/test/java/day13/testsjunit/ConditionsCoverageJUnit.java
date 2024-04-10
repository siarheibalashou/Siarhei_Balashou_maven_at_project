package day13.testsjunit;

import day12.TestedClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConditionsCoverageJUnit {
    TestedClass testedClass = new TestedClass();

    @Test
    public void yLessZMore() {
        int number = testedClass.getNumber(-2, -2);
        assertEquals("conditions not met", 47, number);
    }

    @Test
    public void yMoreZLess() {
        int number = testedClass.getNumber(-50, -2);
        assertEquals("conditions not met", -25, number);
    }
}
