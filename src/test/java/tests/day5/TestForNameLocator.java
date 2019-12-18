package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForNameLocator {
    public static void main(String[] args) {
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        BrowserUtils.wait(2);
// if we want to do it in one line without creating Webelement reference variable
        //enter full name
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        BrowserUtils.wait(2);

        //enter email
        driver.findElement(By.name("email")).sendKeys("test_email@email.com");
        BrowserUtils.wait(2);

        //click sign up
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(2);

        driver.quit();
    }
}
