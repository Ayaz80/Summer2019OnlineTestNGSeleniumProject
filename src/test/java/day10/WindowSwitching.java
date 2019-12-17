package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public  void  setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test(description = "verify that the title still practice")
    public void test1(){
      driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice","Title is wrong!");
    }
    @Test(description = "Verify that user is able to see new window ")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        String oldWindow=driver.getWindowHandle();
        BrowserUtils.wait(4);
        //in the selenium every window has an id.that id calls windowHandle
        //to read window handle we use a method get.windowHandle()
        //after new window was opened , we can get list of all window id's
        //list -it's a data structure
        //set is also is a data structor ,like list, but it doesn't allow dulicates
        //also, you cannot easily access anything from there
        //there is no .get() method
        //that's why,we need to loop through the set, to read a data from there
        // set can store only unique values
        Set<String> windowHandles=driver.getWindowHandles();
        //loop trough the collection of window handles
        for(String windowHandle:windowHandles){
            if(!windowHandle.equals(oldWindow)){
                //switch to that window
                driver.switchTo().window(windowHandle);
            }
        }
//lets verify that title of new window is a fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Fresh tab","Title is wrong!");
        //comeback to original page
        //we can build a function , that will jump , in between windows
        //based on page title
        String pageTitle="Practice";
       for(String windowHandle:windowHandles){
           driver.switchTo().window(windowHandle);
           //once we found page title of the window that we need
           if(driver.getTitle().equals(pageTitle)){
               //just exit
               //stop jumping
               break;
           }
       }
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
