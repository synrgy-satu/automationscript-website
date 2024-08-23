package Selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MutationPage {
    WebDriver driver;
    WebDriverWait wait;

    By transaksiSideBar = By.xpath("(//*[@class='flex items-center'])[1]");
    By mutationRekeningSideBar = By.xpath("(//*[@class='block py-3 px-6 text-base font-normal rounded-lg  hover:font-bold hover:bg-[#272D87] focus:font-bold focus:bg-[#272D87]'])[4]");
    By selectSumberRekening = By.id("sumber-rekening");
    By optionSumberRekening = By.xpath("//*[@value='1010101010101025']");
    By selectPeriodeMutation = By.id("periode-mutasi");
    By optionPeriodeMutation = By.xpath("//*[@value='Agustus 2024']");
    By selectJenisTransaksi = By.id("jenis-transaksi");
    By optionJenisTransaksi = By.xpath("//*[@value='SEMUA']");
    By lihatMutasiRekening = By.xpath("//*[@type='submit']");
    By mutationRekeningPageIsDisplayed = By.xpath("//*[@class='bg-white p-10 rounded-xl shadow-md  mx-auto mt-10']");

    public MutationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickMutationSideBar(){
        driver.findElement(transaksiSideBar).click();
        driver.findElement(mutationRekeningSideBar).click();
    }

    public void inputInformationMutation() throws InterruptedException {
        driver.findElement(selectSumberRekening).click();
        driver.findElement(optionSumberRekening).click();
        driver.findElement(selectPeriodeMutation).click();
        driver.findElement(optionPeriodeMutation).click();
        driver.findElement(selectJenisTransaksi).click();
        driver.findElement(optionJenisTransaksi).click();
        driver.findElement(lihatMutasiRekening).click();
        Thread.sleep(500);
    }

    public void mutationRekeningIsDisplayed() {
        driver.findElement(mutationRekeningPageIsDisplayed).isDisplayed();
    }
}
