package Pages;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    WebElement bankManagerLoginBtn;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[1]/button")
    WebElement customerLoginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBankManagerLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bankManagerLoginBtn)).click();
    }

    public void clickCustomerLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(customerLoginBtn)).click();
    }
}



