package Pages.Facebook;

import Pages.BasePage;
import org.openqa.selenium.By;



public class LandingPage extends BasePage {
    // locators for web-element on Landing Page
    By loginEmailLocator = By.id("email");
    By loginPasswordLocator = By.id("pass");
    By loginButtonLocator = By.id("loginbutton");


    // methods to interact with Landing Page elements
    public void enterLoginEmail(String userEmail) {
        type(loginEmailLocator, userEmail);
    }

    public void enterLoginPassword(String userPassword) {
        type(loginPasswordLocator, userPassword);
    }

    public void clickLoginButton() {
        clickThis(loginButtonLocator);
    }

}
