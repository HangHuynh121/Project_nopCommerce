package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScenarioTest extends BaseTest {
    public ScenarioFlow scenarioFlow;
    public ManufacturersPage manufacturersPage;
    public CategoriesPage categoriesPage;
    public VendorsPage vendorsPage;
    public ProductPage productPage;

    @BeforeMethod
    public void ScenarioTest(){
        scenarioFlow = new ScenarioFlow();
        manufacturersPage = new ManufacturersPage();
        categoriesPage = new CategoriesPage();
        vendorsPage = new VendorsPage();
        productPage = new ProductPage();
    }

    @Test
    public void scenarioTest() {
        scenarioFlow = new ScenarioFlow();
        manufacturersPage = scenarioFlow.login();
        categoriesPage = scenarioFlow.manufacturers();
        vendorsPage = scenarioFlow.category();
        productPage = scenarioFlow.vendor();
        scenarioFlow.product();
    }
}