//
package HangTester.nopCommerce.RunTest;


import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario1Test extends BaseTest {
    public LoginAdminPage loginAdminPage;
    public ManufacturersPage manufacturersPage;
    public CategoriesPage categoriesPage;
    public VendorsPage vendorsPage;
    public ProductPage productPage;

    @BeforeMethod
    public void Scenario1Test(){
        loginAdminPage = new LoginAdminPage();
//        manufacturersPage = new ManufacturersPage();
//        categoriesPage = new CategoriesPage();
//        vendorsPage = new VendorsPage();
//        productPage = new ProductPage();
        loginAdminPage.Login("","");
    }

    //ADD NEW MANUFACTORERS
    @Test (priority = 1)
    public void manufacturers(){
        manufacturersPage = new ManufacturersPage();
        manufacturersPage.AddManufacture("Dell","Laptop");
    }

    //ADD NEW CATEGORY
    @Test (priority = 2)
    public  void category(){
        categoriesPage = new CategoriesPage();
        categoriesPage.CategoryInfo("Furniture","Table",  "Computers");
        categoriesPage.CatgoryDisplay("100", "1000");
        categoriesPage.Mapping("Administrators", "Your store name");
        categoriesPage.SEO("home","normal", "4", "Computers", "Furniture");
    }

    //ADD NEW VENDOR
    @Test (priority = 3)
    public void vendor(){
        vendorsPage = new VendorsPage();
        vendorsPage.VendorInfo("", "Vendor 3","vendor3email@gmail.com");
        vendorsPage.VendorDisplay("100", "1000");
        vendorsPage.VendorSEO("Vendor-3","For security purposes, the feature you have requested is not available on the demo site.");
    }

    //ADD NEW PRODUCT
    @Test (priority = 4)
    public void product(){
        productPage = new ProductPage();
        productPage.ProductInfo("Dell", "Pink", "Computers", "HP");
        productPage.ProductPrice("1000", "Dell","Computers");
    }
}
