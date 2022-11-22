package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driverParameter){
        this.driver = driverParameter;
    }
    public void selectItem(String name){
        driver.findElement(By.linkText(name)).click();
    }

}
