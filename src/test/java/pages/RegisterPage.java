package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    By inputForm = By.xpath("//*[@class='flex flex-col w-[100%] justify-center items-center font-base font-normal ']");

    public RegisterPage(WebDriver driver) {
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
}
