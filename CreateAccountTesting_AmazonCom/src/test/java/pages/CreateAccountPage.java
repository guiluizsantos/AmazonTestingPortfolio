package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {
    WebDriver driver;

    //Mapping elements
    String nameID = "ap_customer_name";
    String emailID = "ap_email";
    String passwordID = "ap_password";
    String checkPasswordID = "ap_password_check";
    String continueBtnID = "continue";
    String mismatchPasswordAlertID = "auth-password-mismatch-alert";
    String invalidPasswordAlertID = "auth-password-invalid-password-alert";
    String invalidCodeError = "//*[@id=\"auth-error-message-box\"]/div/h4";
    String insertNameAlertID = "auth-customerName-missing-alert";
    String missingPasswordAlert = "//*[@id=\"auth-password-missing-alert\"]/div/div";
    String missingEmailAlert = "//*[@id=\"auth-email-missing-alert\"]/div/div";


    public CreateAccountPage(WebDriver driverParameter){
        driver = driverParameter;
    }

    public void insertName(String name){
        driver.findElement(By.id(nameID)).sendKeys(name);
    }

    public void insertEmail(String email){
        driver.findElement(By.id(emailID)).sendKeys(email);
    }

    public void insertPassword(String password){
        driver.findElement(By.id(passwordID)).sendKeys(password);
    }

    public void confirmPassword(String password){
        driver.findElement(By.id(checkPasswordID)).sendKeys(password);
    }

    public void clickContinueBtn(){
        driver.findElement(By.id(continueBtnID)).click();
    }

    public void checkMismatchAlertPassword(){
        Assert.assertTrue("Mismatch Password message is not being displaying",driver.findElement(By.id(mismatchPasswordAlertID)).isDisplayed());
    }

    public void insertInvalidPassword(){
        Assert.assertTrue("Invalid Password message is not being displaying",driver.findElement(By.id(invalidPasswordAlertID)).isDisplayed());

    }

    public void checkInvalidCodeError(){
        Assert.assertTrue("Invalid Code Alert was not displayed", driver.findElement(By.xpath(invalidCodeError)).isDisplayed());
    }

    public void checkInsertNameAlert(){
        Assert.assertTrue("Insert Name Alert was not displayed", driver.findElement(By.id(insertNameAlertID)).isDisplayed());
    }

    public void checkMissingPassword(){
        Assert.assertTrue("Missing Password Alert is not being displayed", driver.findElement(By.xpath(missingPasswordAlert)).isDisplayed());
    }

    public void checkingMissingEmailAlert(){
        Assert.assertTrue("Missing Email Alert is not being displayed",driver.findElement(By.xpath(missingEmailAlert)).isDisplayed());
    }



}
