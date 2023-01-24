package HangTester.nopCommerce.Page;

import HangTester.utils.helper.WebUI;
import org.openqa.selenium.By;

public class ScenarioFlow {
    public LoginAdminPage loginAdminPage;
    public ManufacturersPage manufacturersPage;
    public CategoriesPage categoriesPage;
    public VendorsPage vendorsPage;
    public ProductPage productPage;
    public ScenarioFlow(){}

    //LOGIN
    private By CatalogMenu = By.xpath("//p[normalize-space()='Catalog']");
    private By ManufactorMenu = By.xpath("//p[normalize-space()='Manufacturers']");

    private By CategoryMenu = By.xpath("//p[normalize-space()='Categories']");
    private By CustomerMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    private By VendorMenu = By.xpath("//p[normalize-space()='Vendors']");
    private By ProductMenu = By.xpath("//p[normalize-space()='Products']");
    public ManufacturersPage login(){
        loginAdminPage = new LoginAdminPage();
        loginAdminPage.Login("","" );
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(ManufactorMenu,CatalogMenu);
        WebUI.clickElement(ManufactorMenu);
        return new ManufacturersPage();
    }

    //ADD NEW MANUFACTORERS
    public CategoriesPage manufacturers(){
        manufacturersPage = new ManufacturersPage();
        manufacturersPage.ManufactorItem("Dell", "pink");
        manufacturersPage.ManufactorDisplay("100","1000","Dell");
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(CategoryMenu,CatalogMenu);
        WebUI.clickElement(CategoryMenu);

        return new CategoriesPage();
    }

    //ADD NEW CATEGORY
    public VendorsPage category(){
        categoriesPage = new CategoriesPage();
        categoriesPage.CategoryInfo("Furniture","Table",  "Computers");
        categoriesPage.CatgoryDisplay("100", "1000");
        categoriesPage.Mapping("Administrators", "Your store name");
        categoriesPage.SEO("home","normal", "4", "Computers", "Furniture");
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(VendorMenu,CustomerMenu);
        WebUI.clickElement(VendorMenu);
        return new VendorsPage();
    }

    //ADD NEW VENDOR
    public ProductPage vendor(){
        vendorsPage = new VendorsPage();
        vendorsPage.VendorInfo("", "Vendor 3","vendor3email@gmail.com");
        vendorsPage.VendorDisplay("100", "1000");
        vendorsPage.VendorSEO("Vendor-3","×\nFor security purposes, the feature you have requested is not available on the demo site.");
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(ProductMenu,CatalogMenu);
        WebUI.clickElement(ProductMenu);
        return new ProductPage();
    }

    //ADD NEW PRODUCT
    public void product(){
        productPage = new ProductPage();
        productPage.ProductInfo("Dell", "Pink", "Computers", "Dell");
        productPage.ProductPrice("1000", "Dell","Computers");
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
    }

}
