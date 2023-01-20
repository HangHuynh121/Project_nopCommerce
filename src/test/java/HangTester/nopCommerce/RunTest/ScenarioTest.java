package HangTester.nopCommerce.RunTest;

import HangTester.browsers.BaseTest;
import HangTester.nopCommerce.Page.Scenario1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScenarioTest extends BaseTest {
    public Scenario1 scenario1;

    @BeforeMethod
    public void ScenarioTest(){
        scenario1 = new Scenario1();
        scenario1.login();
    }

    @Test (priority = 1)
    public void addManufacturer(){scenario1.manufacturers();}

    @Test (priority = 2)
    public void addCategory(){scenario1.category();}

    @Test(priority = 3)
    public void addVendor(){scenario1.vendor();}

    @Test (priority = 4)
    public void addProduct(){scenario1.product();}
}
