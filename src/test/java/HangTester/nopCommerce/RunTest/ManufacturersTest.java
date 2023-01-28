package HangTester.nopCommerce.RunTest;

import HangTester.browsers.DriverManager;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.ManufacturersPage;
import HangTester.browsers.BaseTest;
import HangTester.utils.helper.DataProviderManager;
import HangTester.utils.helper.ExcelHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;

public class ManufacturersTest extends BaseTest {

    public ManufacturersPage manufacturersPage;
    public LoginAdminPage loginAdminPage;


    @BeforeMethod()
    public void ManufacturesTest(){
        loginAdminPage = new LoginAdminPage();
        manufacturersPage = new ManufacturersPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/java/HangTester/nopCommerce/DataTest/Login.xlsx","login");
        loginAdminPage.Login(excelHelper.getCellData("Email",1),excelHelper.getCellData("Password",1));
       }

    @Test (priority = 1, dataProvider = "data_provider_manufactureAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String des, String priceF, String priceT){
        manufacturersPage.ManufactorItem(name, des);
        manufacturersPage.ManufactorDisplay(priceF,priceT,name);
    }

    @Test(priority = 2, dataProvider = "data_provider_manufactureEdit_excel", dataProviderClass = DataProviderManager.class)
    public void editNew(String name, String newName, String newDes){
        manufacturersPage.EditManufacture( name,newName, newDes);
    }

    @Test (priority = 3, dataProvider = "data_provider_manufactureDel_excel", dataProviderClass = DataProviderManager.class)
    public void delNew(String search){
        manufacturersPage.DeleteManufacture(search);
    }
}
