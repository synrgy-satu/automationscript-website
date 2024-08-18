package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabunganPage {
    WebDriver driver;
    WebDriverWait wait;

    By tabunganSideBar = By.xpath("(//*[@class='mr-4 text-2xl'])[3]");
    By saldoAkhir = By.xpath("//*[@class='bg-white rounded-xl p-5 font-bold']");
    By informasiTabungan = By.xpath("//*[@class='ps-5 py-5 pe-1 bg-white rounded-xl']");

    public TabunganPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickTabunganSideBar() {
        driver.findElement(tabunganSideBar).click();
    }

    public void saldoAkhirIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(saldoAkhir).isDisplayed();
    }

    public void informasiTabunganIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(informasiTabungan).isDisplayed();
    }
}
