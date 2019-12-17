package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CSSselectorPractice {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/multiple_buttons");
        //lets find all buttons and click on them one by one
        List<WebElement> buttons=driver.findElements(By.cssSelector(".btn.btn-primary"));
          // List<WebElement> buttons=driver.findElements(By.cssSelector("[class=' btn btn=primary]"));

           for(WebElement button:buttons){
               button.click();
               BrowserUtils.wait(1);
               WebElement message=driver.findElement(By.cssSelector("#result"));
               System.out.println(message.getText());
           }
        // find element with a tag name h3, that has a parent element, with class name container
        WebElement header = driver.findElement(By.cssSelector(".container > h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector("[class='container'] > p"));
        System.out.println(p.getText());
           driver.quit();

    }
}
