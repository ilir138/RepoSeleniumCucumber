package Pages.Hotels;

import Pages.BasePage;
import Utils.DateHelper;
import org.openqa.selenium.By;

import java.util.Calendar;

public class LandingPage extends BasePage {
    By searchBoxLocator = By.id("qf-0q-destination");
    By searchButtonLocator = By.xpath("//button[@type='submit']");
    By autoSuggestionsLocator = By.xpath("//div[@class='autosuggest-category-result']");
    By allDatesFromFirstCalendarLocator = By.xpath("(//div[@class='widget-datepicker-bd'])[1]//td[@data-date]//a");
    By checkInCalendarIconLocator = By.id("widget-query-label-1");
    By checkOutCalendarIconLocator = By.id("widget-query-label-3");
    By widgetCloseButtonLocator = By.xpath("//button[@aria-label='Close overlay']");
    By briefcaseLocator = By.xpath("//span[@class='widget-query-num-nights']");
    By dateBoxLocator = By.name("q-localised-check-in");

    public void enterDestination(String destination){
        type(searchBoxLocator,destination);
    }

    public void selectDestination (String userWantsToSelectThis){
        selectFromAutoSuggestion(autoSuggestionsLocator, userWantsToSelectThis);
    }

    public void clickSearchButton(){
        clickThis(searchButtonLocator);
    }
    public void clickCheckInCalendarIcon() {
        clickThis(checkInCalendarIconLocator);
    }

    public void clickCheckOutCalendarIcon() {
        clickThis(checkOutCalendarIconLocator);
    }

    public void selectCheckInDate(String dateValue) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectDateFromCalendar(allDatesFromFirstCalendarLocator, dateValue);
    }

    public void selectCheckOutDate(String dateValue) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectDateFromCalendar(allDatesFromFirstCalendarLocator, dateValue);
    }

    public void cancelWidget(){
        clickThis(widgetCloseButtonLocator);
    }
    public String briefcase(){
       return getTextFromElement(briefcaseLocator);
    }
    public void dateBox(String xyz){
        clickThis(dateBoxLocator);
        clearField(dateBoxLocator);
        type(dateBoxLocator,xyz);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickThis(dateBoxLocator);

    }
}

