package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.CategoriesPage;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.utils.helper.DataProviderManager;
import HangTester.utils.helper.ExcelHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoriesTest extends BaseTest {

    public CategoriesPage categoriesPage;
    public LoginAdminPage loginAdminPage;

    @BeforeMethod ()
    public void CategoriesTest(){
        loginAdminPage = new LoginAdminPage();
        categoriesPage = new CategoriesPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/java/HangTester/nopCommerce/DataTest/Login.xlsx","login");
        loginAdminPage.Login(excelHelper.getCellData("Email",1),excelHelper.getCellData("Password",1));
    }

    @Test (priority = 1, dataProvider = "data_provider_category_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String des, String parentCat, String PriceF, String PriceT,String CusValue, String StoreValue, String search, String title, String key){
        categoriesPage.CategoryInfo(name,des,parentCat);
        categoriesPage.CatgoryDisplay(PriceF,PriceT);
        categoriesPage.Mapping(CusValue,StoreValue);
        categoriesPage.SEO(search, title, key, parentCat, name);
    }

    @Test (priority = 2)
    public  void editNew(){
        categoriesPage.editCategory("Furniture","School","Chair","Computers");

    }

    @Test (priority = 3)
    public void  delNew(){
        categoriesPage.delCategory("School");
    }
}
