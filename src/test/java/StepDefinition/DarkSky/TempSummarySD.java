package StepDefinition.DarkSky;

import Drivers.Web;
import Pages.DarkSky.LandingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Arrays;

public class TempSummarySD {
    LandingPage landingPage = new LandingPage();
    int[] lowToHighTemp;
    @Given("^I am on Darksky landing page$")
    public void launchDarksky(){
        Web.initDriver("https://www.darksky.net");
        Web.maximizeWindow();
    }
    @When("^I get the temp from feels like in ˚F$")
    public void getTemp(){
        String feelsLikeText = landingPage.getFeelsLikeText().replace("˚","");
        String lowTempText = landingPage.getLowTempText().replace("˚","");
        String highTempText = landingPage.getHighTempText().replace("˚","");

        int feelsLike = Integer.parseInt(feelsLikeText);
        int lowTemp = Integer.parseInt(lowTempText);
        int highTemp = Integer.parseInt(highTempText);

        int[]lowToHigh = {feelsLike,lowTemp,highTemp};
        lowToHighTemp=lowToHigh;
    }

    @When("^I click temp units dropdown menu$")
    public void clickTempUnits(){
        landingPage.tempUnit();
    }
    @When("^I select \"˚C, mph\" from the dropdown$")
    public void pickUnit(){
        landingPage.changeTempUnit();
    }
    @Then("^I verify that temp. conversion is happening correctly$")
    public void verify(){
        String feelsLikeText = landingPage.getFeelsLikeText().replace("˚","");
        String lowTempText = landingPage.getLowTempText().replace("˚","");
        String highTempText = landingPage.getHighTempText().replace("˚","");

        int feelsLike2 = Integer.parseInt(feelsLikeText);
        int lowTemp2 = Integer.parseInt(lowTempText);
        int highTemp2 = Integer.parseInt(highTempText);

        int[]lowToHigh2 = {feelsLike2,lowTemp2,highTemp2};

        if(lowToHighTemp!=lowToHigh2) {

            System.out.println("The conversion is happening successfully from: " +Arrays.toString(lowToHighTemp) + " to " + Arrays.toString(lowToHigh2));
        }else
            System.out.println("The conversion is not happening successfully");

        Web.closeDriver();
    }
}
