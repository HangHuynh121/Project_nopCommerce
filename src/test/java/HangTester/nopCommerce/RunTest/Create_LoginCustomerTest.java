package HangTester.nopCommerce.RunTest;

import HangTester.Helper.CaptureHelper;
import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.Create_LoginCustomerFlow;
import HangTester.nopCommerce.Page.LoginAdminPage;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Create_LoginCustomerTest extends BaseTest {
    public Create_LoginCustomerFlow create_loginCustomerPage;
    public LoginAdminPage loginAdminPage;
    public CaptureHelper captureHelper;

    public Create_LoginCustomerTest(){
        loginAdminPage = new LoginAdminPage();
        create_loginCustomerPage = new Create_LoginCustomerFlow();
        captureHelper = new CaptureHelper();
    }

    @AfterMethod
    public void captureFail(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            captureHelper.captureScreenshot("Create_LoginCustomerTest", "create_LoginCustomerFlow");
        }
    }

    @Test
    public void createAcc(){
        loginAdminPage.Login("admin@yourstore.com","admin");
        loginAdminPage = create_loginCustomerPage.CreateACC("NamNguyen1833@gmail.com","Hello123#","Add a new customer back to customer list",
                "Hang","Huynh","Administrators");
        create_loginCustomerPage.LoginNewACC("NamNguyen1833@gmail.com", "Hello123#");
    }

}
