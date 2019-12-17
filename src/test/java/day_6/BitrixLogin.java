package day_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        //go to bitrix
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        //enter email
        driver.findElement(By.xpath("input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");
        //enter password
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");
         //log in button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        BrowserUtils.wait(2);

        driver.quit();


    }
}
