package HangTester.nopCommerce.Page;

import org.testng.annotations.BeforeMethod;

public class Scenario1 {
    public LoginAdminPage loginAdminPage;
    public ManufacturersPage manufacturersPage;
    public CategoriesPage categoriesPage;
    public VendorsPage vendorsPage;
    public ProductPage productPage;
    public Scenario1(){}

    //LOGIN
    public void login(){
        loginAdminPage = new LoginAdminPage();
        loginAdminPage.Login("","" );
    }

    //ADD NEW MANUFACTORERS
    public void manufacturers(){
        manufacturersPage = new ManufacturersPage();
        manufacturersPage.AddManufacture("Dell","Laptop");
    }

    //ADD NEW CATEGORY
    public  void category(){
        categoriesPage = new CategoriesPage();
        categoriesPage.CategoryInfo("Furniture","Table",  "Computers");
        categoriesPage.CatgoryDisplay("100", "1000");
        categoriesPage.Mapping("Administrators", "Your store name");
        categoriesPage.SEO("home","normal", "4", "Computers", "Furniture");
    }

    //ADD NEW VENDOR
    public void vendor(){
        vendorsPage = new VendorsPage();
        vendorsPage.VendorInfo("", "Vendor 3","vendor3email@gmail.com");
        vendorsPage.VendorDisplay("100", "1000");
        vendorsPage.VendorSEO("Vendor-3","For security purposes, the feature you have requested is not available on the demo site.");
    }

    //ADD NEW PRODUCT
    public void product(){
        productPage = new ProductPage();
        productPage.ProductInfo("Dell", "Pink", "Computers", "HP");
        productPage.ProductPrice("1000", "Dell","Computers");
    }

}
