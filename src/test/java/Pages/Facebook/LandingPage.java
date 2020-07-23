package Pages.Facebook;

import Drivers.Web;
import Pages.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.Set;


public class LandingPage extends BasePage {
    // locators for web-element on Landing Page
    By loginEmailLocator = By.id("email");
    By loginPasswordLocator = By.id("pass");
    By loginButtonLocator = By.id("loginbutton");
    By termsLocator = By.id("terms-link");
    By dataPolicyLocator = By.id("privacy-link");
    By cookiePolicyLocator = By.id("cookie-use-link");



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

    public void clickTerms(){
        clickThis(termsLocator);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void termsTitle(){

        Set<String> allWindows = getAllWindowHandles();
        for (String handle : allWindows) {
            Web.getDriver().switchTo().window(handle);
            String termsTitle = Web.getDriver().getTitle();
            if (termsTitle.contains("Terms")) {
                Assert.assertEquals(termsTitle,"Terms of Service", "wrong page title");
                break;
            }
        }
    }
    public void allWindowsOpen(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Set<String> allWindows = getAllWindowHandles();

        for (String handle : allWindows) {
            Web.getDriver().switchTo().window(handle);
            if (Web.getDriver().getTitle().contains("Log In or")) {
                System.out.println("Facebook landing page is open");
                break;
            }
        }


    }
    public void clickDataPolicy(){
        clickThis(dataPolicyLocator);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void dataPolicy(){

        Set<String> allWindows = getAllWindowHandles();
        for (String handle : allWindows) {
            Web.getDriver().switchTo().window(handle);
            String dataPolicyTitle = Web.getDriver().getTitle();
            if (dataPolicyTitle.contains("Data ")) {
                Assert.assertEquals(dataPolicyTitle,"Data Policy", "wrong page title");
                break;
            }
        }
    }

    public void clickCookiePolicy(){
        clickThis(cookiePolicyLocator);
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void cookiePolicy(){
        Set<String> allWindows = getAllWindowHandles();
        for (String handle : allWindows) {
            Web.getDriver().switchTo().window(handle);
            String cookiePolicyTitle = Web.getDriver().getTitle();
            if (cookiePolicyTitle.contains("Cookies ")) {
                Assert.assertEquals(cookiePolicyTitle,"Cookies Policy", "wrong page title");
                break;
            }
        }
    }

}
