package StepDefinition.Facebook;

import Drivers.Web;
import Pages.Facebook.IncorrectLoginPage;
import Pages.Facebook.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class LoginSD {
    LandingPage landingPage = new LandingPage();
    IncorrectLoginPage incorrectLoginPage = new IncorrectLoginPage();

    //glue code
    @Given("^I am on facebook landing page$") //<- regular expression
    public void launchFacebook() {
        Web.initDriver("https://www.facebook.com");
    }

    @When("^I enter '(.*)' as username$") // I enter '0 or something random' as username
    public void enterLoginUserEmail(String email) {
        landingPage.enterLoginEmail(email);
    }

    @When("^I enter '(.*)' as password$")
    public void enterLoginUserPassword(String password) {
        landingPage.enterLoginPassword(password);
    }

    @When("^I click on (login|signup) button$") // <- I click on <either login or signup> button
    public void clickButton(String buttonName) {
        switch(buttonName.toLowerCase()) {
            case "login":
                landingPage.clickLoginButton();
                break;
            case "signup":
                // landingPage.clickSignUpButton();
                break;
            default:
                new Exception("Invalid button name: " + buttonName);
        }
    }

    @Then("^I get invalid credentials error message$")
    public void verifyErrorMessage() {
        String actualError = incorrectLoginPage.getErrorMsg();
        String expectedError = "";
        Assert.assertEquals(actualError, expectedError, "Invalid credentials Error msg is not as expected");
    }

}
