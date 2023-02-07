package HangTester.nopCommerce.RunTest;

import HangTester.Helper.CaptureHelper;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.browsers.BaseTest;
import HangTester.Helper.DataProviderManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAdminTest extends BaseTest {

    public LoginAdminPage loginAdminPage;
    public CaptureHelper captureHelper;


    @BeforeMethod
    public void LoginAdminTest(){
        loginAdminPage = new LoginAdminPage ();
        captureHelper = new CaptureHelper();
    }

    @AfterMethod
    public void captureFail(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            captureHelper.captureScreenshot("LoginAdminTest", "adminPage");
        }
    }

    @Test (dataProvider = "data_provider_loginAdmin_excel", dataProviderClass = DataProviderManager.class)
    public void LoginValid(String email, String pass){
        loginAdminPage.Login(email, pass);
    }
}
