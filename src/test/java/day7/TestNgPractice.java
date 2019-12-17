package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNgPractice {

    @Test
    public void test(){
        Assert.assertEquals("apple","apple");
    }
    @Test
    public void verifyTitle(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/");
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is wrong");
        driver.quit();
    }
@Test(description = "Verify that heading is displayed")
    public void verifyHeadingDisplayed(){
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice.cybertekschool.com/");
    WebElement heading=driver.findElement(By.xpath("//span[text()='Test Automation Practice']"));
    //to make sure that the element is visible for the user
    //because the element can be present but not visible
    Assert.assertTrue(heading.isDisplayed(),"Element is not displayed");

    driver.quit();
    }
}
