package Selenium.stepdef;

import Selenium.pages.TabunganPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class InfoSaldoStepDef {

    @When("user click tabungan page on sidebar")
    public void userClickTabunganPageButton(){
        TabunganPage tabunganPage =  new TabunganPage(LoginStepDef.driver);
        tabunganPage.clickTabunganSideBar();
    }

    @Then("user is on tabungan page")
    public void userIsOnTabunganPage(){
        TabunganPage tabunganPage =  new TabunganPage(LoginStepDef.driver);
        Assert.assertEquals(tabunganPage.getCurrentURL(),"https://banksatu.fly.dev/portal/savings");
        LoginStepDef.driver.quit();
    }
}