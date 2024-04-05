import day12.TestedClass;

public class BranchCoverage {
    public static void main(String[] args) {
        TestedClass testedClass = new TestedClass();
        // else -> (y < 0 || z > 50)
        int num = testedClass.getNumber(12, 12);
        System.out.print(num);
        //  if (testedClass.getNumber(12,12)){}
    }
}

