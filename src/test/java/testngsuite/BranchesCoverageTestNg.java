package testngsuite;

import day12.TestedClass;
import org.testng.annotations.Test;
import org.testng.Assert;


public class BranchesCoverageTestNg {
    TestedClass testedClass = new TestedClass();

    @Test
    public void TrueTrue() {
        int number = testedClass.getNumber(-2, -2);
        Assert.assertEquals(number, 47, "conditions not met");
    }

    @Test
    public void FalseFalse() {
        int number = testedClass.getNumber(0, 90);
        Assert.assertEquals(number, 90, "conditions not met");
    }

    @Test
    public void FalseTrue() {
        int number = testedClass.getNumber(0, 12);
        Assert.assertEquals(number, 50, "conditions not met");
    }

    @Test
    public void TrueFalse() {
        int number = testedClass.getNumber(-70, 8);
        Assert.assertEquals(number, -40, "conditions not met");
    }

}
