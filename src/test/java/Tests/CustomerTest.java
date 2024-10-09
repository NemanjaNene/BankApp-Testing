package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.CustomerPage;
import com.aventstack.extentreports.Status;


import java.io.IOException;

public class CustomerTest extends TestBase {

    @Test
    public void depositTest() throws IOException {
        // Kreiranje objekta CustomerPage
        CustomerPage customerPage = new CustomerPage(driver);

        // 1. Klik na dugme 'Customer Login'
        test.log(Status.INFO, "Klik na dugme 'Customer Login'");
        customerPage.clickCustomerLogin();

        // 2. Izaberi korisnika "Harry Potter"
        test.log(Status.INFO, "Izbor korisnika 'Harry Potter'");
        customerPage.selectUser("Harry Potter");

        // 3. Klik na dugme 'Login'
        test.log(Status.INFO, "Klik na dugme 'Login'");
        customerPage.clickLogin();

        // 4. Klik na dugme 'Deposit' (prvi korak)
        test.log(Status.INFO, "Klik na dugme 'Deposit' za unos sume");
        customerPage.clickDeposit();

        // 5. Unos sume za depozit
        test.log(Status.INFO, "Unos sume za depozit: 500");
        customerPage.enterDepositAmount("500");

        // 6. Klik na dugme Deposit (drugi korak)
        test.log(Status.INFO, "Klik na drugo dugme Deposit za potvrdu");
        customerPage.confirmDeposit();

        // 7. Provera poruke "Deposit Successful"
        String confirmationMessage = customerPage.getDepositConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Deposit Successful", "Poruka 'Deposit Successful' nije prikazana!");
        test.log(Status.PASS, "Poruka 'Deposit Successful' je prikazana!");

        // 8. Screenshot uspešnog testa
        String screenshotPath = takeScreenshot("depositTest_Success");
        test.pass("Test Passed").addScreenCaptureFromPath(screenshotPath);
    }
}


