package HangTester.nopCommerce.Test;

import HangTester.Helper.CaptureHelper;
import HangTester.nopCommerce.common.BaseTest;
import HangTester.nopCommerce.Listenner.TestListenner;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.VendorsPage;
import HangTester.Helper.DataProviderManager;
import HangTester.Helper.ExcelHelper;
import HangTester.utils.logFile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class VendorsTest extends BaseTest {
    public VendorsPage vendorsPage;
    public LoginAdminPage loginAdminPage;
    public CaptureHelper captureHelper;

    @BeforeMethod
    public void VendorsTest(){
        loginAdminPage = new LoginAdminPage();
        vendorsPage = new VendorsPage();
        captureHelper = new CaptureHelper();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Login.xlsx","loginPass");
        loginAdminPage.Login(excelHelper.getCellData("Email",1),excelHelper.getCellData("Password",1));
    }

    @AfterMethod
    public void  captureFail(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            captureHelper.captureScreenshot("VendorsTest", "vendorPage");
        }
    }

    @Test (dataProvider = "data_provider_vendorAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String mail, String priceF, String priceT,String nameSEO, String alert){
        logFile.info("VendorsTest");
        vendorsPage.VendorInfo( name, mail);
        vendorsPage.VendorDisplay(priceF, priceT);
        vendorsPage.VendorSEO(nameSEO, alert);

    }
}
