package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForIdLocator {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().fullscreen();
        WebElement button=driver.findElement(By.id("disappearing_button"));
        button.click();

        WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());
        BrowserUtils.wait(5);
        driver.quit();

    }
}
