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
    public static WebDriver driver;

    @Given("user is on login page")
    public void userIsOnLoginPage(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/login");
    }

    @And("user input email with {string}")
    public void userInputEmailWith(String email) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
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
    }

    @Then("user is on home page")
    public void userIsOnHomePage(){
        TransferPage transferPage = new TransferPage(driver);
        Assert.assertEquals(transferPage.getCurrentURL(),"https://banksatu.fly.dev/portal");
        LoginStepDef.driver.quit();
    }
}
