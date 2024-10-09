package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    // Metoda za inicijalizaciju WebDriver-a
    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public void setup(Method method) {
        // Inicijalizacija ExtentReports
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        // Kreiranje testa za izveštaj
        test = extent.createTest(method.getName());

        // Pokretanje browser-a
        driver = initializeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Ako test padne, uzmi screenshot
            String screenshotPath = takeScreenshot(result.getName());
            test.fail("Test Failed").addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            // Ako test uspe, zabeleži uspešan ishod
            test.pass("Test Passed");
        }

        // Zatvori browser
        driver.quit();
        // Zatvori ExtentReports
        extent.flush();
    }

    // Metoda za snimanje screenshot-a
    public String takeScreenshot(String testName) throws IOException {
        // Kreiranje unikatnog imena za screenshot fajl
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "./Screenshots/" + testName + "_" + timestamp + ".png";

        // Snimanje screenshot-a
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotPath));

        return screenshotPath;
    }
}
