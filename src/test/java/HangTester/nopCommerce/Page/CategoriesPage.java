package HangTester.nopCommerce.Page;

import HangTester.browsers.DriverManager;
import com.github.dockerjava.api.model.SearchItem;
import org.openqa.selenium.By;
import HangTester.utils.helper.WebUI;
import org.openqa.selenium.WebElement;

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
//        private By SearchItem = By.xpath("//div[@class='card card-default card-search']//div[@class='card-body']/div[1]");
        private By SearchItem = By.xpath("//div[@data-hideattribute = 'CategoryPage.HideSearchBlock']");
    private String SearchHide = "row search-row";
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
        WebUI.OpenHideItem(CategoryItem, "class", CategoryHide);
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
    private By nameNewCategory = By.xpath("//table[@id='categories-grid']/tbody/tr[1]/td[2]");

    public void CatgoryDisplay(String PriceF, String PriceT){
        WebUI.moveToElemet(DisplayItem);
        WebUI.OpenHideItem(DisplayItem,"class", DisplayHide);
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
        WebUI.OpenHideItem(MapItem,"class",MapHide);
        WebUI.clickElement(LimitCus);
        WebUI.sendText(inputLimitCus,CusValue);
        WebUI.ENTER(LimitCus);
        WebUI.clickElement(LimitStore);
        WebUI.sendText(inputLimiteStore,StoreValue);
        WebUI.ENTER(LimitCus);

    }

        //SEO
    private By SEOItem = By.xpath("//div[@id='category-seo']");
    private String SEOHIde = "card card-secondary card-outline advanced-setting collapsed-card";
    private By InputSearchEngine = By.xpath("//input[@id='SeName']");
    private By InputMetalTitle = By.xpath("//input[@id='MetaTitle']");
    private By InputMetalKey = By.xpath("//input[@id='MetaKeywords']");
    private By saveAddButton = By.xpath("//button[@name='save']");
    private By searchCat = By.xpath("//input[@id='SearchCategoryName']");
    private By searchButton = By.xpath("//button[@id='search-categories']");
    public void SEO(String search, String title, String key,String parentCat, String Name)
    /*
    String Name  = String Name / CategoryInfo menthod
    String parentCat = String valueparentCat/ CategoryInfo menthod
    */
    {
        WebUI.moveToElemet(SEOItem);
        WebUI.OpenHideItem(SEOItem,"class", SEOHIde);
        WebUI.sendText(InputSearchEngine, search);
        WebUI.sendText(InputMetalTitle, title);
        WebUI.sendText(InputMetalKey,key);
        WebUI.moveToElemet(saveAddButton);
        WebUI.clickElement(saveAddButton);
        WebUI.sleep(1);


//        WebUI.OpenHideItem(SearchItem,"class", SearchHide );
        WebElement element = DriverManager.getDriver().findElement(SearchItem);
        String stt = element.getAttribute("class");
        System.out.println("Stt: " + stt);
        WebUI.clickElement(SearchItem);
//        if (stt.equals("row search-row")){
//            System.out.println("SearchHide" + SearchHide);
//            WebUI.clickElement(By.xpath("//i[@class='far fa-angle-down']"));
//        }
        WebUI.sleep(2);





        WebUI.sendText(searchCat,Name);
        WebUI.clickElement(searchButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(nameNewCategory);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewCategory, parentCat + " >> "+ Name);
    }



    //EDIT NEW
    private By EditButton = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[5]/a");
    private By nameEditPage = By.xpath("//form[@id='category-form']/div[1]/h1");
    private By nameEdit = By.xpath("//input[@id='Name']");
    private By nameDesEdit = By.xpath("//iframe[@id='Description_ifr']");
    private By saveEditButton = By.xpath("//button[@name='save']");

    public  void editCategory(String Name, String NameEdit, String desEdit, String parentCat){
        /*
    String Name  = String Name / CategoryInfo menthod
    String parentCat = String valueparentCat/ CategoryInfo menthod
         */

        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.OpenHideItem(SearchItem,"class", SearchHide );
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
    }



    //DELETE NEW

    private By Delete = By.xpath("//button[@id='delete-selected']");
    private By Checkbox = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[1]/input");
    private By YesButton = By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");

    public void delCategory(String NameEdit ){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.OpenHideItem(SearchItem,"class", SearchHide );
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
