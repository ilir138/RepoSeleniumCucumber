package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class exercise {
    @Test
    public void multipleWindows() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./DriverExecFiles/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com");
        Thread.sleep(5000);
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("Current handle:\n" + currentWindowHandle);

        //Close all advertisements windows EXCEPT main window (naukri.com window).

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All handles: \n" + allHandles);
        String title = driver.getTitle();
        System.out.println("Current page title: " + title);
        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (!driver.getTitle().contains("Jobs - Recruitment")) {
                driver.close();
                break;
            }
        }


    }
}
