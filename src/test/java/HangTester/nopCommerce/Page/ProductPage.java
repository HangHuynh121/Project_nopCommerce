package HangTester.nopCommerce.Page;

import HangTester.utils.helper.WebUI;
import org.openqa.selenium.By;

public class ProductPage {

//    private WebDriver driver;

    public ProductPage() {
//        this.driver = driver;
//        new WebUI(driver);
    }

    //ADD NEW

    //Category info
    private By SearchItem = By.xpath("//div[@data-hideattribute='ProductListPage.HideSearchBlock']");
    private String SearchHide = "opened";
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By swith = By.xpath("//div[@class='onoffswitch']");
    private String swithHide = "none;";
    private By ProductItem = By.xpath("//div[@id='product-info']");
    private String ProductHide = "card-outline";
    private By nameAddProduct = By.xpath("//h1[contains(.,'Add a new product')]");
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By description = By.xpath("//textarea[@id='ShortDescription']");
    private By ProductCombobox = By.xpath("//div[@class='form-group row']//input[@role='listbox']");
    private By SelectCate = By.xpath("//ul[@id='SelectedCategoryIds_listbox']//li[1]");
    private By Manufactor = By.xpath("//body/div[@class='wrapper']/div[@class='content-wrapper']/form[@id='product-form']/section[@class='content']/div[@class='container-fluid']/div[@class='form-horizontal']/nop-cards[@id='product-cards']/nop-card/div[@id='product-info']/div[@class='card-body']/div[@class='form-group row advanced-setting']/div[@class='col-md-9']/div[@class='k-widget k-multiselect k-multiselect-clearable']/div[@role='listbox']/input[1]");
    private By SelectMManu = By.xpath("//ul[@id='SelectedManufacturerIds_listbox']//li[1]");


    public void ProductInfo(String Name, String des, String searchCate, String searchManu) {
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Product/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddProduct, "Add a new product back to product list");
        WebUI.moveToElemet(ProductItem);
        WebUI.OpenHideItem(ProductItem, "class", ProductHide);
        WebUI.sendText(nameAdd, Name);
        WebUI.sendText(description, des);

//        WebUI.clickElement(CategoryCombobox);
        WebUI.sendText(ProductCombobox, searchCate);
        WebUI.clickJS(SelectCate);
        boolean x = WebUI.visibleElement(Manufactor);
        String y = new Boolean(x).toString();
        System.out.println(y);
        if (y.equals("true")) {
            WebUI.clickElement(swith);
            WebUI.sleep(1);
        }
        WebUI.sendText(Manufactor, searchManu);
        WebUI.clickJS(SelectMManu);

    }

    //Price
    private By priceItem = By.xpath("//div[@id='product-price']");
    private String priceHide = "card-outline";
    private By Price = By.xpath("//div[@id='product-price-area']/div[2]//span//span//input[1]");
    private By inputPrice = By.xpath("//div[@id='product-price-area']/div[2]//span//span//input[2]");

    private By saveButton = By.xpath("//button[@name='save']");
    private By searchPro = By.xpath("//input[@id='SearchProductName']");
    private String searchCateID = "SearchCategoryId";
    private By searchButton = By.xpath("//button[@id='search-products']");
    private By newProduct = By.xpath("//tbody//tr//td[3]");

    public void ProductPrice(String price, String search, String search1) {
        WebUI.moveToElemet(priceItem);
        WebUI.OpenHideItem(priceItem, "class", priceHide);
        WebUI.clickElement(Price);
        WebUI.clearText(Price);
        WebUI.sendText(inputPrice, price);
        WebUI.moveToElemet(saveButton);
        WebUI.clickElement(saveButton);
        WebUI.sleep(1);
        WebUI.OpenHideItem(SearchItem, "class", SearchHide);
        WebUI.sendText(searchPro, search);
        WebUI.selectDopdown(searchCateID, search1);
        WebUI.clickElement(searchButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(newProduct);
        WebUI.VerifyTextSoft(newProduct, search);
    }

    //EDIT NEW
    private By EditButton = By.xpath("//tbody//tr[1]//td[8]//a");
    private By nameEditPro = By.xpath("//form[@id='product-form']/div[1]/h1");
    private By nameEdit = By.xpath("//input[@id='Name']");
    private By shortDesEdit = By.xpath("//textarea[@id='ShortDescription']");
    private By saveEditButton = By.xpath("//button[@name='save']");

    public  void editProduct(String Name, String searchCate, String NameEdit, String desEdit){

        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Product/List");
        WebUI.OpenHideItem(SearchItem,"class", SearchHide );
        WebUI.sendText(searchPro,Name);
        WebUI.selectDopdown(searchCateID, searchCate);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(EditButton);
        WebUI.clickElement(EditButton);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameEditPro,"Edit product details - " + Name +" back to product list");
        WebUI.clickElement(nameEdit);
        WebUI.clearText(nameEdit);
        WebUI.sendText(nameEdit,NameEdit);
        WebUI.clickElement(shortDesEdit);
        WebUI.clearText(shortDesEdit);
        WebUI.sendText(shortDesEdit, desEdit);
        WebUI.moveToElemet(saveEditButton);
        WebUI.clickElement(saveEditButton);
        WebUI.sleep(1);
        WebUI.sendText(searchPro,NameEdit);
        WebUI.selectDopdown(searchCateID, searchCate);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(newProduct);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(newProduct, NameEdit);
    }

    //DELETE NEW

    private By Delete = By.xpath("//button[@id='delete-selected']");
    private By Checkbox = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[1]/input");
    private By YesButton = By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");

    public void delProduct(String NameEdit, String searchCate ){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Product/List");
        WebUI.OpenHideItem(SearchItem,"class", SearchHide );
        WebUI.sendText(searchPro, NameEdit);
        WebUI.selectDopdown(searchCateID, searchCate);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(newProduct); //DeleteProduct vừa add
        WebUI.clickElement(Checkbox);
        WebUI.sleep(1);
        WebUI.moveToElemet(Delete);
        WebUI.sleep(1);
        WebUI.clickElement(Delete);
        WebUI.clickElement(YesButton);
    }

}



