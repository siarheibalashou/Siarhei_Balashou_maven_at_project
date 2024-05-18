package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportTestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getDescription());
        System.out.println("i am on start");
        TestRailReporter.reportResult("2355", result.getMethod().getDescription(), new Result(1));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getDescription());
        System.out.println("i am on finish");
        TestRailReporter.reportResult("2355", result.getMethod().getDescription(), new Result(5));
    }


}
