package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.CategoriesPage;
import HangTester.nopCommerce.Page.LoginAdminPage;
import HangTester.nopCommerce.Page.ProductPage;
import HangTester.utils.helper.DataProviderManager;
import HangTester.utils.helper.ExcelHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    public ProductPage productPage;
    public LoginAdminPage loginAdminPage;

    @BeforeMethod
    public void ProductTest(){
        loginAdminPage = new LoginAdminPage();
        productPage = new ProductPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/java/HangTester/nopCommerce/DataTest/Login.xlsx","login");
        loginAdminPage.Login(excelHelper.getCellData("Email",1),excelHelper.getCellData("Password",1));
    }

    @Test (dataProvider = "data_provider_productAdd_excel", dataProviderClass = DataProviderManager.class)
    public void addNew(String name, String des, String searchCat, String searchManu, String price) {
        productPage.ProductInfo(name, des, searchCat, searchManu);
        productPage.ProductPrice(price, name,name);
    }

    @Test (dataProvider = "data_provider_productEdit_excel", dataProviderClass = DataProviderManager.class)
    public void editNew(String name, String searchCate, String nameEdit, String desEdit){
        productPage.editProduct(name,searchCate,nameEdit, desEdit);
    }

    @Test (dataProvider = "data_provider_productDel_excel", dataProviderClass = DataProviderManager.class)
    public void delNew(String nameEdit, String searchCate){
        productPage.delProduct(nameEdit,searchCate);
    }
}
