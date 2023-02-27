package HangTester.nopCommerce.Listenner;

import HangTester.browsers.DriverManager;
import HangTester.reports.ExtentReportManager;
import HangTester.reports.ExtentTestManager;
import HangTester.utils.logFile;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    //Extent Report

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

        //Extent Report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getName());

        //Allure Report
        saveTextLog(result.getName());
        saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(result.getName(), "");
    }


}


