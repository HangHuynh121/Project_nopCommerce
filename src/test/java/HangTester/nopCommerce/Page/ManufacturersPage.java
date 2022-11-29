package HangTester.nopCommerce.Page;

import org.openqa.selenium.By;
import HangTester.utils.helper.WebUI;

public class ManufacturersPage {

//    private WebDriver driver;

    public ManufacturersPage (){
//        this.driver = driver;
//        new WebUI(driver); //Khởi tạo giá trị class WebUI
    }

    //ADD NEW
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By nameAddPage = By.xpath("//form[@id='category-form']/div[1]/h1");
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By description = By.xpath("//iframe[@id='Description_ifr']");
    private By saveAddButton = By.xpath("//button[@name='save']");
    private By nameNewManufacture = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[2]");

    public void AddManufacture(String Name, String des){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Manufacturer/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddPage,"Add a new manufacturer back to manufacturer list");
        WebUI.sendText(nameAdd,Name);
        WebUI.sendText(description, des);
        WebUI.clickElement(saveAddButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(nameNewManufacture);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewManufacture, Name);
    }

    //EDIT NEW Manufacture
    private By EditButton = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[5]/a"); //edit new at 1st record
//    private By nameEditManufacture = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[2]"); //Change last path /td[2] bằng Manufacture muốn edit
    private By nameEditPage = By.xpath("//div[contains(text(),'Manufacturer info')]");
    private By nameEdit = By.xpath("//input[@id='Name']");
    private By nameDesEdit = By.xpath("//iframe[@id='Description_ifr']");
    private By saveEditButton = By.xpath("//button[@name='save']");

    public void EditManufacture(String NameEdit, String desEdit){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Manufacturer/List");
        WebUI.moveToElemet(nameNewManufacture); //Edit Manufacture vừa add
        WebUI.clickElement(EditButton);
        WebUI.VerifyTextSoft(nameEditPage,"Manufacturer info");
        WebUI.clearText(nameEdit);
        WebUI.sendText(nameEdit,NameEdit);
        WebUI.sendText(nameDesEdit, desEdit);
        WebUI.clickElement(saveEditButton);
        WebUI.sleep(1);
        WebUI.moveToElemet(nameNewManufacture);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(nameNewManufacture, NameEdit);
    }


    //DELETE NEW
    private By Delete = By.xpath("//button[@id='delete-selected']");
    private By Checkbox = By.xpath("//div[@class='dataTables_scroll']/div[2]//tbody/tr[1]/td[1]/input");

    private By YesButton = By.xpath("//button[@id='delete-selected-action-confirmation-submit-button']");
    public void DeleteManufacture(){
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Manufacturer/List");
        WebUI.moveToElemet(nameNewManufacture); //DeleteManufacture vừa add
        String getname = WebUI.getText(nameNewManufacture);
        WebUI.clickElement(Checkbox);
        WebUI.sleep(1);
        WebUI.moveToElemet(Delete);
        WebUI.sleep(1);
        WebUI.clickElement(Delete);
        WebUI.clickElement(YesButton);
        WebUI.VerifyTextSoftNotEqual(nameNewManufacture, getname);
    }




}
