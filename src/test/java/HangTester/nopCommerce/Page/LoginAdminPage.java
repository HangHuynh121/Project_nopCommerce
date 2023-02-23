package HangTester.nopCommerce.Page;

import HangTester.utils.WebUI;
import org.openqa.selenium.By;

public class LoginAdminPage {

    public LoginAdminPage() {

    }

    public String pageNameExp = "Admin area demo";
    private By pageNameAct = By.xpath("//h1[normalize-space()='Admin area demo']");
    private By email = By.xpath("//input[@id='Email']");
    private By password = By.xpath("//input[@id='Password']");

    private By loginButton = By.xpath("//button[normalize-space()='Log in']");

    private By nameAdminPageAct = By.xpath("//h1[normalize-space()='Dashboard']");
    public String nameAdminPageExp = "Dashboard";
    public By ErrorMsg = By.xpath("//div[@class='message-error validation-summary-errors']");

    public void LoginPass(String mail, String pass) {
        WebUI.LogConsole("LOGIN");
        WebUI.openURL("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(pageNameAct, pageNameExp);
        WebUI.clickElement(email);
        WebUI.clearText(email);
        WebUI.sendText(email, mail);
        WebUI.clickElement(password);
        WebUI.clearText(password);
        WebUI.sendText(password, pass);
        WebUI.clickElement(loginButton);
        WebUI.VerifyTextHardEqual(nameAdminPageAct, nameAdminPageExp);
        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");

    }

    public void LoginFail(String mail, String pass, String expMSG) {
        WebUI.LogConsole("LOGIN");
        WebUI.openURL("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        WebUI.sleep(1);
        WebUI.VerifyTextSoft(pageNameAct, pageNameExp);
        WebUI.clickElement(email);
        WebUI.clearText(email);
        WebUI.sendText(email, mail);
        WebUI.clickElement(password);
        WebUI.clearText(password);
        WebUI.sendText(password, pass);
        WebUI.clickElement(loginButton);
        WebUI.VerifyTextHardEqual(ErrorMsg, expMSG);
        WebUI.LogConsole("----------------------------------------------------------------------------------------------------------------------");

    }


}
