package HangTester.nopCommerce.RunTest;

import HangTester.browsers.DriverManager;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.browsers.BaseTest;
import HangTester.utils.helper.DataProviderManager;
import HangTester.utils.helper.ExcelHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginAdminTest extends BaseTest {

    public LoginAdminPage loginAdminPage;


    @BeforeMethod
    public void LoginAdminTest(){
        loginAdminPage = new LoginAdminPage ();
    }

    @Test (dataProvider = "data_provider_loginAdmin_excel", dataProviderClass = DataProviderManager.class)
    public void LoginValid(String email, String pass){
        loginAdminPage.Login(email, pass);
    }
}
