package homeWork;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class HomeWork1_2 {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //driver.findElements().size();
    }
}
