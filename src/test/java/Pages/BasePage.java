package Pages;

import Drivers.Web;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

public class BasePage {

    public void type(By locator, String data){
        Web.getDriver().findElement(locator).sendKeys(data);
    }
    public void typeJS(By locator, String data){
        WebElement element = Web.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("arguments[0].values='%s';",element,data);
    }

    // generic method to click web element
    public void clickThis(By locator) {
        Web.getDriver().findElement(locator).click();
    }

    public void clickThis(WebElement element) {
        element.click();
    }

    public void clickThisJS(By locator){
        WebElement element = Web.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("arguments[0].click();",element);
    }

    public void clearField (By locator){
        Web.getDriver().findElement(locator).clear();
    }

    public String getPageTitle(){
        return Web.getDriver().getTitle();
    }
    public String getCurrentWebUrl(){
        return Web.getDriver().getCurrentUrl();
    }
    // generic method to get text from web element
    public String getTextFromElement(By locator) {
        return Web.getDriver().findElement(locator).getText();
    }

    // generic method to get attribute value from web element
    public String getAttributeValueFromElement(By locator, String attributeName) {
        return Web.getDriver().findElement(locator).getAttribute(attributeName);
    }

    // generic method to select any value from dropdown using selectByVisibleText
    public void selectFromDropdownByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = Web.getDriver().findElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // generic method to get if webElement is enabled
    public boolean isWebElementEnabled(By locator) {
        return Web.getDriver().findElement(locator).isEnabled();
    }

    public void mouseHoverOnElement(WebElement element){
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(element).build().perform();
    }
    public void mouseHoverOnElement(By locator){
        WebElement element = Web.getDriver().findElement(locator);
        Actions act = new Actions(Web.getDriver());
        act.moveToElement(element).build().perform();

    }

    public void selectFromAutoSuggestion(By locator, String useSelection){
        List<WebElement> autoSuggestionElements = Web.getDriver().findElements(locator);
        for (int i=0; i < autoSuggestionElements.size(); i++){
            if (autoSuggestionElements.get(i).getText().equalsIgnoreCase(useSelection)){
                clickThis(autoSuggestionElements.get(i));
                break;
            }
        }
    }
    public void scrollByPixel(int y){
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("scrollBy(0,"+y+")");
    }
    public void scrollUpToWebElement (By locator){
        WebElement webElement = Web.getDriver().findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",webElement);

    }
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor)Web.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public void switchWindow(String windowHandle){
        Web.getDriver().switchTo().window(windowHandle);
    }
    public String getCurrentWindowHandle(){
        return Web.getDriver().getWindowHandle();
    }
    public Set<String>getAllWindowHandles(){
        return Web.getDriver().getWindowHandles();
    }
    public void switchToFrame(String frameId){
        Web.getDriver().switchTo().frame(frameId);
    }
    public void switchToFrame(By frameLocator){
        WebElement frameElement = Web.getDriver().findElement(frameLocator);
        Web.getDriver().switchTo().frame(frameElement);
    }
    public void acceptAlert(){
        Web.getDriver().switchTo().alert().accept();
    }
    public void dismissAlert(){
        Web.getDriver().switchTo().alert().dismiss();
    }
    //generic method to get text from an alert
    public WebElement findElementUsingFluentWait(By locator) {
        Wait fWait = new FluentWait<>(Web.getDriver())
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Element is not found within 25 seconds");

        WebElement ele = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);

            }
        });
        return ele;
    }
    public List<WebElement> findElementsUsingFluentWait(By locator) {
        Wait fWait = new FluentWait<>(Web.getDriver())
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Elements are not found within 25 seconds");

        List<WebElement> ele = (List<WebElement>) fWait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(locator);
            }
        });
        return ele;
    }
    public void selectDateFromCalendar(By locator, String userDate) {
        List<WebElement> allDates = findElementsUsingFluentWait(locator);
        for (WebElement date : allDates) {
            if (date.getText().equals(userDate)) {
                clickThis(date);
                break;
            }
        }
    }
}
