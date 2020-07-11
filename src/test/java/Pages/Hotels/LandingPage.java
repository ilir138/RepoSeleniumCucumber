package Pages.Hotels;

import Pages.BasePage;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {
    By searchBoxLocator = By.id("qf-0q-destination");
    By searchButtonLocator = By.xpath("//button[@type='submit']");
    By autoSuggestionsLocator = By.xpath("//div[@class='autosuggest-category-result']");

    public void enterDestination(String destination){
        type(searchBoxLocator,destination);
    }

    public void selectDestination (String userWantsToSelectThis){
        selectFromAutoSuggestion(autoSuggestionsLocator, userWantsToSelectThis);
    }

    public void clickSearchButton(){
        clickThis(searchButtonLocator);
    }
}
