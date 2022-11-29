package HangTester.nopCommerce.RunTest;

import HangTester.nopCommerce.Page.CategoriesPage;
import org.testng.annotations.Test;

public class CategoriesTest {

    public CategoriesPage categoriesPage;
    public LoginAdminTest loginAdminTest;

    public CategoriesTest(){
        loginAdminTest = new LoginAdminTest();
        categoriesPage = new CategoriesPage();
    }

    @Test (priority =  1)
    public void addNew(){
        
    }
}
