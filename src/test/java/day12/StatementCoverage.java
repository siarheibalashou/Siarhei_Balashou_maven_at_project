package day12;

import day12.TestedClass;

public class StatementCoverage {
    public static void main(String[] args) {
        TestedClass testedClass = new TestedClass();
//if (x < 0 && y < 10) -> (y < 0 || z > 50)
        if (testedClass.getNumber(-1, 9) == 48) {
            System.out.println("passed");
        } else System.out.println("failed");

// else -> (y < 0 || z > 50)
        if (testedClass.getNumber(1, 12) == 51) {
            System.out.println("passed");
        } else System.out.println("false");
    }
}
