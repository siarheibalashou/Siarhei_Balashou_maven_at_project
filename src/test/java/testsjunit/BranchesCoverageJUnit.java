package testsjunit;

import day12.TestedClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BranchesCoverageJUnit {
    TestedClass testedClass = new TestedClass();

    @Test
    public void TrueTrue() {
        int number = testedClass.getNumber(-2, -2);
        assertEquals("conditions not met", 47, number);
    }

    @Test
    public void FalseFalse() {
        int number = testedClass.getNumber(0, 90);
        assertEquals("conditions not met", 100, number);
    }

    @Test
    public void FalseTrue() {
        int number = testedClass.getNumber(0, 12);
        assertEquals("conditions not met", 50, number);
    }

    @Test
    public void TrueFalse() {
        int number = testedClass.getNumber(-70, 8);
        assertEquals("conditions not met", -40, number);
    }

}
