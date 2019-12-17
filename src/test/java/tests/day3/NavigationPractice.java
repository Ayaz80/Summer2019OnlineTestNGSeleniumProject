package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();//to maximize browser window
        driver.get("http://google.com");
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().fullscreen();
        BrowserUtils.wait(3);//this is our custom method, since the method is static
        //we use class name to call this method. the role of this method to wait 3 second before opening new window
        // navigate back to google
        System.out.println(driver.getTitle());
        driver.navigate().back();
        //move forward to facebook again
        driver.navigate().forward();
        //refresh the webpage
        driver.getTitle();
        driver.navigate().refresh();
        driver.quit();
        //what will happened if we call driver  after quiting
        //driver.get("http://google.com");// we haven't to do it, because it is dead code

    }
}
