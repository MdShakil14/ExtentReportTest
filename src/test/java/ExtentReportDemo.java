import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extentReports;
    WebDriver driver;

    @BeforeTest
    public void config(){
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Extent Test Report Basic");
        reporter.config().setReportName("Web Automation");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Test Name","Shakil");
    }

    @Test
    public void initialDemo(){
        ExtentTest test = extentReports.createTest("Title Test");
        System.setProperty("webdriver.chrome.driver","D:\\Programming Related Software\\Selenium\\chorome driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
      //  test.addScreenCaptureFromBase64String()
       // test.fail("Failed");
        extentReports.flush();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
