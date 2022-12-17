package HangTester.nopCommerce.Page;

import org.openqa.selenium.By;
import HangTester.utils.helper.WebUI;

import javax.swing.*;
import java.util.Map;

public class CategoriesPage {

//    private WebDriver driver;

    public CategoriesPage(){
//        this.driver = driver;
//        new WebUI(driver);
    }

    //ADD NEW

        //Category info
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By CategoryItem = By.xpath("//div[@id='category-info']");
    private String CategoryHide  = "card card-secondary card-outline collapsed-card";
    private By nameAddPage = By.xpath("//h1[contains(.,'Add a new category')]");
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By description = By.xpath("//iframe[@id='Description_ifr']");
    private By parentCategory = By.xpath("//select[@id='ParentCategoryId']");
    private String parentCatID = "ParentCategoryId";
    public void CategoryInfo(String Name, String des, String valueparentCat) {
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddPage, "Add a new category back to category list");
        WebUI.moveToElemet(CategoryItem);
        WebUI.OpenHideItem("category-info", "class", CategoryHide, CategoryItem);
        WebUI.sendText(nameAdd, Name);
        WebUI.sendText(description, des);
        WebUI.clickElement(parentCategory);
        WebUI.selectDopdown(parentCatID,valueparentCat );

    }

        //Display
    private By DisplayItem = By.xpath("//div[@id='category-display']");
    private String DisplayHide  = "card card-secondary card-outline collapsed-card";
    private String PublicCheckbox = "Published";
    private String ShowHomeCheckbox = "ShowOnHomepage";
    private By PriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[2]");
    private By PriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[2]");
    private By saveAddButton = By.xpath("//button[@name='save']");
    private By nameNewCategory = By.xpath("//table[@id='categories-grid']/tbody/tr[1]/td[2]");

    public void CatgoryDisplay(String PriceF, String PriceT){
        WebUI.moveToElemet(DisplayItem);
        WebUI.OpenHideItem("category-display","class", DisplayHide, DisplayItem);
        WebUI.checkCheckbox(PublicCheckbox);
        WebUI.checkCheckbox(ShowHomeCheckbox);
        WebUI.moveToElemet(PriceFrom);
        WebUI.clickElement(PriceFrom);
        WebUI.clearText(PriceFrom);
        WebUI.sendText(InputPriceFrom,PriceF);
        WebUI.clickElement(PriceTo);
        WebUI.clearText(PriceTo);
        WebUI.sendText(InputPriceTo, PriceT);

    }

            //Mappings
    private By MapItem = By.xpath("//div[@id='category-mappings']");
    private String MapHide = "card card-secondary card-outline advanced-setting collapsed-card";
    private By LimitCus = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]");
    private By inputLimitCus = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]/input");
    private By LimitStore = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[3]//div[2]//div[1]//div[1]//div[1]//div[1]");
    private By inputLimiteStore = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[3]//div[2]//div[1]//div[1]//div[1]//div[1]/input");
    public void Mapping(String CusValue, String StoreValue){
        WebUI.moveToElemet(MapItem);
        WebUI.OpenHideItem("category-mappings","class",MapHide, MapItem);
        WebUI.clickElement(LimitCus);
        WebUI.sendText(inputLimitCus,CusValue);
        WebUI.ENTER(LimitCus);
        WebUI.clickElement(LimitStore);
        WebUI.sendText(inputLimiteStore,StoreValue);
        WebUI.ENTER(LimitCus);

    }

        //SEO


            //Products
//    private By saveAddButton = By.xpath("//button[@name='save']");

//        WebUI.clickElement(saveAddButton);
//        WebUI.sleep(1);
//        WebUI.moveToElemet(nameNewCategory);
//        WebUI.sleep(1);
//        WebUI.VerifyTextSoft(nameNewCategory, Name);


    //EDIT NEW
    private By EditButton = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[5]/a");
    private By nameEditPage = By.xpath("");
    private By nameEdit = By.xpath("//input[@id='Name']");
    private By nameDesEdit = By.xpath("//iframe[@id='Description_ifr']");
    private By saveEditButton = By.xpath("//button[@name='save']");

    public  void editCategory(String NameEdit, String desEdit){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.moveToElemet(nameNewCategory); //Edit Manufacture vừa add
        WebUI.clickElement(EditButton);
        WebUI.VerifyTextSoft(nameEditPage,"Edit category details - Computers back to category list");
        WebUI.clearText(nameEdit);
        WebUI.sendText(nameEdit,NameEdit);
        WebUI.sendText(nameDesEdit, desEdit);
        WebUI.clickElement(saveEditButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(nameNewCategory);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewCategory, NameEdit);
    }



    //DELETE NEW
    private By Delete = By.xpath("//button[@id='delete-selected']");
    private By Checkbox = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[1]/input");
    private By YesButton = By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");

    public void delCategory(){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.moveToElemet(nameNewCategory); //DeleteManufacture vừa add
        String getname = WebUI.getText(nameNewCategory);
        WebUI.clickElement(Checkbox);
        WebUI.sleep(1);
        WebUI.moveToElemet(Delete);
        WebUI.sleep(1);
        WebUI.clickElement(Delete);
        WebUI.clickElement(YesButton);
        WebUI.VerifyTextSoftNotEqual(nameNewCategory, getname);
    }

}
