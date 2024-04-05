package testngsuite;

import day12.TestedClass;
import org.junit.Test;
import org.testng.Assert;

import static junit.framework.TestCase.assertEquals;

public class ConditionsCoverageTestNg {

    TestedClass testedClass = new TestedClass();

    @Test
    public void yLessZMore() {
        int number = testedClass.getNumber(-2, -2);
        Assert.assertEquals(number, 47, "conditions not met");
    }

    @Test
    public void yMoreZLess() {
        int number = testedClass.getNumber(-50, -2);
        Assert.assertEquals(number, -25, "conditions not met");
    }
}
