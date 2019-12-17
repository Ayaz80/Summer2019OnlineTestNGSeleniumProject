package tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //we have to set up WebDriver based on the browser that we gonna use
        WebDriverManager.chromedriver().setup();
        //we need to create an object of appropriate class
        WebDriver driver=new ChromeDriver();
        //let's open google.com
        //get(). method allows us to open some website
        driver.get("http://google.com");
        // to read page title, there is a method .getTitle()

        //test1: verify that title of the page is "Google"
        String actualResult=driver.getTitle();
        String expectedResult="Google";

        if(actualResult.equals(expectedResult)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        //to close the browser we can use either quit() or close() methods
        driver.close();
    }
}
