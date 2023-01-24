package HangTester.nopCommerce.RunTest;

import HangTester.browsers.DriverManager;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.ManufacturersPage;
import HangTester.browsers.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManufacturersTest extends BaseTest {

    public ManufacturersPage manufacturersPage;
    public LoginAdminPage loginAdminPage;


    @BeforeMethod
    public void ManufacturesTest(){
        loginAdminPage = new LoginAdminPage();
        manufacturersPage = new ManufacturersPage();
        loginAdminPage.Login("","");
    }

    @Test (priority = 1)
    public void addNew(){
        manufacturersPage.ManufactorItem("Dell", "pink");
        manufacturersPage.ManufactorDisplay("100","1000","Dell");

    }

    @Test(priority = 2)
    public void EditNew(){
        manufacturersPage.EditManufacture("Dell","HP","Light pink");
    }

    @Test (priority = 3)
    public void DelNew(){
        manufacturersPage.DeleteManufacture("HP");
    }
}
