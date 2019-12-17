package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();//this step is common for all tests

    }
    @Test(description = "Verify that blue button is selected")
    public void test1(){
       WebElement blueButton= driver.findElement(By.id("blue"));
       //lets verify that radio button is selected
        //Assert true theat button is selected
        Assert.assertTrue(blueButton.isSelected());
    }
    @Test(description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton= driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected());
    }
    @Test(description = "Verify thet green button is not clickable")
    public void test3(){
        WebElement greenButton= driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }
    @Test(description ="Click on all radio buttons" )
    public void test4(){
        //how to find all radio buttons
        //any radio button will have type='radio'
        List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[type='radio']"));
        for (WebElement button:radioButtons){
            //if button is available for clicking and not clicked yet
            if(button.isEnabled()&&!button.isSelected()){
                //then click on it
                button.click();
                //in this case id attribute represents a name of color
                System.out.println("Button clicked: "+button.getAttribute("id"));
            }else{
                System.out.println("Button was not clicked: "+button.getAttribute("id"));
            }
            BrowserUtils.wait(1);
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
