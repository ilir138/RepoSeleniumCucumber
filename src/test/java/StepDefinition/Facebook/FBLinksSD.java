package StepDefinition.Facebook;

import Drivers.Web;
import Pages.Facebook.LandingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FBLinksSD {
    LandingPage landingPage = new LandingPage();


    @Given("^1. I am on facebook landing page$")
    public void launchFaceBook(){
        Web.initDriver("https://www.facebook.com");
        Web.maximizeWindow();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    @When("^1. I click on Terms link$")
    public void clickTerms(){
        landingPage.clickTerms();

    }
    @Then("^1. I verify user is on 'Terms of Service' page title$")
    public void verifyTermsPageTitle(){
       landingPage.termsTitle();


    }
    @When ("^1. I verify facebook landing page is open$")
    public void verifyFacebookOpen(){
        landingPage.allWindowsOpen();
    }
    @And("^1. I close all facebook window$")
    public void closeAllFBWindows(){
        Web.quitDriver();
    }


    @Given("^2. I am on facebook landing page$")
    public void launchFaceBook2(){
        Web.initDriver("https://www.facebook.com");
        Web.maximizeWindow();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @When("^2. I click on Data Policy link$")
    public void clickDataPolicy(){
        landingPage.clickDataPolicy();
    }
    @Then("^2. I verify user is on 'Data Policy' page title$")
    public void verifyDataPolicy(){
        landingPage.dataPolicy();
    }
    @When("^2. I verify facebook landing page is open$")
    public void verifyFBLandingPageOpen(){
        landingPage.allWindowsOpen();
    }
    @When("^2. I close all facebook window$")
    public void closeAllFBWindows2(){
        Web.quitDriver();
    }


    @Given("^3. I am on facebook landing page$")
    public void launchFaceBook3(){
        Web.initDriver("https://www.facebook.com");
        Web.maximizeWindow();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @When("^3. I click on Cookie Policy link$")
    public void clickCookiesPolicy(){
        landingPage.clickCookiePolicy();
    }
    @Then("^3. I verify user is on 'Cookie Policy' page title$")
    public void verifyCookiesPolicy(){
        landingPage.cookiePolicy();
    }
    @When("^3. I verify facebook landing page is open$")
    public void verifyFBLandingPageIsOpen(){
        landingPage.allWindowsOpen();
    }
    @When("^3. I close all facebook window$")
    public void closeAllFBWindows3(){
        Web.quitDriver();
    }
}
