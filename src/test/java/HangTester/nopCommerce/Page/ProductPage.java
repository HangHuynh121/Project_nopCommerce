package HangTester.nopCommerce.Page;

import HangTester.Helper.ExcelHelper;
import HangTester.utils.WebUI;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ProductPage {

    public LoginAdminPage loginAdminPage;

    public ProductPage() {
        loginAdminPage = new LoginAdminPage();
    }

    public void login() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Login.xlsx", "loginPass");
        loginAdminPage.LoginPass(excelHelper.getCellData("Email", 1), excelHelper.getCellData("Password", 1));
    }

    //ADD NEW

    //Category info
    private By swich = By.xpath("//div[@class='onoffswitch']");
    private By SearchItem = By.xpath("//div[@data-hideattribute='ProductListPage.HideSearchBlock']");
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By swith = By.xpath("//div[@class='onoffswitch']");
    private String swithHide = "none;";
    private By ProductItem = By.xpath("//div[@id='product-info']");
    private String ProductHide = "card-outline";
    private By nameAddProduct = By.xpath("//h1[contains(.,'Add a new product')]");
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By description = By.xpath("//textarea[@id='ShortDescription']");
    private By CateCombobox = By.xpath("//div[@class='form-group row']//input[@role='listbox']");
    private By SelectCate = By.xpath("//ul[@id='SelectedCategoryIds_listbox']//li[1]");
    private By Manufactor = By.xpath("//ul[@id = 'SelectedManufacturerIds_taglist']//following-sibling::input[1]");
    private By SelectManu = By.xpath("//ul[@id='SelectedManufacturerIds_listbox']//li[1]");


    public void ProductInfo(String Name, String des, String searchCate, String searchManu) {
        WebUI.LogConsole("PRODUCT INFOR");
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Product/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddProduct, "Add a new product back to product list");
        WebUI.moveToElemet(ProductItem);
        WebUI.OpenHideItem(nameAdd, ProductItem);
        WebUI.sendText(nameAdd, Name);
        WebUI.sendText(description, des);
        WebUI.sendText(CateCombobox, searchCate);
        WebUI.clickJS(SelectCate);
        WebUI.OpenHideItem(Manufactor, swich);
        WebUI.moveToElemet(Manufactor);
        WebUI.sendText(Manufactor, searchManu);
        WebUI.clickJS(SelectManu);

    }

    //Price
    private By priceItem = By.xpath("//div[@id='product-price']");
    private By Price = By.xpath("//div[@id='product-price-area']/div[2]//span//span//input[1]");
    private By inputPrice = By.xpath("//div[@id='product-price-area']/div[2]//span//span//input[2]");

    private By saveButton = By.xpath("//button[@name='save']");
    private By searchPro = By.xpath("//input[@id='SearchProductName']");
    private String searchCateID = "SearchCategoryId";
    private By searchButton = By.xpath("//button[@id='search-products']");
    private By newProduct = By.xpath("//tbody//tr[1]//td[3]");

    public void ProductPrice(String price, String search, String search1) {
        SoftAssert sa = new SoftAssert();
        WebUI.LogConsole("PRODUCT PRICE");
        WebUI.moveToElemet(priceItem);
        WebUI.OpenHideItem(Price, priceItem);
        WebUI.clickElement(inputPrice);
        WebUI.clearText(inputPrice);
        WebUI.sendText(inputPrice, price);
        WebUI.sleep(1);
        WebUI.moveToElemet(saveButton);
        WebUI.clickElement(saveButton);
        WebUI.sleep(1);
        WebUI.LogConsole("SEARCH NEW PRODUCT");
        WebUI.OpenHideItem(searchPro, SearchItem);
        WebUI.sendText(searchPro, search);
        WebUI.selectDopdown(searchCateID, search1);
        WebUI.clickElement(searchButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(newProduct);
        WebUI.VerifyTextSoft(newProduct, search);
        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
        sa.assertAll();
    }

    //EDIT NEW
    private By EditButton = By.xpath("//tbody//tr[1]//td[8]//a");
    private By nameEditPro = By.xpath("//form[@id='product-form']/div[1]/h1");
    private By nameEdit = By.xpath("//input[@id='Name']");
    private By shortDesEdit = By.xpath("//textarea[@id='ShortDescription']");
    private By saveEditButton = By.xpath("//button[@name='save']");

    public void editProduct(String Name, String searchCate, String NameEdit, String desEdit) {
        SoftAssert sa = new SoftAssert();
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Product/List");
        WebUI.LogConsole("SEARCH PRODUCT");
        WebUI.OpenHideItem(searchPro, SearchItem);
        WebUI.sendText(searchPro, Name);
        WebUI.selectDopdown(searchCateID, searchCate);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(EditButton);
        WebUI.sleep(1);
        WebUI.clickElement(EditButton);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameEditPro, "Edit product details - " + Name + " back to product list");
        WebUI.clickElement(nameEdit);
        WebUI.clearText(nameEdit);
        WebUI.sendText(nameEdit, NameEdit);
        WebUI.clickElement(shortDesEdit);
        WebUI.clearText(shortDesEdit);
        WebUI.sendText(shortDesEdit, desEdit);
        WebUI.moveToElemet(saveEditButton);
        WebUI.clickElement(saveEditButton);
        WebUI.sleep(1);
        WebUI.LogConsole(" SEARCH EDIT PRODUCT");
        WebUI.sendText(searchPro, NameEdit);
        WebUI.selectDopdown(searchCateID, searchCate);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(newProduct);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(newProduct, NameEdit);
        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
        sa.assertAll();
    }

    //DELETE NEW

    private By Delete = By.xpath("//button[@id='delete-selected']");
    private By Checkbox = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[1]/input");
    private By YesButton = By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");

    public void delProduct(String NameEdit, String searchCate) {
        WebUI.LogConsole("DELETE NEW PRODUCT");
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Product/List");
        WebUI.OpenHideItem(searchPro, SearchItem);
        WebUI.sendText(searchPro, NameEdit);
        WebUI.selectDopdown(searchCateID, searchCate);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(newProduct); //DeleteProduct vừa add
        WebUI.sleep(1);
        WebUI.clickElement(Checkbox);
        WebUI.sleep(1);
        WebUI.moveToElemet(Delete);
        WebUI.sleep(1);
        WebUI.clickElement(Delete);
        WebUI.clickElement(YesButton);
    }

}



