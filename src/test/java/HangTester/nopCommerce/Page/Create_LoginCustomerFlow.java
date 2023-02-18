package HangTester.nopCommerce.Page;

import HangTester.utils.WebUI;
import org.openqa.selenium.By;

public class Create_LoginCustomerFlow {
    public LoginAdminPage loginAdminPage;

    public Create_LoginCustomerFlow() {
        loginAdminPage = new LoginAdminPage();
    }

    ;

    //CREATE NEW ACC
    private By CustomerParentMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    private By CustomerChildMenu = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
    private By AddButton = By.xpath("//a[normalize-space()='Add new']");
    private By pageName = By.xpath("//h1[@class='float-left']");
    private By CusInfoItem = By.xpath("//i[@class='fas fa-info']");
    private By inputEmail = By.xpath("//input[@id='Email']");
    private By inputPass = By.xpath("//input[@id='Password']");
    private By FirstName = By.xpath("//input[@id='FirstName']");
    private By LastName = By.xpath("//input[@id='LastName']");
    private String FemaleCheckbox = "Gender_Female";
    private By searchRole = By.xpath("//div[@class='input-group-append input-group-required']//input[@role='listbox']");
    private By saveButton = By.xpath("//button[@name='save']");
    private By searchItem = By.xpath("//div[@data-hideattribute='CustomerListPage.HideSearchBlock']");
    private By searchEmail = By.xpath("//input[@id='SearchEmail']");
    private By searchButton = By.xpath("//button[@id='search-customers']");
    private By nameNew = By.xpath("//tbody//tr[1]//td[2]");
    private By LogOutButton = By.xpath("//a[normalize-space()='Logout']");

    public LoginAdminPage CreateACC(String emailCus, String passCus, String pagename, String FName, String LName, String role) {
        WebUI.LogConsole("CREATE NEW ACC");
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Customer/List");
        WebUI.OpenHideItem(CustomerChildMenu, CustomerParentMenu);
        WebUI.clickElement(CustomerChildMenu);
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(pageName, pagename);
        WebUI.OpenHideItem(inputEmail, CusInfoItem);
        WebUI.sendText(inputEmail, emailCus);
        WebUI.sendText(inputPass, passCus);
        WebUI.sendText(FirstName, FName);
        WebUI.sendText(LastName, LName);
        WebUI.checkCheckbox(FemaleCheckbox);
        WebUI.moveToElemet(searchRole);
        WebUI.clickElement(searchRole);
        WebUI.sendText(searchRole, role);
        WebUI.sleep(0.5);
        WebUI.ENTER(searchRole);
        WebUI.moveToElemet(saveButton);
        WebUI.clickElement(saveButton);
        WebUI.sleep(1);
        WebUI.OpenHideItem(searchEmail, searchItem);
        WebUI.sendText(searchEmail, emailCus);
        WebUI.sleep(1);
        WebUI.moveToElemet(searchButton);
        WebUI.clickElement(searchButton);
        WebUI.VerifyTextSoft(nameNew, emailCus);

        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
        WebUI.LogConsole("LOG OUT");
        WebUI.moveToElemet(LogOutButton);
        WebUI.sleep(1);
        WebUI.clickElement(LogOutButton);
        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");
        return new LoginAdminPage();

    }


    //    LOGIN NEW ACC
    public void LoginNewACC(String emailCus, String passCus) {
        WebUI.LogConsole("Login by new Customer ACC");
        loginAdminPage.Login(emailCus, passCus);

    }
}





