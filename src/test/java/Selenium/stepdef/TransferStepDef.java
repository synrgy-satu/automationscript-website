package Selenium.stepdef;

import Selenium.pages.TabunganPage;
import Selenium.pages.TransferPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TransferStepDef {
    protected static WebDriver driver;

    @And("user click on transfer sidebar button")
    public void userClickTransaksiSidebarButton() {
        TransferPage transferPage =  new TransferPage(LoginStepDef.driver);
        transferPage.clickTransferSideBar();
    }

    @And("user click on transfer button")
    public void userClickTransferButton() {
        TransferPage transferPage =  new TransferPage(LoginStepDef.driver);
        transferPage.clickTransferKategoriButton();
    }

    @When("user click on transfer to satu button")
    public void userClickTransferToSatuButton() {
        TransferPage transferPage =  new TransferPage(LoginStepDef.driver);
        transferPage.clickTransferKeRekeningSatuButton();
    }

    @Then("user input information transfer")
    public void userInputInformationTransfer() throws InterruptedException {
        TransferPage transferPage =  new TransferPage(LoginStepDef.driver);
        transferPage.inputInformationTransfer("1111111155", "10000", "automation testing", "123456");
    }
}
