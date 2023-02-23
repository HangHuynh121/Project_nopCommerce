package HangTester.nopCommerce.Test;

import HangTester.Helper.CaptureHelper;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.common.BaseTest;
import HangTester.Helper.DataProviderManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAdminTest extends BaseTest {

    public LoginAdminPage loginAdminPage;
    public CaptureHelper captureHelper;
    Logger log = LogManager.getLogger(LoginAdminPage.class);


    @BeforeMethod
    public void LoginAdminTest() {
        loginAdminPage = new LoginAdminPage();
        captureHelper = new CaptureHelper();
    }

    @AfterMethod
    public void captureFail(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureHelper.captureScreenshot("LoginAdminTest", "adminPage");
        }
    }

    @Test(dataProvider = "data_provider_loginAdminPass_excel", dataProviderClass = DataProviderManager.class)
    public void LoginValid(String email, String pass) {
        log.info("LoginValid: " + email + " - " + pass);
        loginAdminPage.LoginPass(email, pass);
    }

    @Test(dataProvider = "data_provider_loginAdminFailPW_excel", dataProviderClass = DataProviderManager.class)
    public void LoginInvalidPW(String email, String pass, String ErrorMsg) {
        log.info("LoginInvalidPW: " + email + " - " + pass);
        loginAdminPage.LoginFail(email, pass, ErrorMsg);
    }
}
