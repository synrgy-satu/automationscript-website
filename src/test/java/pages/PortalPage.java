package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PortalPage {
    WebDriver driver;
    WebDriverWait wait;

    By transaksiSideBar = By.xpath("//*[@class='flex items-center justify-between w-full py-3 px-6 text-base font-normal rounded-lg  hover:font-bold hover:bg-[#272D87] focus:font-bold']");
    By transferButton = By.xpath("(//*[@class='block py-3 px-6 text-base font-normal rounded-lg  hover:font-bold hover:bg-[#272D87] focus:font-bold focus:bg-[#272D87]'])[1]");
    By transferKategoriButton = By.id("transfer-one-heading");
    By transferKeRekeningSatuButton = By.id("transfer-satu-heading");
    By selectSumberRekening = By.id("sumber-rekening");
    By optionSumberRekening = By.xpath("//*[@value='1111111165']");
    By rekeningTujuanField = By.id("tujuan-rekening");
    By nominalTransferField = By.id("nominal-tf");
    By catatanField = By.id("catatan");
    By selectWaktuTransfer = By.id("jenis-transaksi");
    By optionSekarang = By.xpath("//*[@value='sekarang']");
    By verifikasiDetailTransferButton = By.xpath("//*[@type='submit']");

    public PortalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickTransferSideBar(){
        driver.findElement(transaksiSideBar).click();
        driver.findElement(transferButton).click();
    }

    public void clickTransferKategoriButton(){
        driver.findElement(transferKategoriButton).click();
    }

    public void clickTransferKeRekeningSatuButton(){
        driver.findElement(transferKeRekeningSatuButton).click();
    }

    public void inputInformationTransfer(String rekeningtujuan, String nominaltransfer, String catatan){
        driver.findElement(selectSumberRekening).click();
        driver.findElement(optionSumberRekening).click();
        driver.findElement(rekeningTujuanField).sendKeys(rekeningtujuan);
        driver.findElement(nominalTransferField).sendKeys(nominaltransfer);
        driver.findElement(catatanField).sendKeys(catatan);
        driver.findElement(selectWaktuTransfer).click();
        driver.findElement(optionSekarang).click();
        driver.findElement(verifikasiDetailTransferButton).click();
    }

}
