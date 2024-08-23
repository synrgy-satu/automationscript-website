package Selenium.stepdef;

import Selenium.pages.MutationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MutationStepDef {

    @And("user click on transaksi mutasi rekening sidebar button")
    public void userClickTransaksiMutationRekeningSidebarButton() {
        MutationPage mutationPage =  new MutationPage(LoginStepDef.driver);
        mutationPage.clickMutationSideBar();
    }

    @When("user input information mutation")
    public void userInputInformationMutation() throws InterruptedException {
        MutationPage mutationPage =  new MutationPage(LoginStepDef.driver);
        mutationPage.inputInformationMutation();
    }

    @Then("user can see the mutation")
    public void userCanSeeTheMutation() {
        MutationPage mutationPage =  new MutationPage(LoginStepDef.driver);
        mutationPage.mutationRekeningIsDisplayed();
        LoginStepDef.driver.quit();
    }
}
