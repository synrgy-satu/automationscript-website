package testcase.authentication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.PortalPage;
import pages.RegisterPage;

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
        PortalPage portalPage = new PortalPage(driver);

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
        loginPage.inputEmailField("zhanuardy@upi.edu");
        loginPage.inputKataSandiField("Zhanuardy3222*");
        loginPage.clickMasukButton();
        Thread.sleep(5000); // Pengecualian dapat terjadi di sini

        //Assertion : cek current URL apakah sudah berpindah halaman
        Assert.assertEquals(portalPage.getCurrentURL(),"https://banksatu.fly.dev/portal");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
