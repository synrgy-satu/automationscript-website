package testcase.authentication;

import Selenium.pages.LandingPage;
import Selenium.pages.LoginPage;
import Selenium.pages.TransferPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPositiveTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/");
    }

    @Test
    public void loginTest() throws InterruptedException{
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        TransferPage transferPage = new TransferPage(driver);

        //Assertion : cek Current URL apakah sudah sesuai dengan URL Landing Page
        Assert.assertEquals(landingPage.getCurrentURL(),"https://banksatu.fly.dev/");

        //Assertion : cek apakah Field username, password, dan Button login telah muncul
        landingPage.buttonIsDisplayed();

        //Element action
        landingPage.clickMasukButton();

        //Assertion : cek current URL apakah sudah berpindah halaman sehingga sesuai dengan URL Home Page
        Assert.assertEquals(loginPage.getCurrentURL(),"https://banksatu.fly.dev/login");

        //Assertion : cek Title apakah input form muncul
        loginPage.inputFormIsDisplayed();

        //Element action
        loginPage.inputEmailField("gilangzhanuardy3222@gmail.com");
        loginPage.inputKataSandiField("Testing123*");
        loginPage.clickMasukButton();
        Thread.sleep(7000); // Pengecualian dapat terjadi di sini

        //Assertion : cek current URL apakah sudah berpindah halaman
        Assert.assertEquals(transferPage.getCurrentURL(),"https://banksatu.fly.dev/portal");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
