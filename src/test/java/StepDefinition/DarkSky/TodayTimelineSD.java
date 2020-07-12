package StepDefinition.DarkSky;

import Drivers.Web;
import Pages.DarkSky.LandingPage2;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class TodayTimelineSD {
    LandingPage2 landingPage2 = new LandingPage2();

    @Given("^I am on darksky landing page$")
    public void launchDarksky(){
        Web.initDriver("https://www.darksky.net");
        Web.maximizeWindow();
    }
    @Then("^I scroll to Today timeline$")
    public void scrollToTodayDetail(){
        landingPage2.scrollDown();
    }
    @When("^I verify the temp values on timeline is same as detail section$")
    public void getText(){
       String todayMinTemp = landingPage2.getMInTempText();
       String todayMaxTemp = landingPage2.getMaxTempText();
       String detailMinTemp = landingPage2.getDetailMinTempText();
       String detailMaxTemp = landingPage2.getDetailMaxTempText();

        Assert.assertEquals(todayMinTemp,detailMinTemp,"The temperatures are not matching");
        Assert.assertEquals(todayMaxTemp,detailMaxTemp,"The temperatures are not matching");

        Web.closeDriver();

    }

}
