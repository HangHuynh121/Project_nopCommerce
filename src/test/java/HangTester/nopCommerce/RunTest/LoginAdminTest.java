package HangTester.nopCommerce.RunTest;

import HangTester.browsers.DriverManager;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.browsers.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAdminTest extends BaseTest {

    public LoginAdminPage loginAdminPage;


    @BeforeMethod
    public void LoginAdminTest(){

        loginAdminPage = new LoginAdminPage ();
    }

    @Test
    public void LoginValid(){
//        loginAdminPage = new LoginAdminPage(driver);
        loginAdminPage.Login("","");
    }
}
