package testcase.authentication;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.RegisterPage;

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

        //Assertion : cek Current URL apakah sudah sesuai dengan URL Landing Page
        Assert.assertEquals(landingPage.getCurrentURL(),"https://banksatu.fly.dev/");

        //Assertion : cek apakah Field username, password, dan Button login telah muncul
        landingPage.buttonIsDisplayed();

        //Element action
        landingPage.clickMendaftarButton();

        //Assertion : cek current URL apakah sudah berpindah halaman sehingga sesuai dengan URL Home Page
        Assert.assertEquals(registerPage.getCurrentURL(),"https://banksatu.fly.dev/register");

        //Assertion : cek Title apakah sudah sesuai dengan Title Home Page
        registerPage.inputFormIsDisplayed();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
