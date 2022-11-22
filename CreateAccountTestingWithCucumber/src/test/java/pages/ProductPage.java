package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;
    String safeTransactionMsg = "//span[contains(text(),'Transação segura')]";
    String sendToID = "contextualIngressPtLabel_deliveryShortLine";
    String zipCodeFirstDigits = "GLUXZipUpdateInput_0";
    String zipCodeLastDigits = "GLUXZipUpdateInput_1";
    String zipCodeConfirm = "GLUXZipUpdate";
    String zipCodeFilled = "//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]/span[2]";
    String stockMsg = "//*[@id=\"availability\"]/span";
    String quantityID = "quantity";
    String giftID = "gift-wrap";
    String warningCheckMsg = "//*[@id=\"preregistrationGiftingAlert\"]/div/div";
    String addCartID = "add-to-cart-button";
    String noThanksButton = "//*[@id=\"abb-intl-pop-cta\"]/span[3]/span/input";


    public ProductPage(WebDriver driverParameter){
        this.driver = driverParameter;
    }

    public void checkSafeTransaction(){
        String safeTransaction = driver.findElement(By.xpath(safeTransactionMsg)).getText();
        Assert.assertEquals("Transacao nao Segura","Transação segura", safeTransaction);
    }

    public void insertDeliveryZipCode(String zipCodeFirst, String zipCodeFinal){
        driver.findElement(By.id(sendToID)).click();
        driver.findElement(By.id(zipCodeFirstDigits)).sendKeys(zipCodeFirst);
        driver.findElement(By.id(zipCodeLastDigits)).sendKeys(zipCodeFinal);
        driver.findElement(By.id(zipCodeConfirm)).click();
    }

    public void checkingZipCode(String zipCode){
        String enviarPara = driver.findElement(By.xpath(zipCodeFilled)).getText();
        Assert.assertTrue("CEP nao foi enviado corretamente",enviarPara.contains(zipCode));
    }

    public void checkingStock(){
        boolean stock = driver.findElement(By.xpath(stockMsg)).getText().contains("Em estoque");
        Assert.assertTrue("Out of Stock", stock);
    }

    public void selectQuantity(String quantity){
        Select quantityList = new Select(driver.findElement(By.id(quantityID)));
        quantityList.selectByVisibleText(quantity);
    }

    public void selectGift(){
        driver.findElement(By.id(giftID)).click();
    }

    public void checkingGiftEnabled(){
        Assert.assertTrue("Presente nao selecionado",driver.findElement(By.id(giftID)).isEnabled());
    }

    public void checkingWarningMsg(){
        String msgPresenteSelecionado = driver.findElement(By.xpath(warningCheckMsg)).getText();
        Assert.assertTrue("Aviso de desvinculação de do dispositivo a conta amazon nao aparece",msgPresenteSelecionado.contains(" ele não será vinculado à sua conta"));
    }

    public void addCart(){
        driver.findElement(By.id(addCartID)).click();
    }

    public void pressNoThanksButton(){
        driver.findElement(By.xpath(noThanksButton)).click();
    }

}
