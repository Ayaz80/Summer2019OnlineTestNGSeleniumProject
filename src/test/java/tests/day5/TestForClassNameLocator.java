package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestForClassNameLocator {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().fullscreen();
        //h3 is the class name or value of class attribute
        //if class has text with space it means there are 2 classes
        WebElement heading=driver.findElement(By.className("h3"));
        //we can read the text of attribute
        System.out.println(heading.getText());

        BrowserUtils.wait(3);
        driver.close();

    }
}
