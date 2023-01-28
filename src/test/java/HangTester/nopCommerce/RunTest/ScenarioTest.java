package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.*;
import org.testng.annotations.Test;

public class ScenarioTest extends BaseTest {
    public ScenarioFlow scenarioFlow;
    public ManufacturersPage manufacturersPage;
    public CategoriesPage categoriesPage;
    public VendorsPage vendorsPage;
    public ProductPage productPage;
    @Test
    public void ScenarioTest(String mail, String pass){
        scenarioFlow = new ScenarioFlow();
        manufacturersPage = scenarioFlow.login(mail, pass);
        categoriesPage = scenarioFlow.manufacturers();
        vendorsPage = scenarioFlow.category();
        productPage = scenarioFlow.vendor();
        scenarioFlow.product();
    }

}
