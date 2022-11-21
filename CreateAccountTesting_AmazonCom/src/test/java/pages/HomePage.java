package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    //Mappping elements
    String searchBarID = "twotabsearchtextbox";
    String searchButtonID = "nav-search-submit-button";
    String logInCreateAccountID = "nav-link-accountList-nav-line-1";



    public  HomePage(WebDriver driverParameter){
        this.driver = driverParameter;
    }

    public void writeOnSearchBar(String item){
        driver.findElement(By.id(searchBarID)).sendKeys(item);
    }

    public void clickSeachButton(){
        driver.findElement(By.id(searchButtonID)).click();
    }

    public void clickCreatingAccountButton(){
        driver.findElement(By.id(logInCreateAccountID)).click();
    }


}
