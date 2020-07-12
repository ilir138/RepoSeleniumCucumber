package Pages.DarkSky;

import Pages.BasePage;
import org.openqa.selenium.By;

public class LandingPage2 extends BasePage {
    By todayPlusLocator = By.xpath("//a[@data-day='0']//span[@class='open']");
    By minTempLocator = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    By maxTempLocator = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
    By detailMinTempLocator = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//child::span[@class='temp']");
    By detailMaxTempLocator = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//child::span[@class='temp']");


public void scrollDown() {
    scrollByPixel(800);
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    clickThis(todayPlusLocator);
    try {
        Thread.sleep(4000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public String getMInTempText(){
    return getTextFromElement(minTempLocator);
}
public String getMaxTempText(){
    return getTextFromElement(maxTempLocator);
}
public String getDetailMinTempText(){
    return getTextFromElement(detailMinTempLocator);
}
public String getDetailMaxTempText(){
    return getTextFromElement(detailMaxTempLocator);
}
}
