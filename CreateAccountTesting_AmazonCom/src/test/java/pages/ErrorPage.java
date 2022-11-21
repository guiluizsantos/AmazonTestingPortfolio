package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorPage {
    WebDriver driver;
    String errorMsg = "//*[@id=\"NATC_SMART_WAGON_CONF_MSG_FAILURE\"]/span";
    String expanderButton = "//*[@id=\"sc-important-message-alert\"]/div/div/div/div/a/span";
    String importantMsg = "//*[@id=\"sc-important-message-alert\"]/div/div/div/div/div/p/span";

    public ErrorPage(WebDriver driverParameter){
        this.driver = driverParameter;
    }

    public void checkingErrorMsg(){
        String msg = driver.findElement(By.xpath(errorMsg)).getText();
        Assert.assertTrue("Error message is not displayed",msg.contains("Ocorreu um problema"));
    }

    public void checkingImportantMsg(){
        driver.findElement(By.xpath(expanderButton)).click();
        String msg = driver.findElement(By.xpath(importantMsg)).getText();
        Assert.assertTrue("Wrong message",msg.contains("tem um limite de compra de 5 unidades por cliente"));
        Assert.assertTrue("Wrong message",msg.contains("para 5"));
    }

}
