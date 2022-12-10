package HangTester.utils.helper;

import HangTester.browsers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class WebUI {

    //Truyền driver tập trung 1 nơi
//    private static WebDriver  driver;
//    public WebUI(WebDriver driver){
//        WebUI.driver = driver;
//    }

    public static void openURL( String url){
        DriverManager.getDriver().get(url);
    }

    public static void Log (String LogText){
        System.out.println(LogText);
    }

    public static void clickElement( By by){
        waitForElementVisible(by);
        sleep(step_time);
        DriverManager.getDriver().findElement(by).click();
        Log("Click on: " + by);

    }

    public static void sendText( By by, String text){
        waitForElementVisible(by);
        sleep(step_time);
        DriverManager.getDriver().findElement(by).sendKeys(text);
        Log("Input data: " + by);
    }

    public static String getText( By by){
        waitForElementVisible(by);
        sleep(step_time);
        String text = DriverManager.getDriver().findElement(by).getText();
        Log("Get text from: " + by + ", Text is: " + text);
        return text;

    }

//    public static String getAttribute(String attri){
//        WebElement element = DriverManager.getDriver().findElement(By.class(attri));
//    }

    public static  void moveToElemet(By by){
        waitForElementVisible(by);
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        sleep(step_time);
        Log("Move to: " + by);

    }

    public static void clearText(By by){

        waitForElementVisible(by);
        sleep(step_time);
        DriverManager.getDriver().findElement(by).clear();
        Log("Clear text on: " + by + "before input new text");

    }

    public static void VerifyTextSoft(  By by, String exp){
        waitForElementVisible(by);
        SoftAssert sa = new SoftAssert();
        waitForElementVisible(by);
        sleep(step_time);
        String act = DriverManager.getDriver().findElement(by).getText();
        sa.assertEquals(act, exp);
        sa.assertAll();
        Log("Verify text equal on: " + by);
    }


    public static void VerifyTextHard(){

    }


    public static void VerifyTextSoftNotEqual(  By by, String exp){
        waitForElementVisible(by);
        SoftAssert sa = new SoftAssert();
        waitForElementVisible(by);
        sleep(step_time);
        String act = DriverManager.getDriver().findElement(by).getText();
        sa.assertNotEquals(act, exp);
        sa.assertAll();
        Log("Verify text not equal on: " + by);
    }


    private static int timeout = 10;
    public static void waitForElementToClick( By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementVisible( By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private static double step_time = 1;
    public static void sleep(double seconds){
        try{
            Thread.sleep((long) (1000 *seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
