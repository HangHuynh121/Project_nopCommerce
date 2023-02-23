package HangTester.nopCommerce.Listenner;

import HangTester.reports.ExtentReportManager;
import HangTester.reports.ExtentTestManager;
import HangTester.utils.logFile;
import com.aventstack.extentreports.Status;
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
        System.out.println("End testing " + result.getName());
        //Kêt thúc thực thi extent report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logFile.info("Status of case " + result.getName() + " is pass.");
        ExtentTestManager.logMessage(Status.PASS, result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logFile.info("Status of case " + result.getName() + " is fail.");
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(result.getName(), "");
    }

}


