package day9_review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
    driver= BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    }
    //we have id,name,tag name, class name, link text, partial link text, xpath
    @Test(description = "Verify checkboxes")
    public void test1(){
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement checkbox1=driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
        //how to verify if check box is not selected
        Assert.assertFalse(checkbox1.isSelected(),"checkbox 1 was selected");
        WebElement checkbox2=driver.findElement(By.xpath(" //input[@type='chechbox'][2]"));
        Assert.assertTrue(checkbox2.isSelected(),"checkbox 2 was not selected");
    }
    @Test(description = "Radio buttons test")
    public void test2(){
        driver.findElement(By.linkText("Radio Buttons")).click();
      //  WebElement blueButton=driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input-"))
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
