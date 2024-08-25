package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By inputForm = By.xpath("//*[@class='w-[360px] max-w-sm bg-white border border-gray-200 rounded-3xl shadow py-8 px-5']");
    By emailField = By.id("email");
    By kataSandiField = By.id("password");
    By masukButton = By.xpath("(//*[@class='flex justify-center'])[2]");
    By portalText = By.xpath("(//*[@class='text-xs font-semibold'])[1]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void inputFormIsDisplayed(){
        driver.findElement(inputForm).isDisplayed();
    }

    public void inputEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputKataSandiField(String katasandi){
        driver.findElement(kataSandiField).sendKeys(katasandi);
    }

    public void clickMasukButton(){
        driver.findElement(masukButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(portalText));
    }
}
