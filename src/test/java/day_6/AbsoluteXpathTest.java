package day_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class AbsoluteXpathTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //click on login without entering text
        //to invoke warning message
        driver.findElement(By.className("login-btn")).click();
        BrowserUtils.wait(2);
        WebElement warningessage=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div[2]"));


        System.out.println(warningessage.getText());

        driver.quit();
    }
}
