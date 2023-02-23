package HangTester.nopCommerce.common;

import HangTester.browsers.DriverManager;
import HangTester.nopCommerce.Listenner.TestListenner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

@Listeners(TestListenner.class)
public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browserName){
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
    }

    public WebDriver setupBrowser(String browserName){
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFifoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Brower: " + browserName + "is invalid,Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return  driver;
    }

    private WebDriver initChromeDriver(){
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver(){
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    private WebDriver initFifoxDriver(){
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }


    @AfterMethod
    public void closeDriver(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }

        if(DriverManager.getDriver() != null){
            DriverManager.quit();
        }
    }
}
