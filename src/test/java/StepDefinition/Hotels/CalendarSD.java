package StepDefinition.Hotels;

import Drivers.Web;
import Pages.Hotels.LandingPage;
import Utils.DateHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CalendarSD {
    LandingPage landingPage = new LandingPage();
    String date;
    String date1;

@Given("^I am on hotels landing page$")
    public void launchHotels(){
    Web.initDriver("https://www.hotels.com");
    Web.maximizeWindow();
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    landingPage.cancelWidget();
}
@When("^I enter (.*) as check in$")
public void selectCheckInDate(String dateValue) {
    landingPage.clickCheckInCalendarIcon();
    if (dateValue.equalsIgnoreCase("today")) {
        landingPage.selectCheckInDate(DateHelper.getCurrentDateValue());
    } else if (dateValue.equalsIgnoreCase("tomorrow")) {
       landingPage.selectCheckInDate(DateHelper.getTomorrowDateValue());
    } else {
        landingPage.selectCheckInDate(dateValue);
    }

    date1=DateHelper.yesterdayTodayTomorrow(dateValue);

    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    @When("^I enter (\\d+) days from tomorrow as checkout$")
    public void selectCheckOutDate(int days) throws ParseException {
        landingPage.clickCheckOutCalendarIcon();
        landingPage.selectCheckOutDate(DateHelper.getDateValueXDaysFromAnyDate(date1,days));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("^I verify (.*) count on the briefcase$")
    public void verifyBriefcase(String expectedResult){
    String bCount = landingPage.briefcase();

        Assert.assertEquals(bCount,expectedResult, "Numbers don't match.");

        Web.closeDriver();

    }
    @When("^I enter (.*) as check in date$")
    public void selectAsCheckInDate(String dateValue) throws ParseException {
    landingPage.clickCheckInCalendarIcon();
    //landingPage.selectCheckInDate(dateValue);
    date=dateValue;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        landingPage.dateBox(DateHelper.setAnyGivenDate(dateValue));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("^I enter (\\d+) days from check in date$")
    public void checkOutDate(int day) throws ParseException {
        landingPage.clickCheckOutCalendarIcon();
        landingPage.selectCheckOutDate(DateHelper.getDateValueXDaysFromAnyDate2(date,day));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
