package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage {
    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    @FindBy(id = "userSelect")
    WebElement userDropdown;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
    WebElement depositInput;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    WebElement confirmDepositButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement confirmationMessage;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCustomerLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(customerLoginButton));
        customerLoginButton.click();
    }

    public void selectUser(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(userDropdown));
        userDropdown.sendKeys(userName);
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void clickDeposit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(depositButton));
        depositButton.click();
    }

    public void enterDepositAmount(String amount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(depositInput));
        depositInput.sendKeys(amount);
    }


    public void confirmDeposit() {
        confirmDepositButton.click();
    }

    public String getDepositConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.getText();
    }
}

