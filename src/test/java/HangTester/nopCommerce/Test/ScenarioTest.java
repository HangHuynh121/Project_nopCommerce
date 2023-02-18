package HangTester.nopCommerce.Test;

import HangTester.Helper.CaptureHelper;
import HangTester.nopCommerce.common.BaseTest;
import HangTester.nopCommerce.Listenner.TestListenner;
import HangTester.nopCommerce.Page.*;
import HangTester.utils.logFile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ScenarioTest extends BaseTest {
    public ScenarioFlow scenarioFlow;
    public ManufacturersPage manufacturersPage;
    public CategoriesPage categoriesPage;
    public VendorsPage vendorsPage;
    public ProductPage productPage;
    public CaptureHelper captureHelper;

    @BeforeMethod
    public void ScenarioTest(){

        scenarioFlow = new ScenarioFlow();
        manufacturersPage = new ManufacturersPage();
        categoriesPage = new CategoriesPage();
        vendorsPage = new VendorsPage();
        productPage = new ProductPage();
        captureHelper = new CaptureHelper();
    }

    @AfterMethod
    public void captureFail(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            captureHelper.captureScreenshot("ScenarioTest", "scenarioFlow");
        }
    }

    @Test
    public void scenarioTest() {
        logFile.info("ScenarioTest");
        scenarioFlow = new ScenarioFlow();
        manufacturersPage = scenarioFlow.login();
        categoriesPage = scenarioFlow.manufacturers();
        vendorsPage = scenarioFlow.category();
        productPage = scenarioFlow.vendor();
        scenarioFlow.product();
    }
}