package Selenium.stepdef;


import Selenium.pages.LoginPage;
import Selenium.pages.TransferPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginStepDef {
    protected static WebDriver driver;

    @Given("user is on login page")
    public void userIsOnLoginPage(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/login");
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String email) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.inputEmailField(email);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputKataSandiField(password);
    }

    @When("user click on login button")
    public void userClickLoginButton() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickMasukButton();
        Thread.sleep(7000);
    }

    @Then("user is on home page")
    public void userIsOnHomePage(){
        TransferPage transferPage = new TransferPage(driver);
        Assert.assertEquals(transferPage.getCurrentURL(),"https://banksatu.fly.dev/portal");
    }

//    @Then("error message is showing up")
//    public void error_message_is_showing_up() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.errorMessageIsDisplayed();
//    }
}
