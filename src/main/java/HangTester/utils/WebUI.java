package HangTester.utils;

import HangTester.browsers.DriverManager;
import HangTester.reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WebUI {

    public static void openURL( String url){
        DriverManager.getDriver().get(url);
        logFile.info("Open URL");
        ExtentTestManager.logMessage(Status.PASS,"Open URL: " + url);
    }

    public static void LogConsole(String LogText){
        System.out.println(LogText);
    }

    public static void clickElement( By by){
        waitForElementVisible(by);
        sleep(step_time);
        DriverManager.getDriver().findElement(by).click();
        logFile.info("Click on: " + by);
        ExtentTestManager.logMessage(Status.PASS,"Click on: " + by );

    }

    public static void clickJS(By by){
        waitForElementVisible(by);
        sleep(step_time);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", DriverManager.getDriver().findElement(by));
        logFile.info("Click on: " + by);
        ExtentTestManager.logMessage(Status.PASS,"Click on: " + by );
    }

    public static void ENTER(By by){
        Actions act = new Actions(DriverManager.getDriver());
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        sleep(step_time);
        logFile.info("Click ENTER: " + by);
        ExtentTestManager.logMessage(Status.PASS,"Click ENTER: " + by );
    }

    public static void sendText( By by, String text){
        waitForElementVisible(by);
        sleep(step_time);
        DriverManager.getDriver().findElement(by).sendKeys(text);
        logFile.info("Input data on: " + by);
        ExtentTestManager.logMessage(Status.PASS,"Input data on: " + by );
    }

    public static String getText( By by){
        waitForElementVisible(by);
        sleep(step_time);
        String text = DriverManager.getDriver().findElement(by).getText();
        logFile.info("Get text from: " + by + ", Text is: " + text);
        ExtentTestManager.logMessage(Status.PASS,"Get text from: " + by + ", Text is: " + text);
        return text;

    }

    public static void OpenHideItem(By visible, By action){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(visible));
            try {
                DriverManager.getDriver().findElement(visible).click();
            } catch (WebDriverException e) {
                logFile.info("Item:" + action+ " on");
                ExtentTestManager.logMessage(Status.PASS,"Item:" + action+ " on");
            }
        } catch (TimeoutException e) {
            logFile.info("Item:" + action+ " off");
            ExtentTestManager.logMessage(Status.PASS,"Item:" + action+ " off");
            WebUI.moveToElemet(action);
            WebUI.clickElement(action);
        }
    }

    public static Boolean visibleElement(By element) {
        try {
            DriverManager.getDriver().findElement(element).click();
            return false;
        } catch (ElementNotInteractableException e) {
            return true;
        }
    }

    public static void onoffSwich(By visible, By action){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(visible));
            try {
                DriverManager.getDriver().findElement(visible).click();
            } catch (WebDriverException e) {
                logFile.info("Advanced on");
                ExtentTestManager.logMessage(Status.PASS,"Advanced on");
            }
        } catch (TimeoutException e) {
            logFile.info("Advanced off");
            ExtentTestManager.logMessage(Status.PASS,"Advanced off");
            WebUI.moveToElemet(action);
            WebUI.clickElement(action);
        }
    }

    public static void checkCheckbox(String checkboxID){
        WebElement element = DriverManager.getDriver().findElement(By.id(checkboxID));
        Boolean isSelect = element.isSelected();
        if(isSelect == false){element.click();}
        sleep(0.5);
        logFile.info("Check the checkbox: " + checkboxID);
        ExtentTestManager.logMessage(Status.PASS, "Check the checkbox: " + checkboxID);

    }

    public static  void selectDopdown(String ID, String value){
        Select select = new Select(DriverManager.getDriver().findElement(By.id(ID)));
        select.selectByVisibleText(value);
        sleep(step_time);
        logFile.info("Select Dropdown: " + ID);
        ExtentTestManager.logMessage(Status.PASS,"Select Dropdown: " + ID);

    }

    public static  void moveToElemet(By by){
        waitForElementVisible(by);
        WebElement element = DriverManager.getDriver().findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        sleep(step_time);
        logFile.info("Move to: " + by);
        ExtentTestManager.logMessage(Status.PASS,"Move to: " + by);

    }

    public static void clearText(By by){
        Actions act = new Actions(DriverManager.getDriver());
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
        sleep(step_time);
        logFile.info("Clear text on: " + by );
        ExtentTestManager.logMessage(Status.PASS,"Clear text on: " + by );
    }

    public static void VerifyTextSoft(  By by, String exp){
        SoftAssert sa = new SoftAssert();
        waitForElementVisible(by);
        sleep(step_time);
        String act = DriverManager.getDriver().findElement(by).getText();
        sa.assertEquals(act, exp);
        sa.assertAll();
        logFile.info("Verify text equal on: " + by + " - Act: " + act + " - Exp: " + exp);
        ExtentTestManager.logMessage(Status.PASS,"Verify text equal on: " + by + " - Act: " + act + " - Exp: " + exp );
    }


    public static void VerifyTextSoftNotEqual(  By by, String exp){
        waitForElementVisible(by);
        SoftAssert sa = new SoftAssert();
        waitForElementVisible(by);
        sleep(step_time);
        String act = DriverManager.getDriver().findElement(by).getText();
        sa.assertNotEquals(act, exp);
        sa.assertAll();
        logFile.info("Verify text not equal on: " + by + " - Act: " + act + " - Exp: " + exp);
        ExtentTestManager.logMessage(Status.FAIL,"Verify text not equal on: " + by + " - Act: " + act + " - Exp: " + exp );
    }

    public static  void VerifyTextHardEqual(By by, String exp){
        SoftAssert sa = new SoftAssert();
        waitForElementVisible(by);
        sleep(step_time);
        String act = DriverManager.getDriver().findElement(by).getText();
        Assert.assertEquals(act, exp);
        logFile.info("Verify text not equal on: " + by + " - Act: " + act + " - Exp: " + exp);
        ExtentTestManager.logMessage(Status.PASS, "Verify text not equal on: " + by + " - Act: " + act + " - Exp: " + exp );


    }


    private static int timeout = 10;
    public static void waitForElementToClick( By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementVisible( By by){
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Throwable error){
            logFile.info("Timeout waiting for the element Visible: " + by.toString());
            Assert.fail("Timeout waiting for the element Visible: " + by.toString());
            ExtentTestManager.logMessage(Status.PASS, "Timeout waiting for the element Visible: " + by.toString());
        }
    }

    private static double step_time = 0.1;
    public static void sleep(double seconds){
        try{
            Thread.sleep((long) (1000 *seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
