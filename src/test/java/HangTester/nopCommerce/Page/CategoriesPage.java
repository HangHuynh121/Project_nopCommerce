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
    private By nameAddPage = By.xpath("");
    private By nameAdd = By.xpath("");
    private By description = By.xpath("//iframe[@id='Description_ifr']");
    private By DisplayItem = By.xpath("//div[@id='category-display']//div[@class='card-header with-border clearfix']//div[1]");
    private By PriceFrom = By.xpath("//div[@id='nestedSetting1333918306']/div[1]/div[2]//input[1]");
    private By PriceTo = By.xpath("//div[@id='nestedSetting1333918306']/div[2]/div[2]//input[1]");
    private By saveAddButton = By.xpath("//button[@name='save']");
    private By nameNewCategory = By.xpath("//table[@id='categories-grid']/tbody/tr[1]/td[2]");

    public void AddCategories(String Name, String des){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Category/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddPage,"Add a new category back to category list");
        WebUI.sendText(nameAdd,Name);
        WebUI.sendText(description, des);
        WebUI.clickElement(DisplayItem);
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

    //DELETE NEW

}
