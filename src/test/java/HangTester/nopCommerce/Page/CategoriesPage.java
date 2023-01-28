package HangTester.nopCommerce.Page;

import HangTester.browsers.DriverManager;
import com.github.dockerjava.api.model.SearchItem;
import org.openqa.selenium.By;
import HangTester.utils.helper.WebUI;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CategoriesPage {

    public CategoriesPage(){

    }

    //ADD NEW

        //Category info
    private By SearchItem = By.xpath("//div[@data-hideattribute = 'CategoryPage.HideSearchBlock']");
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By CategoryItem = By.xpath("//div[@id='category-info']/div[1]");
    private By nameAddPage = By.xpath("//h1[contains(.,'Add a new category')]");
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By description = By.xpath("//iframe[@id='Description_ifr']");
    private By parentCategory = By.xpath("//select[@id='ParentCategoryId']");
    private String parentCatID = "ParentCategoryId";
    public void CategoryInfo(String Name, String des, String valueparentCat) {
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddPage, "Add a new category back to category list");
        WebUI.Log("CATEGORY INFO");
        WebUI.OpenHideItem(nameAdd,CategoryItem);
        WebUI.sendText(nameAdd, Name);
        WebUI.sendText(description, des);
        WebUI.clickElement(parentCategory);
        WebUI.selectDopdown(parentCatID,valueparentCat );

    }

        //Display
    public By swich = By.xpath("//div[@class='onoffswitch']");
    private By DisplayItem = By.xpath("//div[@id='category-display']");
    private String PublicCheckbox = "Published";
    private String ShowHomeCheckbox = "ShowOnHomepage";
    private By PriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[2]");
    private By PriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[2]");
    private By displayOrder = By.xpath("//label[normalize-space()='Display order']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By nameNewCategory = By.xpath("//table[@id='categories-grid']/tbody/tr[1]/td[2]");

    public void CatgoryDisplay(String PriceF, String PriceT){
        WebUI.Log("CATEGORY DISPLAY");
        WebUI.moveToElemet(DisplayItem);
        WebUI.OpenHideItem(displayOrder,DisplayItem);
        WebUI.onoffSwich(MapItem,swich);
        WebUI.moveToElemet(DisplayItem);
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
    private By LimitCus = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]");
    private By inputLimitCus = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[2]//div[2]//div[1]//div[1]//div[1]//div[1]/input");
    private By LimitStore = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[3]//div[2]//div[1]//div[1]//div[1]//div[1]");
    private By inputLimiteStore = By.xpath("//div[@id='category-mappings']//div[@class='card-body']//div[3]//div[2]//div[1]//div[1]//div[1]//div[1]/input");
    public void Mapping(String CusValue, String StoreValue){
        WebUI.Log("MAPPING");
        WebUI.moveToElemet(MapItem);
        WebUI.OpenHideItem(LimitCus,MapItem);
        WebUI.clickElement(LimitCus);
        WebUI.sendText(inputLimitCus,CusValue);
        WebUI.ENTER(LimitCus);
        WebUI.clickElement(LimitStore);
        WebUI.sendText(inputLimiteStore,StoreValue);
        WebUI.ENTER(LimitCus);

    }

        //SEO
    private By SEOItem = By.xpath("//div[@id='category-seo']");
    private By InputSearchEngine = By.xpath("//input[@id='SeName']");
    private By InputMetalTitle = By.xpath("//input[@id='MetaTitle']");
    private By InputMetalKey = By.xpath("//input[@id='MetaKeywords']");
    private By saveAddButton = By.xpath("//button[@name='save']");
    private By searchCat = By.xpath("//input[@id='SearchCategoryName']");
    private By searchButton = By.xpath("//button[@id='search-categories']");
    public void SEO(String search, String title, String key,String parentCat, String Name) {
        WebUI.Log("SEO");
        WebUI.moveToElemet(SEOItem);
        WebUI.OpenHideItem(InputSearchEngine,SEOItem);
        WebUI.sendText(InputSearchEngine, search);
        WebUI.sendText(InputMetalTitle, title);
        WebUI.sendText(InputMetalKey,key);
        WebUI.moveToElemet(saveAddButton);
        WebUI.clickElement(saveAddButton);
        WebUI.sleep(1);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
        WebUI.Log("SEARCH NEW CATEGORY");
        WebUI.OpenHideItem(searchCat,SearchItem);
        WebUI.sendText(searchCat,Name);
        WebUI.clickElement(searchButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(nameNewCategory);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewCategory, parentCat + " >> "+ Name);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
    }


    //EDIT NEW
    private By EditButton = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[5]/a");
    private By nameEditPage = By.xpath("//form[@id='category-form']/div[1]/h1");
    private By nameEdit = By.xpath("//input[@id='Name']");
    private By nameDesEdit = By.xpath("//iframe[@id='Description_ifr']");
    private By saveEditButton = By.xpath("//button[@name='save']");

    public  void editCategory(String Name, String NameEdit, String desEdit, String parentCat){
        WebUI.Log("EDIT CATEGORY");
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.OpenHideItem(searchCat,SearchItem);
        WebUI.sendText(searchCat,Name);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(EditButton);
        WebUI.clickElement(EditButton);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameEditPage,"Edit category details - " + Name +" back to category list");
        WebUI.clickElement(nameEdit);
        WebUI.clearText(nameEdit);
        WebUI.sendText(nameEdit,NameEdit);
        WebUI.sendText(nameDesEdit, desEdit);
        WebUI.moveToElemet(saveEditButton);
        WebUI.clickElement(saveEditButton);
        WebUI.sleep(1);
        WebUI.sendText(searchCat,NameEdit);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(nameNewCategory);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewCategory, parentCat + " >> "+ NameEdit);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
    }

    //DELETE NEW

    private By Delete = By.xpath("//button[@id='delete-selected']");
    private By Checkbox = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[1]/input");
    private By YesButton = By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");
    public void delCategory(String NameEdit ){
        WebUI.Log("DELETE NEW CATEGORY");
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.OpenHideItem(searchCat,SearchItem);
        WebUI.sendText(searchCat, NameEdit);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(nameNewCategory); //DeleteManufacture vừa add
        WebUI.clickElement(Checkbox);
        WebUI.sleep(1);
        WebUI.moveToElemet(Delete);
        WebUI.sleep(1);
        WebUI.clickElement(Delete);
        WebUI.clickElement(YesButton);
    }

}
