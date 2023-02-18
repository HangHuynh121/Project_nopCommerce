package HangTester.nopCommerce.Listenner;

import HangTester.utils.logFile;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenner implements ITestListener {

    @Override
    public void onStart(ITestContext result) {
        System.out.println("Start day: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("End day: " + result.getEndDate());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {
        logFile.info("Status of case " + result.getName() + " is pass.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logFile.info("Status of case " + result.getName() + " is fail.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestStart(ITestResult result) {

    }

 }


