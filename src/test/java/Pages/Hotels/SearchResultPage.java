package Pages.Hotels;

import Pages.BasePage;
import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {

    By sortByPriceLocator = By.xpath("//a[@data-menu='sort-submenu-price']");
    By lowestPriceLocator = By.xpath("//ins[text()='$82']");


    public void mouseHoverToPrice(String userWantsToSelectThis){
        selectFromAutoSuggestion(sortByPriceLocator, userWantsToSelectThis);
    }
    public String getLowestPriceText(){
        return getTextFromElement(lowestPriceLocator);
    }

}
