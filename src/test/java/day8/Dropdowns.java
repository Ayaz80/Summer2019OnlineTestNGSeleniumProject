package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class Dropdowns {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }
    @Test(description = "Select option 2 from the dropdown")
    public void test1(){
        //to work with select dropdown we need to use Select class in Selenium
        //step 1: Find dropdown and create a webelement
        WebElement dropdown =driver.findElement(By.id("dropdown"));
        //step 2: Create a select object
        //select class requires a webelement object as a parameter
        Select select=new Select(dropdown);
        // to select any option by visible text:
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        //how to verify that option is selected
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
    }
    @Test(description = "Print list of states")
    public void test2(){
        WebElement state=driver.findElement(By.id("state"));
        Select select= new Select(state);
        List<WebElement> states=select.getOptions();
        //how to print every option as a text one by one
        for(WebElement option: states){
            System.out.println(option.getText());
        }
    }
    @Test(description = "Select your state and verify that state is selected")
    public void test3(){
        WebElement state=driver.findElement(By.id("state"));

        Select select=new Select(state);
        select.selectByValue("TX");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Texas");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
