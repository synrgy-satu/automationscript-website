package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    WebDriver driver;
    WebDriverWait wait;

    By masukButton = By.xpath("//*[@aria-label='Login']");
    By mendaftarButton = By.xpath("//*[@aria-label='Register']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void buttonIsDisplayed(){
        driver.findElement(masukButton).isDisplayed();
        driver.findElement(mendaftarButton).isDisplayed();
    }

    public void clickMasukButton() {
        driver.findElement(masukButton).click();
    }

    public void clickMendaftarButton() {
        driver.findElement(mendaftarButton).click();
    }
}
