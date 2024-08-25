package Selenium.testcase.authentication;

import Selenium.pages.LandingPage;
import Selenium.pages.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPositiveTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://banksatu.fly.dev/");
    }

    @Test
    public void registerTest(){
        LandingPage landingPage = new LandingPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        //Assertion
        Assert.assertEquals(landingPage.getCurrentURL(),"https://banksatu.fly.dev/");

        //Assertion
        landingPage.buttonIsDisplayed();

        //Element action
        landingPage.clickMendaftarButton();

        //Assertion
        Assert.assertEquals(registerPage.getCurrentURL(),"https://banksatu.fly.dev/register");

        //Assertion
        registerPage.inputFormIsDisplayed();

        //Element action
        registerPage.inputMasaAktifField("1010101010101020", "9", "2030");

        //Assertion
        Assert.assertEquals(registerPage.getInstructionEmailText(),"Masukkan alamat email dan nomor telepon untuk membuat akun Digibank SATU");

        //Element action
        registerPage.inputEmailNomorTeleponField("admin333@gmail.com", "0851568113577");

        //Assertion
        Assert.assertEquals(registerPage.getInstructionKataSandiText(),"Atur sandi akun untuk masuk ke dalam Digibank SATU");

        //Element action
        registerPage.inputKataSandiField("Testing123*", "Testing123*");

        //Assertion
        Assert.assertEquals(registerPage.getInstructionPinText(),"Atur PIN M-Banking untuk bertransaksi di dalam Digibank SATU");

        //Element action
        registerPage.inputPinField("123456", "123456");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
