package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.CategoriesPage;
import HangTester.nopCommerce.Page.LoginAdminPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoriesTest extends BaseTest {

    public CategoriesPage categoriesPage;
    public LoginAdminPage loginAdminPage;

    @BeforeMethod
    public void CategoriesTest(){
        loginAdminPage = new LoginAdminPage();
        categoriesPage = new CategoriesPage();
        loginAdminPage.Login("","");
    }

    @Test (priority =  1)
    public void addNew(){
        categoriesPage.CategoryInfo("Furniture","Table",  "Computers");
        categoriesPage.CatgoryDisplay("100", "1000");
        categoriesPage.Mapping("Administrators", "Your store name");
    }

    @Test (priority = 2)
    public  void editNew(){
        categoriesPage.editCategory("School","Chair");

    }

    @Test (priority = 3)
    public void  delNew(){
        categoriesPage.delCategory();
    }
}
