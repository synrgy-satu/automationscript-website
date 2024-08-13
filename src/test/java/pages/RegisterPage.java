package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    By inputForm = By.xpath("//*[@class='flex flex-col w-[100%] justify-center items-center font-base font-normal ']");
    By nomorKartuField = By.id("numberCard");
    By bulanMasaAktifField = By.id("activeCardMonth");
    By tahunMasaAktifField = By.id("activeCardYear");
    By checkbox = By.id("checkbox");
    By nextButton = By.xpath("//*[@class='w-[85%] h-[48px] bg-[#333999] hover:bg-[#212674] transition duration-300 mt-10 flex justify-center items-center text-white rounded-lg']");
    By next2Button = By.xpath("//*[@class='w-[100%] h-[48px] bg-[#333999] hover:bg-[#212674] transition duration-300 mt-10 mb-5 flex justify-center items-center text-white rounded-lg']");
    By emailField = By.id("email");
    By nomorTeleponField = By.id("numberTelp");
    By next3Button = By.xpath("//*[@class='w-[85%] h-[48px] bg-[#333999] hover:bg-[#212674] transition duration-300 mt-10 mb-10 flex justify-center items-center text-white rounded-lg']");
    By instructionEmailText = By.xpath("//*[@class='font-semibold text-sm text-[#808080] mb-4']");
    By instructionKataSandiText = By.xpath("//*[@class='font-semibold text-sm text-[#808080] mb-4 text-center']");
    By kataSandiField = By.id("password");
    By konfKataSandiField = By.id("confPassword");
    By next4Button = By.xpath("//*[@class='w-[85%] h-[48px] bg-[#333999] hover:bg-[#212674] transition duration-300 mt-10 mb-10 flex justify-center items-center text-white rounded-lg']");
    By instructionPinText = By.xpath("//*[@class='font-semibold text-sm text-[#808080] mb-4']");
    By pinField = By.id("pin");
    By konfPinField = By.xpath("//*[@placeholder='Konfirmasi PIN']");
    By next5Button = By.xpath("//*[@class='w-[85%] h-[48px] bg-[#333999] hover:bg-[#212674] transition duration-300 mt-10 mb-10 flex justify-center items-center text-white rounded-lg']");

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

    public void inputMasaAktifField(String nomorkartu, String bulan, String tahun){
        driver.findElement(nomorKartuField).sendKeys(nomorkartu);
        driver.findElement(bulanMasaAktifField).sendKeys(bulan);
        driver.findElement(tahunMasaAktifField).sendKeys(tahun);
        driver.findElement(checkbox).click();
        driver.findElement(nextButton).click();
        driver.findElement(next2Button).click();
    }

    public void inputEmailNomorTeleponField(String email, String nomortelepon){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nomorTeleponField).sendKeys(nomortelepon);
        driver.findElement(next3Button).click();
    }

    public void inputKataSandiField(String katasandi, String konfkatasandi){
        driver.findElement(kataSandiField).sendKeys(katasandi);
        driver.findElement(konfKataSandiField).sendKeys(konfkatasandi);
        driver.findElement(next4Button).click();
    }

    public void inputPinField(String pin, String konfpin){
        driver.findElement(pinField).sendKeys(pin);
        driver.findElement(konfPinField).sendKeys(konfpin);
        driver.findElement(next5Button).click();
    }

    public String getInstructionEmailText(){
        return driver.findElement(instructionEmailText).getText();
    }

    public String getInstructionKataSandiText(){
        return driver.findElement(instructionKataSandiText).getText();
    }

    public String getInstructionPinText(){
        return driver.findElement(instructionPinText).getText();
    }
}
