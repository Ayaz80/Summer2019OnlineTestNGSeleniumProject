package homeWork;
/*
@Test(description = "Verify the message and home button")
    public void test1 () throws InterruptedException {
        // finding the element be the text
        // everything between > < is a text
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        WebElement name = driver.findElement(By.cssSelector("[type='text'][name='full_name']"));
        name.sendKeys("Kateryna");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("KSemenenko@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='radius'][name='wooden_spoon']")).click();
        // Verifying the massage
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.xpath("//h3[@class='subheader']")).getText();
        Assert.assertEquals(expected,actual,"FAIL");
        // Verifying that home button is displayed
        WebElement homeButton = driver.findElement(By.id("wooden_spoon"));
        Assert.assertTrue(homeButton.isDisplayed(),"Home button is not displayed");
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class HomeWork1 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
    }
    @Test(description = "verify the message and home button")
    public void test1() throws InterruptedException {
    driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        WebElement name=driver.findElement(By.cssSelector("[type='text'][name='full_name']"));
        name.sendKeys("Ayaz");
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("ayaz@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='radius'][name='wooden_spoon']")).click();
        String expectedResult="Thank you for signing up. Click the button below to return to the home page.";
        String actualResult=driver.findElement(By.xpath("//h3[@class='subheader']")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Test failed");
        WebElement homeButton=driver.findElement(By.id("wooden_spoon"));

        Assert.assertTrue(homeButton.isDisplayed(),"home button is not displayed");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
