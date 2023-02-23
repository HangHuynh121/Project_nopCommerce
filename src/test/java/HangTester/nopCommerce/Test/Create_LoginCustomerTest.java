package HangTester.nopCommerce.Test;

import HangTester.Helper.CaptureHelper;
import HangTester.Helper.DataProviderManager;
import HangTester.nopCommerce.common.BaseTest;
import HangTester.nopCommerce.Page.Create_LoginCustomerFlow;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.utils.logFile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class Create_LoginCustomerTest extends BaseTest {
    public Create_LoginCustomerFlow create_loginCustomerPage;
    public LoginAdminPage loginAdminPage;
    public CaptureHelper captureHelper;

    public Create_LoginCustomerTest() {
        loginAdminPage = new LoginAdminPage();
        create_loginCustomerPage = new Create_LoginCustomerFlow();
        captureHelper = new CaptureHelper();
    }

    @AfterMethod
    public void captureFail(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureHelper.captureScreenshot("Create_LoginCustomerTest", "create_LoginCustomerFlow");
        }
    }

    @Test(dataProvider = "data_provider_createCus_excel", dataProviderClass = DataProviderManager.class)
    public void createAcc(String mail, String pass, String emailCus, String passCus, String pagename, String Fname, String Lname, String role) {
        logFile.info("Create_LoginCustomerTest");
        loginAdminPage.LoginPass(mail, pass);
        loginAdminPage = create_loginCustomerPage.CreateACC(emailCus, passCus, pagename, Fname, Lname, role);
        create_loginCustomerPage.LoginNewACC(emailCus, passCus);
    }

}
