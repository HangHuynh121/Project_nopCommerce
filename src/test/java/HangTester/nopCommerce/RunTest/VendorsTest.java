package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.VendorsPage;
import HangTester.utils.helper.DataProviderManager;
import HangTester.utils.helper.ExcelHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VendorsTest extends BaseTest {
    public VendorsPage vendorsPage;
    public LoginAdminPage loginAdminPage;

    @BeforeMethod
    public void VendorsTest(){
        loginAdminPage = new LoginAdminPage();
        vendorsPage = new VendorsPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/java/HangTester/nopCommerce/DataTest/Login.xlsx","login");
        loginAdminPage.Login(excelHelper.getCellData("Email",1),excelHelper.getCellData("Password",1));
    }

    @Test (dataProvider = "data_provider_vendorAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String mail, String priceF, String priceT,String nameSEO, String alert){
        vendorsPage.VendorInfo( name, mail);
        vendorsPage.VendorDisplay(priceF, priceT);
        vendorsPage.VendorSEO(nameSEO, alert);

    }
}
