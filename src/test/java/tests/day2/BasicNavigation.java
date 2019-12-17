package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        //to maximize browser we use window().maximize(). method
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        //we want to navigate to different page
        //within the same browser
        // URL can be passed as an object or as a String
        driver.navigate().to("https://www.facebook.com/");
        //if we want to come back to the previous page
        driver.navigate().back();
        //if I want to know the URL of current website
        String url=driver.getCurrentUrl();
        System.out.println(url);
        driver.close();
    }
}
