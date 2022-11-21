package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    WebDriver driver;

    String createAccountBtnID = "//*[@id=\"createAccountSubmit\"]";

    public LogInPage(WebDriver driverParameter){
        driver = driverParameter;
    }

    public void clickCreateAccountBtn(){
        driver.findElement(By.xpath(createAccountBtnID)).click();
    }
}
