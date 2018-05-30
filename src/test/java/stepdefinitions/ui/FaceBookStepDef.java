package stepdefinitions.ui;

import com.demo.page.Facebook;
import cucumber.api.java.en.Then;
import stepdefinitions.common.Hook;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class FaceBookStepDef {
    private static Logger LOGGER = Logger.getLogger(FaceBookStepDef.class);
    Facebook facebook = new Facebook(Hook.driver);

    @When("^user open facebook url$")
    public void openFB(){
        facebook.open();
    }

    @When("^user enters emailId$")
    public void enterEmail(){
        facebook.setEmailBox();
    }

    @When("^user enters password$")
    public void enterPass(){
        facebook.setPassBox();
    }

    @Then("^user click sign-in button and able to sign-in$")
    public void clickLogin(){
        facebook.login();
    }

    @Then("^check title$")
    public void checkTitle(){
        facebook.checkTitle();
    }
}
