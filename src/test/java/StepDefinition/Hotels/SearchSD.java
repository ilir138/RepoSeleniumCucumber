package StepDefinition.Hotels;

import Drivers.Web;
import Pages.Hotels.LandingPage;
import Pages.Hotels.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSD {
LandingPage landingPage = new LandingPage();
SearchResultPage searchResultPage = new SearchResultPage();

@Given("^I am on Hotels landing page$")
    public void launchHotels(){
    Web.initDriver("https://www.hotels.com");
    Web.maximizeWindow();
}
@When("^I enter '(.*)' in search-box$")
    public void enterUserDestination(String destination){
    landingPage.enterDestination(destination);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
@When("^I select '(.*)' from auto-suggestion$")
    public void selectFromLandingAutoSuggestion(String userPreference){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    landingPage.selectDestination(userPreference);
}
@When("^I click on search button$")
    public void clickSearchButton(){
    landingPage.clickSearchButton();
}
@Then("^I hover the mouse on Sort by Price and select '(.*)'$")
    public void sortByPriceLowToHigh(String userWantsToSelectThis){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
     searchResultPage.mouseHoverToPrice(userWantsToSelectThis);
}
@Then("^I verify that the cheapest hotel is less than \\$100$")
    public void verify(){
    String lowestPrice = searchResultPage.getLowestPriceText().replace("$","");
    int lowest = Integer.parseInt(lowestPrice);

    if(lowest < 100){
        System.out.println("The cheapest hotel price is: $" + lowest);
    }
    else{
        System.out.println("The cheapest hotel is not lower then $100");
    }
    Web.closeDriver();
}
}
