package testcase.authentication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import pages.PortalPage;

public class TransferPositiveTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/");
    }

    @Test
    public void transferTest() throws InterruptedException {
        PortalPage portalPage = new PortalPage(driver);
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
        loginPage.inputEmailField("zhanuardy@upi.edu");
        loginPage.inputKataSandiField("Zhanuardy3222*");
        loginPage.clickMasukButton();
        Thread.sleep(7000); // Pengecualian dapat terjadi di sini

        //Assertion : cek Current URL apakah sudah sesuai dengan URL Portal Page
        Assert.assertEquals(portalPage.getCurrentURL(),"https://banksatu.fly.dev/portal");

        //Element action
        portalPage.clickTransferSideBar();
        portalPage.clickTransferKategoriButton();
        portalPage.clickTransferKeRekeningSatuButton();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
