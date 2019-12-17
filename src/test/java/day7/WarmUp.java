package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links?
        //every link has a tag name <a>
        // //a.[.='Home'] or //a[text()='Home']
        List<WebElement> links=driver.findElements(By.xpath("//a"));
        System.out.println("Number of links; "+links.size());
        // If we want to print text of all links one by one
        for(WebElement webElement:links){
            System.out.println(webElement.getText());
        }

        driver.quit();

    }
}
