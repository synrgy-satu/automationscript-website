package Selenium.testcase.mutation;

import Selenium.pages.LandingPage;
import Selenium.pages.LoginPage;
import Selenium.pages.MutationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MutationPositiveTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/");
    }

    @Test
    public void mutationTest() throws InterruptedException {
        MutationPage mutationPage = new MutationPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //Assertion
        Assert.assertEquals(landingPage.getCurrentURL(),"https://banksatu.fly.dev/");

        //Assertion
        landingPage.buttonIsDisplayed();

        //Element action
        landingPage.clickMasukButton();

        //Assertion
        Assert.assertEquals(loginPage.getCurrentURL(),"https://banksatu.fly.dev/login");

        //Assertion
        loginPage.inputFormIsDisplayed();

        //Element action
        loginPage.inputEmailField("gilangzhanuardy3222@gmail.com");
        loginPage.inputKataSandiField("Testing123*");
        loginPage.clickMasukButton();

        //Assertion
        Assert.assertEquals(mutationPage.getCurrentURL(),"https://banksatu.fly.dev/portal");

        //Element action
        mutationPage.clickMutationSideBar();
        mutationPage.inputInformationMutation();
        mutationPage.mutationRekeningIsDisplayed();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
