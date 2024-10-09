package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


import java.time.Duration;

public class ManagerPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    WebElement addCustomerButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    WebElement openAccountButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[3]")
    WebElement customersButton;

    public ManagerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Klik na Add Customer dugme
    public void clickAddCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton));
        addCustomerButton.click();
    }

    // Dodavanje novog korisnika sa potrebnim poljima
    public void addCustomer(String firstName, String lastName, String postCode) {
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
        lastNameField.sendKeys(lastName);
        WebElement postCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Post Code']")));
        postCodeField.sendKeys(postCode);
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Customer']")));
        addButton.click();
    }

    // Klik na Open Account dugme
    public void clickOpenAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccountButton));
        openAccountButton.click();
    }

    // Klik na Customers dugme
    public void clickCustomers() {
        wait.until(ExpectedConditions.elementToBeClickable(customersButton));
        customersButton.click();
    }
}

