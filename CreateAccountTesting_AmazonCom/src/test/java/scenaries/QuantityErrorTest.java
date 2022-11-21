package scenaries;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ErrorPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

import java.time.Duration;

public class QuantityErrorTest {

    WebDriver driver;
    HomePage homePage;
    ErrorPage errorPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver); //enviando o driver para a Classe HomePage, a fim de usar o mesmo driver
        searchResultsPage = new SearchResultsPage(driver);
        errorPage = new ErrorPage(driver);
        productPage = new ProductPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.br");
    }

    @Test
    public void testQuantityErrorMoreThanFiveItens(){
        String item = "echo dot";
        String name = "Echo Dot (4ª Geração): Smart Speaker com Alexa | Música, informação e Casa Inteligente - Cor Preta";
        homePage.writeOnSearchBar(item);
        homePage.clickSeachButton();
        searchResultsPage.selectItem(name);
        productPage.checkSafeTransaction();
        productPage.insertDeliveryZipCode("09371","470");
        productPage.checkingZipCode("09371470");
        productPage.checkingStock();
        productPage.selectQuantity("2");
        productPage.selectGift();
        productPage.checkingGiftEnabled();
        productPage.checkingWarningMsg();
        productPage.addCart();
        productPage.pressNoThanksButton();
        driver.navigate().back();
        productPage.addCart();
        productPage.pressNoThanksButton();
        errorPage.checkingErrorMsg();
        errorPage.checkingImportantMsg();
    }

    @After
    public void testfinish() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
