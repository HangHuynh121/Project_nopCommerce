package HangTester.nopCommerce.RunTest;

import HangTester.Helper.CaptureHelper;
import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.CategoriesPage;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.Helper.DataProviderManager;
import HangTester.Helper.ExcelHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoriesTest extends BaseTest {

    public CategoriesPage categoriesPage;
    public LoginAdminPage loginAdminPage;
    public CaptureHelper captureHelper;

    @BeforeMethod ()
    public void CategoriesTest(){
        loginAdminPage = new LoginAdminPage();
        categoriesPage = new CategoriesPage();
        captureHelper = new CaptureHelper();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Login.xlsx","login");
        loginAdminPage.Login(excelHelper.getCellData("Email",1),excelHelper.getCellData("Password",1));
    }

    @AfterMethod
    public void captureFail(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            captureHelper.captureScreenshot("CategoriesTest", "categoriesPage");
        }

    }

    @Test (priority = 1, dataProvider = "data_provider_categoryAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String des, String parentCat, String PriceF, String PriceT,String CusValue, String StoreValue, String search, String title, String key){
        categoriesPage.CategoryInfo(name,des,parentCat);
        categoriesPage.CatgoryDisplay(PriceF,PriceT);
        categoriesPage.Mapping(CusValue,StoreValue);
        categoriesPage.SEO(search, title, key, parentCat, name);
    }

    @Test (priority = 2, dataProvider = "data_provider_categoryEdit_excel", dataProviderClass = DataProviderManager.class)
    public  void editNew(String name, String newName, String newDes, String parentCat){
        categoriesPage.editCategory(name,newName,newDes,parentCat);

    }

    @Test (priority = 3, dataProvider = "data_provider_categoryDel_excel" , dataProviderClass =  DataProviderManager.class)
    public void  delNew(String search){
        categoriesPage.delCategory(search);
    }
}
