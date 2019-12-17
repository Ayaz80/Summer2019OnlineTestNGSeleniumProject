package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class VyTrackAutomation {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        driver.findElement(By.name("_username")).sendKeys("User4");

       driver.findElement(By.name("_password")).sendKeys("12345");

        driver.findElement(By.id("_submit")).click();

        BrowserUtils.wait(3);
        WebElement xpath=driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div"));
        String actual=xpath.getText();
        String expected="Invalid user name or password.";

        if(actual.equals(expected)) {
            System.out.println("test passed");
        } else{
            System.out.println("test failed");
        System.out.println(actual);
        System.out.println(expected);}
        driver.close();

    }
}
