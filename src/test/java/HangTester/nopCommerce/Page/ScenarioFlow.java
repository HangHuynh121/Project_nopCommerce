package HangTester.nopCommerce.Page;

import HangTester.Helper.ExcelHelper;
import HangTester.utils.WebUI;
import org.openqa.selenium.By;

public class ScenarioFlow {
    public LoginAdminPage loginAdminPage;
    public ManufacturersPage manufacturersPage;
    public CategoriesPage categoriesPage;
    public VendorsPage vendorsPage;
    public ProductPage productPage;

    public ScenarioFlow() {
    }

    //LOGIN
    private By CatalogMenu = By.xpath("//p[normalize-space()='Catalog']");
    private By ManufactorMenu = By.xpath("//p[normalize-space()='Manufacturers']");
    private By CategoryMenu = By.xpath("//p[normalize-space()='Categories']");
    private By CustomerMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    private By VendorMenu = By.xpath("//p[normalize-space()='Vendors']");
    private By ProductMenu = By.xpath("//p[normalize-space()='Products']");

    public ManufacturersPage login() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Login.xlsx", "loginPass");
        loginAdminPage = new LoginAdminPage();
        loginAdminPage.LoginPass(excelHelper.getCellData("Email", 1), excelHelper.getCellData("Password", 1));
        WebUI.OpenHideItem(ManufactorMenu, CatalogMenu);
        WebUI.clickElement(ManufactorMenu);
        return new ManufacturersPage();
    }

    //ADD NEW MANUFACTURERS
    public CategoriesPage manufacturers() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Manufactures.xlsx", "Add");
        manufacturersPage = new ManufacturersPage();
        manufacturersPage.ManufactorItem(excelHelper.getCellData("Name", 1), excelHelper.getCellData("Description", 1));
        manufacturersPage.ManufactorDisplay(excelHelper.getCellData("Price From", 1), excelHelper.getCellData("Price To", 1),
                excelHelper.getCellData("Name", 1));

        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(CategoryMenu, CatalogMenu);
        WebUI.clickElement(CategoryMenu);
        return new CategoriesPage();
    }

    //ADD NEW CATEGORY
    public VendorsPage category() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Category.xlsx", "Add");
        categoriesPage = new CategoriesPage();
        categoriesPage.CategoryInfo(excelHelper.getCellData("Name", 1), excelHelper.getCellData("Description", 1),
                excelHelper.getCellData("Parent category", 1));

        categoriesPage.CatgoryDisplay(excelHelper.getCellData("Price From", 1), excelHelper.getCellData("Price To", 1));
        categoriesPage.Mapping(excelHelper.getCellData("Customer Value", 1), excelHelper.getCellData("Store Value", 1));
        categoriesPage.SEO(excelHelper.getCellData("Search Product", 1), excelHelper.getCellData("Title", 1), excelHelper.getCellData("Key", 1),
                excelHelper.getCellData("Parent category", 1), excelHelper.getCellData("Name", 1));

        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(VendorMenu, CustomerMenu);
        WebUI.clickElement(VendorMenu);
        return new VendorsPage();
    }

    //ADD NEW VENDOR
    public ProductPage vendor() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Vendor.xlsx", "Add");
        vendorsPage = new VendorsPage();
        vendorsPage.VendorInfo(excelHelper.getCellData("Name", 1), excelHelper.getCellData("Mail", 1));
        vendorsPage.VendorDisplay(excelHelper.getCellData("Price From", 1), excelHelper.getCellData("Price To", 1));
        vendorsPage.VendorSEO(excelHelper.getCellData("Name SEO", 1), excelHelper.getCellData("Alert", 1));
        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
        WebUI.OpenHideItem(ProductMenu, CatalogMenu);
        WebUI.clickElement(ProductMenu);
        return new ProductPage();
    }

    //ADD NEW PRODUCT
    public void product() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Product.xlsx", "Add");
        productPage = new ProductPage();
        productPage.ProductInfo(excelHelper.getCellData("Name", 1), excelHelper.getCellData("Description", 1),
                excelHelper.getCellData("Search Category", 1), excelHelper.getCellData("Search Manufcture", 1));

        productPage.ProductPrice(excelHelper.getCellData("Price", 1), excelHelper.getCellData("Name", 1), excelHelper.getCellData("Search Category", 1));
        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
    }

}
