package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.ConfigManager;
import utils.ExtentReportManager;

import java.io.FileNotFoundException;
import java.time.Duration;


public class basetest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void teardownReport() {
        extent.flush();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        ConfigManager.loadProperties();
        String url = ConfigManager.getProperties("url");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(url);



    }

    @AfterMethod
    public  void tearDown()
    {
        driver.close();
    }


    public void waitimplicit(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    }

    public WebElement waitUntil(By locator, int seconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
     return   wait.until(ExpectedConditions.visibilityOfElementLocated(locator));


    }



    /*    public static WebElement FluentWaitForElement(WebDriver driver, By locator, int timeoutSeconds, int pollingSeconds) {
            FluentWait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofSeconds(pollingSeconds))
                    .ignoring(NoSuchElementException.class);
        }


*//*    wait wait = new FluentWait<>(driver)
            .withTimeout(5,seconds)
            .pollingEvery(3) ///  hygrb 3 mrat kol 5 swany
            .ignoring()*/
}
