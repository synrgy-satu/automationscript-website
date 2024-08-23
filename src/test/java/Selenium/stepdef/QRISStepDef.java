package Selenium.stepdef;

import Selenium.pages.QRISPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QRISStepDef {
    @And("user click on satu portal qris sidebar button")
    public void user_click_satu_portal_qris_sidebar_button() {
        QRISPage qrisPage = new QRISPage(LoginStepDef.driver);
        qrisPage.clickQrisSideBar();
    }

    @When("user input information qris")
    public void user_input_information_qris() {
        QRISPage qrisPage = new QRISPage(LoginStepDef.driver);
        qrisPage.inputInformationQris();
    }

    @Then("user can see the qris")
    public void user_can_see_the_qris() {
        QRISPage qrisPage = new QRISPage(LoginStepDef.driver);
        qrisPage.qrisIsDisplayed();
    }
}
