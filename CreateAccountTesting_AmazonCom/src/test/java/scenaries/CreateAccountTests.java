package scenaries;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

public class CreateAccountTests {
    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    CreateAccountPage createAccountPage;
    ErrorUserNameAlreadyExistPage errorUserNameAlreadyExistPage;
    VerifyEmailPage verifyEmailPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        errorUserNameAlreadyExistPage = new ErrorUserNameAlreadyExistPage(driver);
        verifyEmailPage = new VerifyEmailPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.br");
        homePage.clickCreatingAccountButton();
        logInPage.clickCreateAccountBtn();
    }

    @Test
    public void emailExistingTest() {

        createAccountPage.insertName("Guilherme Silva");
        createAccountPage.insertEmail("gui@hotmail.com");
        createAccountPage.insertPassword("123456Abc");
        createAccountPage.confirmPassword("123456Abc");
        createAccountPage.clickContinueBtn();
        errorUserNameAlreadyExistPage.checkHeadline();
        errorUserNameAlreadyExistPage.checkTextMsg("gui@hotmail.com");
    }

    @Test
    public void insertDifferentPasswordTest(){

        createAccountPage.insertName("Guilherme Silva");
        createAccountPage.insertEmail("gui@fre.com");
        createAccountPage.insertPassword("123456Abc");
        createAccountPage.confirmPassword("123456Atb");
        createAccountPage.clickContinueBtn();
        createAccountPage.checkMismatchAlertPassword();
    }

    @Test
    public void insertLessThanSixCharPasswordTest(){

        createAccountPage.insertName("Guilherme Silva");
        createAccountPage.insertEmail("gui@fre.com");
        createAccountPage.insertPassword("12345");
        createAccountPage.confirmPassword("12345");
        createAccountPage.clickContinueBtn();
        createAccountPage.insertInvalidPassword();
    }

    @Test
    public void verifyEmailTest(){

        createAccountPage.insertName("Guilherme Silva");
        createAccountPage.insertEmail("gui123@fre.com");
        createAccountPage.insertPassword("123456");
        createAccountPage.confirmPassword("123456");
        createAccountPage.clickContinueBtn();
        verifyEmailPage.insertVerificationCode("123456");
        verifyEmailPage.clickCreateAccountBtn();
        createAccountPage.checkInvalidCodeError();
    }

    @Test
    public void emptyFormTest(){
        createAccountPage.clickContinueBtn();
        createAccountPage.checkInsertNameAlert();
        createAccountPage.checkMissingPassword();
        createAccountPage.checkingMissingEmailAlert();
    }

    @After
    public void testFinish() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}