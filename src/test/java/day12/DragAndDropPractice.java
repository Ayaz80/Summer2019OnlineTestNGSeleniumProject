package day12;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {
   @Test(description = "drag and drop example")
    public void test(){
       WebDriver driver= BrowserFactory.getDriver("chrome");
       driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
     driver.manage().window().maximize();
     //click on accept cookies



       Actions actions =new Actions(driver);

       WebElement moon=driver.findElement(By.id("draggable"));
       WebElement earth=driver.findElement(By.id("droptarget"));
       BrowserUtils.wait(3);
       actions.dragAndDrop(moon,earth).pause(900).build().perform();
       BrowserUtils.wait(3);

       driver.quit();
   }
}
