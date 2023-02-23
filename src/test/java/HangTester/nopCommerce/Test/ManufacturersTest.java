package HangTester.nopCommerce.Test;

import HangTester.Helper.CaptureHelper;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.ManufacturersPage;
import HangTester.nopCommerce.common.BaseTest;
import HangTester.Helper.DataProviderManager;
import HangTester.Helper.ExcelHelper;
import HangTester.utils.logFile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ManufacturersTest extends BaseTest {

    public ManufacturersPage manufacturersPage;
    public CaptureHelper captureHelper;


    @BeforeMethod()
    public void ManufacturesTest() {
        manufacturersPage = new ManufacturersPage();
        captureHelper = new CaptureHelper();

    }

    @AfterMethod
    public void captureFail(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureHelper.captureScreenshot("ManufacturesTest", "manufacturesPage");
        }
    }

    @Test(priority = 1, dataProvider = "data_provider_manufactureAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String des, String priceF, String priceT) {
        logFile.info("ManufacturesTest");
        manufacturersPage.login();
        manufacturersPage.ManufactorItem(name, des);
        manufacturersPage.ManufactorDisplay(priceF, priceT, name);
    }

    @Test(priority = 2, dataProvider = "data_provider_manufactureEdit_excel", dataProviderClass = DataProviderManager.class)
    public void editNew(String name, String newName, String newDes) {
        logFile.info("ManufacturesTest");
        manufacturersPage.login();
        manufacturersPage.EditManufacture(name, newName, newDes);
    }

    @Test(priority = 3, dataProvider = "data_provider_manufactureDel_excel", dataProviderClass = DataProviderManager.class)
    public void delNew(String search) {
        logFile.info("ManufacturesTest");
        manufacturersPage.login();
        manufacturersPage.DeleteManufacture(search);
    }
}
