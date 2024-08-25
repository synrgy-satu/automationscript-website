package Selenium.stepdef;

import Selenium.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class RegisterStepDef {
    public static WebDriver driver;

    @Given("user is on register page")
    public void userIsOnLoginPage(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/register");
    }

    @And("user input information about card")
    public void userInputInformationAboutCard(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputMasaAktifField("1010101010101029", "9", "2030");
    }

    @And("user input information about email and phone number")
    public void userInputInformationAboutEmailAndPhoneNumber(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputEmailNomorTeleponField("admin666@gmail.com", "0851568113599");
    }

    @And("user input information about kata sandi or password")
    public void userInputInformationAboutKataSandiOrPassword(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputKataSandiField("Testing123*", "Testing123*");
    }

    @When("user input information about PIN")
    public void userInputInformationAboutPIN(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.inputPinField("123456", "123456");
    }

    @Then("user success register an account")
    public void userSuccessRegisterAnAccount(){
        driver.quit();
    }
}
