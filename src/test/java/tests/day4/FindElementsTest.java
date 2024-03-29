package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedTitle=driver.getTitle();
        //step 1:open inspector in chrome and find locator for the element
        //step 2: create object of webelement
        //step 3:Use webelement
        WebElement button=driver.findElement(By.id("form_submit"));
        //to click on the element
        button.click();
        //read the title again, after clicking
        String actualTitle=driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
            System.out.println("Expected title: "+expectedTitle);
            System.out.println("Actual title: "+actualTitle);
        }
        BrowserUtils.wait(4);
        //driver.getTitle();
        driver.close();
    }
}
