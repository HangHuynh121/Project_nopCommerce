package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.Create_LoginCustomerPage;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.VendorsPage;
import org.testng.annotations.Test;

public class Create_LoginCustomerTest extends BaseTest {
    public Create_LoginCustomerPage create_loginCustomerPage;
    public LoginAdminPage loginAdminPage;

    public Create_LoginCustomerTest(){
        loginAdminPage = new LoginAdminPage();
        create_loginCustomerPage = new Create_LoginCustomerPage();

    }

    @Test
    public void createAcc(){
        loginAdminPage.Login("admin@yourstore.com","admin");
        loginAdminPage = create_loginCustomerPage.CreateACC("NamNguyen1833@gmail.com","Hello123#","Add a new customer back to customer list",
                "Hang","Huynh","Administrators");
        create_loginCustomerPage.LoginNewACC("NamNguyen1833@gmail.com", "Hello123#");
    }

}
