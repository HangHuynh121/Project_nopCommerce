package HangTester.nopCommerce.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import HangTester.utils.helper.WebUI;

public class LoginAdminPage {

//    private WebDriver driver;
    //Hàm xây dựng
    public LoginAdminPage(){
//        this.driver = driver;
//        new WebUI(driver); //Khởi tạo giá trị class WebUI
    }

    public String pageNameExp = "Admin area demo";
    private By pageNameAct = By.xpath("//h1[normalize-space()='Admin area demo']");
    private By email = By.xpath("//input[@id='Email']");
    private By password= By.xpath("//input[@id='Password']");
    private By loginButton = By.xpath("//button[normalize-space()='Log in']");

    private By nameAdminPageAct = By.xpath("//h1[normalize-space()='Dashboard']");
    public  String nameAdminPageExp = "Dashboard";
    public void Login(String mail, String pass){
        WebUI.openURL("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        WebUI.sleep(5);
        WebUI.VerifyTextSoft(pageNameAct,pageNameExp);
        WebUI.sendText(email,mail);
        WebUI.sendText(password,pass);
        WebUI.clickElement(loginButton);
        WebUI.VerifyTextSoft(nameAdminPageAct,nameAdminPageExp);
    }


}
