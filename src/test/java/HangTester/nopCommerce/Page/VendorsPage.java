package HangTester.nopCommerce.Page;

import HangTester.Helper.ExcelHelper;
import HangTester.utils.WebUI;
import org.openqa.selenium.*;

public class VendorsPage {
    public LoginAdminPage loginAdminPage;

    public VendorsPage() {
        loginAdminPage = new LoginAdminPage();
    }

    public void login() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/DataTest/Login.xlsx", "loginPass");
        loginAdminPage.LoginPass(excelHelper.getCellData("Email", 1), excelHelper.getCellData("Password", 1));
    }

    //ADD NEW

    //Vendors info
    private By SearchItem = By.xpath("//div[@data-hideattribute = 'CategoryPage.HideSearchBlock']");
    private By AddButton = By.xpath("//a[@href='/Admin/Vendor/Create']");
    private By nameAddPage = By.xpath("//h1[contains(.,'Add a new vendor')]");
    private By swith = By.xpath("//div[@class='onoffswitch']");
    private By Display = By.xpath("//div[contains(text(),'Display')]");
    private By VendorItem = By.xpath("//div[@id='vendor-info']");
    private String VendorHide = "card-outline";
    private By nameAdd = By.xpath("//input[@id='Name']");
    private By email = By.xpath("//input[@id='Email']");
    private String checkboxID = "Active";

    public void VendorInfo(String Name, String mail) {
        WebUI.openURL("https://admin-demo.nopcommerce.com/Admin/Vendor/List");
        WebUI.clickElement(AddButton);
        WebUI.VerifyTextSoft(nameAddPage, "Add a new vendor back to vendor list");
        WebUI.onoffSwich(Display, swith);
        WebUI.moveToElemet(VendorItem);
        WebUI.OpenHideItem(nameAdd, VendorItem);
        WebUI.sendText(nameAdd, Name);
        WebUI.sendText(email, mail);
        WebUI.sleep(1);
        WebUI.checkCheckbox(checkboxID);
    }

    //Display
    private By DisplayItem = By.xpath("//div[contains(text(),'Display')]");
    private String priceRange = "PriceRangeFiltering";
    private String manualRange = "ManuallyPriceRange";
    private By PriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceFrom = By.xpath("//label[@for='PriceFrom']//parent::div//parent::div/following-sibling::div/span/span/input[2]");
    private By PriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[1]");
    private By InputPriceTo = By.xpath("//label[@for='PriceTo']//parent::div//parent::div/following-sibling::div/span/span/input[2]");

    public void VendorDisplay(String PriceF, String PriceT) {
        WebUI.moveToElemet(DisplayItem);
        WebUI.OpenHideItem(PriceFrom, DisplayItem);
        WebUI.checkCheckbox(priceRange);
        WebUI.checkCheckbox(manualRange);
        WebUI.moveToElemet(PriceFrom);
        WebUI.clickElement(PriceFrom);
        WebUI.clearText(PriceFrom);
        WebUI.sendText(InputPriceFrom, PriceF);
        WebUI.clickElement(PriceTo);
        WebUI.clearText(PriceTo);
        WebUI.sendText(InputPriceTo, PriceT);

    }

    //SEO
    private By SEOItem = By.xpath("//div[@id='vendor-seo']");
    private String SEOHide = "advanced-setting";
    private By SeName = By.xpath("//input[@id='SeName']");
    private By SaveButton = By.xpath("//button[normalize-space()='Save and Continue Edit']");
    private By alert = By.xpath("//div[@class='alert alert-danger alert-dismissable']");
    private By searchVendor = By.xpath("//input[@id='SearchName']");
    private By searchButton = By.xpath("//button[@id='search-vendors']");

    public void VendorSEO(String name, String Alert) {
        WebUI.moveToElemet(SEOItem);
        WebUI.OpenHideItem(SeName, SEOItem);
        WebUI.sendText(SeName, name);
        WebUI.moveToElemet(SaveButton);
        WebUI.clickJS(SaveButton);
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(alert, Alert);
        WebUI.sendText(searchVendor, name);
        WebUI.clickElement(searchButton);
    }

}


