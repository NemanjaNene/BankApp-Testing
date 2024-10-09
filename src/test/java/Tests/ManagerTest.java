package Tests;

import Pages.LoginPage;
import Pages.ManagerPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ManagerTest extends TestBase {

    LoginPage loginPage;
    ManagerPage managerPage;

    @BeforeMethod
    public void setup() {
        driver = initializeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");  // Idi na odgovarajuću početnu stranicu
        loginPage = new LoginPage(driver);
        managerPage = new ManagerPage(driver);
        loginPage.clickBankManagerLogin();  // Obavi login kao menadžer
    }



    @Test(priority = 1)
    public void addCustomerTest() {
        // Otvori Add Customer stranicu
        managerPage.clickAddCustomer();
        // Dodaj novog korisnika
        managerPage.addCustomer("Nemanja", "Nikitovic", "12345");

        // Ovde možeš dodati asertaciju za verifikaciju uspešnog dodavanja
    }

    @Test(priority = 2)
    public void openAccountTest() {
        // Otvori Open Account stranicu
        managerPage.clickOpenAccount();


    }

    @Test(priority = 3)
    public void deleteCustomerTest() {
        // Otvori stranicu Customers
        managerPage.clickCustomers();

        // Logika za pretragu korisnika i njegovo brisanje
        // Ovde možeš dodati kod za brisanje korisnika
    }

    @Test(priority = 4)
    public void searchCustomerTest() {
        // Otvori stranicu Customers
        managerPage.clickCustomers();

        // Logika za pretragu korisnika
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
