package HangTester.Helper;

import HangTester.browsers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureHelper {
    //Lấy đường dẫn đến project hiện tại
    private String projectPath = System.getProperty("user.dir") + "\\";
    //Tạo format ngày giờ để xíu gắn dô cái name của screenshot hoặc record video
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public void captureScreenshot( String screenName, String page){
        PropertiesFile.setPropertiesFile();
            try {
            Reporter.log("Driver for Screenshot: " + DriverManager.getDriver());
            // Tạo tham chiếu đối tượng của TakesScreenshot với dirver hiện tại
            TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
            // Gọi hàm getScreenshotAs để chuyển hóa hình ảnh về dạng FILE
            File source = ts.getScreenshotAs(OutputType.FILE);
            //Kiểm tra folder nếu không tồn tại thì tạo folder
            File theDir = new File(projectPath + PropertiesFile.getPropValue( "KeyProp") + "\\" + PropertiesFile.getPropValue(page));
            if (!theDir.exists()){
                theDir.mkdirs();
            }
            // Chổ này đặt tên thì truyền biến "screenName" gán cho tên File chụp màn hình
            FileHandler.copy(source, new File(projectPath + PropertiesFile.getPropValue("KeyProp") + "\\" + PropertiesFile.getPropValue(page) + "\\" + screenName + "_" + dateFormat.format(new Date()) + ".png"));
            System.out.println("Screenshot taken: " + screenName);
            Reporter.log("Screenshot taken current URL: " + DriverManager.getDriver().getCurrentUrl(), true);
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
