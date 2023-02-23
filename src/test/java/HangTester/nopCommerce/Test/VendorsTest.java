package HangTester.nopCommerce.Test;

import HangTester.Helper.CaptureHelper;
import HangTester.nopCommerce.common.BaseTest;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.VendorsPage;
import HangTester.Helper.DataProviderManager;
import HangTester.Helper.ExcelHelper;
import HangTester.utils.logFile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VendorsTest extends BaseTest {
    public VendorsPage vendorsPage;
    public CaptureHelper captureHelper;

    @BeforeMethod
    public void VendorsTest() {
        vendorsPage = new VendorsPage();
        captureHelper = new CaptureHelper();

    }

    @AfterMethod
    public void captureFail(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureHelper.captureScreenshot("VendorsTest", "vendorPage");
        }
    }

    @Test(dataProvider = "data_provider_vendorAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String mail, String priceF, String priceT, String nameSEO, String alert) {
        logFile.info("VendorsTest");
        vendorsPage.login();
        vendorsPage.VendorInfo(name, mail);
        vendorsPage.VendorDisplay(priceF, priceT);
        vendorsPage.VendorSEO(nameSEO, alert);

    }
}
