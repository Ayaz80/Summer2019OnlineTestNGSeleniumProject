package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecuterPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
    }
    @Test(description = "scrolling with JS execution")
    public void test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js=(JavascriptExecutor) driver;

        for(int i=0; i< 10; i++){
            js.executeScript("window.scrollBy(0, 500)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(2);
    }
    @Test (description = "scrolling with JS execution to the specific element")
    public void test2(){
   driver.get("http://practice.cybertekschool.com/large");
        WebElement link=driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //this script must scroll untill link element is not visible
        //arguments[0]=means first element after comma(link)
        js.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(2);
    }
    @Test(description = "Click with JS Executer")
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement link1=driver.findElement(By.partialLinkText("Example 1"));
        BrowserUtils.wait(2);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click",link1);
        BrowserUtils.wait(2);
    }
    @Test(description = "Enter text with JS Executor")
    public void test4(){
      driver.get("http://practice.cybertekschool.com/sign_up");
      WebElement name=driver.findElement(By.name("full_name"));
      WebElement email=driver.findElement(By.name("email"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        BrowserUtils.wait(2);

        js.executeScript("arguments[0].setAttribute('value','John smith')",name);
        BrowserUtils.wait(2);

        js.executeScript("arguments[0].setAttribute('value','someemail.com')",name);
        BrowserUtils.wait(2);

        WebElement submit =driver.findElement(By.name("wooden_spoon"));
        js.executeScript("arguments[0].click()", submit);
        BrowserUtils.wait(2);

    }
    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
