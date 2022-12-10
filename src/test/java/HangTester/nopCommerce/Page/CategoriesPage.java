package HangTester.nopCommerce.Page;

import org.openqa.selenium.By;
import HangTester.utils.helper.WebUI;

public class CategoriesPage {

//    private WebDriver driver;

    public CategoriesPage(){
//        this.driver = driver;
//        new WebUI(driver);
    }


    //ADD NEW
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By nameAddPage = By.xpath("//h1[contains(.,'Add a new category')]");
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By description = By.xpath("//iframe[@id='Description_ifr']");
    private By DisplayItem = By.xpath("//div[@id='category-display']//div[@class='card-header with-border clearfix']//div[1]");
    private By PriceFrom = By.xpath("//div[@id='nestedSetting1126636056']/div[1]/div[2]/span/span/input");
    private By PriceTo = By.xpath("//input[@id='PriceTo']");
    private By saveAddButton = By.xpath("//button[@name='save']");
    private By nameNewCategory = By.xpath("//table[@id='categories-grid']/tbody/tr[1]/td[2]");

    public void AddCategory(String Name, String des){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddPage,"Add a new category back to category list");
        WebUI.sendText(nameAdd,Name);
        WebUI.sendText(description, des);
        WebUI.clickElement(DisplayItem);
        WebUI.moveToElemet(PriceFrom);
        WebUI.clearText(PriceFrom);
        WebUI.sendText(PriceFrom,"100");
        WebUI.clearText(PriceTo);
        WebUI.sendText(PriceTo,"1000");
        WebUI.clickElement(saveAddButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(nameNewCategory);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewCategory, Name);

    }

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
    public void delCategory(){

    }

}
