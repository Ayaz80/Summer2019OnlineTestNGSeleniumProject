package homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class HomeWork {
    /*
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    2. Click on “Sign Up For Mailing List”
    3. Enter any valid nameStep
    4. Enter any valid emailStep
     5. Click on “Sign Up” buttonExpected result:
      Following message should be displayed:
       “Thank you for signing up. Click the button below to return to the home page.”
       Home button should be displayed.
     */
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().fullscreen();
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();

        BrowserUtils.wait(2);
        WebElement input=driver.findElement(By.name("full_name"));
        input.sendKeys("Ayaz");
        WebElement input2=driver.findElement(By.name("email"));
        input2.sendKeys("ayaz@gmail.com");
        WebElement button=driver.findElement(By.name("wooden_spoon"));
        button.click();
        BrowserUtils.wait(2);

        String expectedResult="Thank you for signing up. Click the button below to return to the home page.";
        String actualResult=driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(expectedResult,actualResult,"test failed");
        WebElement homeButton=driver.findElement(By.id("wooden_spoon"));
        homeButton.click();
        BrowserUtils.wait(2);

        WebElement home=driver.findElement(By.className("nav-link"));
        Assert.assertTrue(home.isDisplayed(),"home button is not displayed");

        driver.quit();

    }
}
