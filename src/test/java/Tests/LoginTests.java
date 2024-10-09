package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTests {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void bankManagerLoginTest() {
        loginPage.clickBankManagerLogin();
        // Dodaj asertacije za verifikaciju uspešnog logovanja
    }

    @Test
    public void customerLoginTest() {
        loginPage.clickCustomerLogin();
        // Dodaj asertacije za verifikaciju uspešnog logovanja
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

