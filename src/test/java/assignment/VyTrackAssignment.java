package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class VyTrackAssignment {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().fullscreen();
        WebElement username=driver.findElement(By.name("_username"));
        username.sendKeys("user1");
        WebElement password=driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");
        WebElement button=driver.findElement(By.id("_submit"));
        button.click();
        String expectedUrl="https://qa2.vytrack.com/";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        BrowserUtils.wait(5);
       driver.close();






    }
}
