package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyEmailPage {
    WebDriver driver;

    VerifyEmailPage verifyEmailPage;

    //Mapping Elements
    String verificationCodeID = "cvf-input-code";
    String createAccountBtn = "cvf-submit-otp-button";


    public VerifyEmailPage(WebDriver driverParameter){
        driver = driverParameter;
    }

    public void insertVerificationCode(String code){
        driver.findElement(By.id(verificationCodeID)).sendKeys(code);
    }

    public void clickCreateAccountBtn(){
        driver.findElement(By.id(createAccountBtn)).click();
    }




}
