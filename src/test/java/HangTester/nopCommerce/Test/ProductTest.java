package HangTester.nopCommerce.Test;

import HangTester.Helper.CaptureHelper;
import HangTester.nopCommerce.common.BaseTest;
import HangTester.nopCommerce.Listenner.TestListenner;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.ProductPage;
import HangTester.Helper.DataProviderManager;
import HangTester.Helper.ExcelHelper;
import HangTester.utils.logFile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    public ProductPage productPage;
    public LoginAdminPage loginAdminPage;
    public CaptureHelper captureHelper;
    @BeforeMethod
    public void ProductTest(){
        loginAdminPage = new LoginAdminPage();
        productPage = new ProductPage();
        captureHelper = new CaptureHelper();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Login.xlsx","loginPass");
        loginAdminPage.Login(excelHelper.getCellData("Email",1),excelHelper.getCellData("Password",1));
    }

    @AfterMethod
    public void  captureFail(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            captureHelper.captureScreenshot("ProductTest", "productPage");
        }
    }

    @Test (dataProvider = "data_provider_productAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String des, String searchCat, String searchManu, String price) {
        logFile.info("ProductTest");
        productPage.ProductInfo(name, des, searchCat, searchManu);
        productPage.ProductPrice(price, name, searchCat);
    }

    @Test (dataProvider = "data_provider_productEdit_excel", dataProviderClass = DataProviderManager.class)
    public void editNew(String name, String searchCate, String nameEdit, String desEdit){
        logFile.info("ProductTest");
        productPage.editProduct(name,searchCate,nameEdit, desEdit);
    }

    @Test (dataProvider = "data_provider_productDel_excel", dataProviderClass = DataProviderManager.class)
    public void delNew(String nameEdit, String searchCate){
        logFile.info("ProductTest");
        productPage.delProduct(nameEdit,searchCate);
    }
}
