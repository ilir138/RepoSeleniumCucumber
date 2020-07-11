package Pages.DarkSky;

import Pages.BasePage;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    By unitLocator = By.xpath("//body/div/div/div[1]/div[2]/b[1]");//this xpath was the only one that worked for me
    By pickUnitLocator = By.xpath("//body/div/div/div[1]/div[3]/div/ul/li[4]");
    By feelsLikeLocator = By.xpath("//span[@class='feels-like-text']");
    By lowTempLocator = By.xpath("//span[@class='low-temp-text']");
    By highTempLocator = By.xpath("//span[@class='high-temp-text']");

    public void tempUnit(){
        clickThis(unitLocator);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void changeTempUnit(){
        clickThis(pickUnitLocator);
    }

    public String getFeelsLikeText(){
        return getTextFromElement(feelsLikeLocator);
    }
    public String getLowTempText(){
        return getTextFromElement(lowTempLocator);
    }
    public String getHighTempText(){
        return getTextFromElement(highTempLocator);
    }

}
