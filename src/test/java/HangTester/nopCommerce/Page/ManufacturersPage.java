package HangTester.nopCommerce.Page;

import org.openqa.selenium.By;
import HangTester.utils.helper.WebUI;

public class ManufacturersPage {

    public ManufacturersPage() {

    }

    //ADD NEW

        //ManufactorInfor
    private By searchItem = By.xpath("//div[@data-hideattribute='ManufacturersPage.HideSearchBlock']");
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By nameAddPage = By.xpath("//h1[@class='float-left']");
    private By manufactoItem = By.xpath("//div[@id='manufacturer-info']//div[@class='card-header with-border clearfix']");
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By description = By.xpath("//iframe[@id='Description_ifr']");

    public void ManufactorItem(String Name, String des) {
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Manufacturer/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddPage, "Add a new manufacturer back to manufacturer list");
        WebUI.Log("MANUFACTOR INFOR");
        WebUI.OpenHideItem(nameAdd,manufactoItem);
        WebUI.sendText(nameAdd, Name);
        WebUI.sendText(description, des);
         }

        //Display Item
    public By swich = By.xpath("//div[@class='onoffswitch']");
    private By DisplayItem = By.xpath("//div[@id='manufacturer-display']//div[@class='card-header with-border clearfix']");
    private By MapItem = By.xpath("//div[@id='manufacturer-mappings']//div[@class='card-header with-border clearfix']");
    private String PublicCheckbox = "Published";
    private String ShowHomeCheckbox = "ManuallyPriceRange";
    private By PriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[2]");
    private By PriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[2]");
    private By displayOrder = By.xpath("//label[normalize-space()='Display order']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By saveAddButton = By.xpath("//button[@name='save']");
    private By nameNewManufacture = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[2]");
    private By searchManu = By.xpath("//input[@id='SearchManufacturerName']");
    private By searchButton = By.xpath("//button[@id='search-manufacturers']");
    public void ManufactorDisplay(String PriceF, String PriceT, String Name){
        WebUI.Log("ADD NEW MANUFACTURE");
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
        WebUI.moveToElemet(saveAddButton);
        WebUI.clickElement(saveAddButton);
        WebUI.sleep(1);
        WebUI.OpenHideItem(searchManu,searchItem);
        WebUI.sendText(searchManu,Name);
        WebUI.moveToElemet(nameNewManufacture);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewManufacture, Name);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");

    }

    //EDIT NEW Manufacture
    private By EditButton = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[5]/a"); //edit new at 1st record
    private By nameEditPage = By.xpath("//h1[@class='float-left']");
    private By nameEdit = By.xpath("//input[@id='Name']");
    private By nameDesEdit = By.xpath("//iframe[@id='Description_ifr']");
    private By saveEditButton = By.xpath("//button[@name='save']");

    public void EditManufacture(String Name, String NameEdit, String desEdit) {
        WebUI.Log("EDIT NEW MANUFACTURE");
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Manufacturer/List");
        WebUI.OpenHideItem(searchManu,searchItem);
        WebUI.sendText(searchManu,Name);
        WebUI.clickElement(searchButton);
        WebUI.moveToElemet(nameNewManufacture); //Edit Manufacture vừa add
        WebUI.clickElement(EditButton);
        WebUI.VerifyTextSoft(nameEditPage, "Edit manufacturer details - " + Name + " back to manufacturer list");
        WebUI.clickElement(nameEdit);
        WebUI.clearText(nameEdit);
        WebUI.sendText(nameEdit, NameEdit);
        WebUI.sendText(nameDesEdit, desEdit);
        WebUI.moveToElemet(saveEditButton);
        WebUI.clickElement(saveEditButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(nameNewManufacture);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewManufacture, NameEdit);
        WebUI.Log("----------------------------------------------------------------------------------------------------------------------");
    }


    //DELETE NEW
    private By Delete = By.xpath("//button[@id='delete-selected']");
    private By Checkbox = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[1]/input");
    private By YesButton = By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");

    public void DeleteManufacture(String NameEdit) {
        WebUI.Log("DELETE NEW MANUFACTURE");
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Manufacturer/List");
        WebUI.OpenHideItem(searchManu,searchItem);
        WebUI.sendText(searchManu,NameEdit);
        WebUI.clickElement(searchButton);
        WebUI.clickElement(Checkbox);
        WebUI.sleep(1);
        WebUI.moveToElemet(Delete);
        WebUI.sleep(1);
        WebUI.clickElement(Delete);
        WebUI.clickElement(YesButton);
    }

}
