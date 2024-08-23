package Selenium.testcase.qris;

import Selenium.pages.LandingPage;
import Selenium.pages.LoginPage;
import Selenium.pages.MutationPage;
import Selenium.pages.QRISPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QRISPositiveTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/");
    }

    @Test
    public void qrisTest() throws InterruptedException {
        QRISPage qrisPage = new QRISPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        LoginPage loginPage = new LoginPage(driver);

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

        //Assertion : cek Current URL apakah sudah sesuai dengan URL Portal Page
        Assert.assertEquals(qrisPage.getCurrentURL(),"https://banksatu.fly.dev/portal");

        //Element action
        qrisPage.clickQrisSideBar();
        qrisPage.inputInformationQris();
        qrisPage.qrisIsDisplayed();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
