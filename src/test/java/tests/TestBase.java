package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.lang.reflect.Method;
import java.time.Duration;


public class TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter htmlReport;
    protected static ExtentTest logger;

    @BeforeSuite (alwaysRun = true)
    public void setupSuite(){
        extentReports =  new ExtentReports();
        htmlReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/extentReport/report.html");
        extentReports.attachReporter(htmlReport);
        extentReports.setSystemInfo("Project Name", "Webstaurantstore Test Automation");
        extentReports.setSystemInfo("SDETs", "Alina, Elshan, Nargiz, Allan, Andy ");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Browser", System.getProperty("browser") == null ? ConfigReader.getProperty("browser") : System.getProperty("browser"));
        extentReports.setSystemInfo("Homepage", ConfigReader.getProperty("url"));
    }

    @AfterSuite (alwaysRun = true)
    public void tearDownSuite(){
        extentReports.flush();
    }
    @BeforeMethod (alwaysRun = true)
    public void setup(Method method){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger = extentReports.createTest("TEST: " + method.getName());
        logger.info("TEST STARTED: " + method.getName());
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(ITestResult testResult){

        if(testResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("TEST PASSED: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.SKIP){
            logger.skip("TEST SKIPPED: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.FAILURE){
            logger.fail("TEST FAILED: " + testResult.getName());
            logger.fail(testResult.getThrowable());
            //take a screenshot
            String pathOfTheScreenshotFile = SeleniumUtils.getScreenshot("failed");
            logger.addScreenCaptureFromPath(pathOfTheScreenshotFile);
        }
        Driver.quitDriver();
    }}
