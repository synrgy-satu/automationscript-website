package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QRISPage {
    WebDriver driver;
    WebDriverWait wait;

    By satuPortalSideBar = By.xpath("(//*[@class='flex items-center'])[2]");
    By qrisSideBar = By.xpath("//*[@class='block py-3 px-6 text-base font-normal rounded-lg  hover:font-bold hover:bg-[#272D87] focus:font-bold focus:bg-[#272D87]']");
    By selectQris = By.xpath("//*[@class='block w-full px-8 h-[48px] border border-[#333999] rounded-lg text-[#808080] focus:outline-none focus:ring-1 focus:border-[#272D87] appearance-none']");
    By optionQris = By.xpath("//*[@value='b8f1fe59-a381-410f-b3f9-d2a5fde23e9c']");
    By qrisIsDisplayed = By.xpath("//*[@alt='Selected QRIS']");

    public QRISPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickQrisSideBar(){
        driver.findElement(satuPortalSideBar).click();
        driver.findElement(qrisSideBar).click();
    }

    public void inputInformationQris(){
        driver.findElement(selectQris).click();
        driver.findElement(optionQris).click();
    }

    public void qrisIsDisplayed() {
        driver.findElement(qrisIsDisplayed).isDisplayed();
    }
}
