package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

public class RegisterSteps {

    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    CreateAccountPage createAccountPage;
    ErrorUserNameAlreadyExistPage errorUserNameAlreadyExistPage;
    VerifyEmailPage verifyEmailPage;

    @Before
    public void before(){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        errorUserNameAlreadyExistPage = new ErrorUserNameAlreadyExistPage(driver);
        verifyEmailPage = new VerifyEmailPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    @Given("that I open the Amazon Website: {string}")
    public void thatIOpenTheAmazonWebsite(String url) {
        driver.get(url);
    }

    @When("click on the Register Btn")
    public void clickOnTheRegisterBtn() {
        homePage.clickCreatingAccountButton();
    }

    @And("click on the Create An Account")
    public void clickOnTheCreateAnAccount() {
        logInPage.clickCreateAccountBtn();
    }

    @And("Fill the Name with {string}")
    public void fillTheNameWith(String name) {
        createAccountPage.insertName(name);
    }

    @And("Fill the Email {string}")
    public void fillTheEmail(String email) {
        createAccountPage.insertEmail(email);
    }

    @And("Fill the Password with {string}")
    public void fillThePasswordWith(String password) {
        createAccountPage.insertPassword(password);
    }

    @And("Confirm the password with {string}")
    public void confirmThePasswordWith(String password) {
        createAccountPage.confirmPassword(password);
    }

    @And("click on  Continue")
    public void clickOnContinue() {
        createAccountPage.clickContinueBtn();
    }


    @Then("an error message must be displayed informing about the Email {string} already used")
    public void anErrorMessageMustBeDisplayedInformingAboutTheEmailAlreadyUsed(String email) {
        errorUserNameAlreadyExistPage.checkTextMsg(email);
    }
}
