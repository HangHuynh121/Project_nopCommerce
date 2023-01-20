package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.VendorsPage;
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
        loginAdminPage.Login("","");
    }

    @Test
    public void addNew(){
        vendorsPage.VendorInfo("", "Vendor 3","vendor3email@gmail.com");
        vendorsPage.VendorDisplay("100", "1000");
        vendorsPage.VendorSEO("Vendor-3","For security purposes, the feature you have requested is not available on the demo site.");

    }
}
