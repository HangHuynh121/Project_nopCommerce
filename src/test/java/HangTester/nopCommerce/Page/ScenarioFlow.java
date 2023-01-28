package HangTester.nopCommerce.Page;

import HangTester.utils.helper.WebUI;
import org.openqa.selenium.By;

import javax.swing.*;

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
    public ManufacturersPage login(String mail, String pass){
        loginAdminPage = new LoginAdminPage();
        loginAdminPage.Login(mail, pass);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(ManufactorMenu,CatalogMenu);
        WebUI.clickElement(ManufactorMenu);
        return new ManufacturersPage();
    }

    //ADD NEW MANUFACTORERS
    public CategoriesPage manufacturers(String name, String des, String priceF, String priceT){
        manufacturersPage = new ManufacturersPage();
        manufacturersPage.ManufactorItem(name, des);
        manufacturersPage.ManufactorDisplay(priceF,priceT,name);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(CategoryMenu,CatalogMenu);
        WebUI.clickElement(CategoryMenu);
        return new CategoriesPage();
    }

    //ADD NEW CATEGORY
    public VendorsPage category(String name, String des, String parentCat, String PriceF, String PriceT,String CusValue, String StoreValue, String search, String title, String key){
        categoriesPage = new CategoriesPage();
        categoriesPage.CategoryInfo(name,des,parentCat);
        categoriesPage.CatgoryDisplay(PriceF,PriceT);
        categoriesPage.Mapping(CusValue,StoreValue);
        categoriesPage.SEO(search, title, key, parentCat, name);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(VendorMenu,CustomerMenu);
        WebUI.clickElement(VendorMenu);
        return new VendorsPage();
    }

    //ADD NEW VENDOR
    public ProductPage vendor(String name, String mail, String priceF, String priceT,String nameSEO, String alert){
        vendorsPage = new VendorsPage();
        vendorsPage.VendorInfo( name, mail);
        vendorsPage.VendorDisplay(priceF, priceT);
        vendorsPage.VendorSEO(nameSEO, alert);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(ProductMenu,CatalogMenu);
        WebUI.clickElement(ProductMenu);
        return new ProductPage();
    }

    //ADD NEW PRODUCT
    public void product(String name, String des, String searchCat, String searchManu, String price){
        productPage = new ProductPage();
        productPage.ProductInfo(name, des, searchCat, searchManu);
        productPage.ProductPrice(price, name, searchCat);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
    }

}
