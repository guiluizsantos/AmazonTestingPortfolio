package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorUserNameAlreadyExistPage {

    WebDriver driver;
    String errorHeadMsg = "//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/div/div/h4";
    String firstPartMsg = "//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/div/div/div";
    String emailMsg ="//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/div/div/div/p/b";
    String secondPartMsg = "//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/div/div/div/p/text()[2]";


    public ErrorUserNameAlreadyExistPage(WebDriver driverParameter){
        driver = driverParameter;
    }

    public void checkHeadline(){
        String headMsg = driver.findElement(By.xpath(errorHeadMsg)).getText();
        Assert.assertTrue("Head doesnt match",headMsg.contains("O endereço de e-mail já está sendo utilizado"));
    }

    public void checkTextMsg(String e_mail){
        String textMsg = driver.findElement(By.xpath(firstPartMsg)).getText();
        String msgExpected = "Você indicou que é um cliente novo, mas já existe uma conta com o e-mail " + e_mail + ". Se já tem conta em algum site da Amazon, pode usar a mesma conta e senha para fazer o login na amazon.com.br.";
        Assert.assertEquals("Message doesnt match",msgExpected,textMsg);
   }
}
