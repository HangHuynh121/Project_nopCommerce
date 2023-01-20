package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.CategoriesPage;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    public ProductPage productPage;
    public LoginAdminPage loginAdminPage;

    @BeforeMethod
    public void ProductTest(){
        loginAdminPage = new LoginAdminPage();
        productPage = new ProductPage();
        loginAdminPage.Login("","");
    }

    @Test
    public void addNew() {
        productPage.ProductInfo("Dell", "Pink", "Computers", "HP");
        productPage.ProductPrice("1000", "Dell","Computers");
    }

    @Test
    public void editNew(){
        productPage.editProduct("Dell","Computers","Apple", "light pink");
    }

    @Test
    public void delNew(){
        productPage.delProduct("Apple","Computers");
    }
}
