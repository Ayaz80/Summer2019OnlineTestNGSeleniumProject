package day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
        driver= BrowserFactory.getDriver("chrome");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
        driver.quit();
    }
    @Test(description = "Verify  title of google.com",priority = 2)
    public void test1(){
        System.out.println("Test 1");
        driver.get("https://www.google.com/");
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title is not correct!");
    }
    @Test(description = "Verify title of apple.com",priority = 1)
    public void test2(){
        System.out.println("Test 2");
        driver.get("https://www.apple.com/");
        String expectedTitle="Apple";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Test is not correct");
        //if assertion failed line below wiil not be reachable
        //if assertion passed line below will be printed
        System.out.println("Test passed");
    }
    //data provider can supply test with a test data.also it allows to do Data Driven Testing
    //what is this? It's when same test runs multiple times with different test data set
   @DataProvider(name = "testData")
    public static Object[][] testData(){
    return new Object[][]{{"https://www.apple.com/","Apple"},{"https://www.google.com/","Google"}};
    }
    @Test(dataProvider = "testData")
    public void testWithataProvider(String url,String  title){
        driver.get(url);
        Assert.assertEquals(driver.getTitle(),title);
    }
}
