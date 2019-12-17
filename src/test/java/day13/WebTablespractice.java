package day13;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablespractice {
    private WebDriver driver;
    private WebDriverWait wait;
    /*
    table
    thead-table header(columns names)
    tbody-table body
    tr-table row
     */
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));

    }
    @Test(description = "Print table 1 data")
    public void test1(){
        //<table> stands for web table in HTML
        //table1 is id of first table
        //once we find this table as web element, we can print all text from there
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }
    @Test(description = "verify that number of columns in the first table is equals tp 6")
    public void test2(){
        int actualColumnNumber=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber=6;
        Assert.assertEquals(actualColumnNumber,expectedColumnNumber,"not equal");
    }
    @Test(description = "verify that number of rows is equal to 5")
    public void test3(){
       int expectedRowCount=5;
       int actualRowCount=driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
       Assert.assertEquals(expectedRowCount,actualRowCount,"numbers are not same");
    }
    @Test(description = "print all the values from the 2nd row(excluding table header")
    public void test4(){
        List<WebElement> row=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]/td"));
        for(WebElement each:row){
            System.out.println(each.getText());
        }
    }
    @Test(description = "print all the values from the 'n'th row(excluding table header")
    public void test5(){
        int index=1;
        List<WebElement> row=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr["+index+"]/td"));
        for(WebElement each:row){
            System.out.println(each.getText());
        }
    }
    @Test(description = "Verify that email in the third row is equals to jdoe@hotmail.com")
    public void test6(){
        int row=3;
        int column=3;
       WebElement cell=driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]"));
       String expectedText="jdoe@hotmail.com";
       String actualText=cell.getText();
       Assert.assertEquals(actualText,expectedText);
    }
    @Test(description = "Verify that every email contains @")
    public void test7(){
        List<WebElement> email=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
        for (WebElement each:email) {
            System.out.println(each.getText());
            Assert.assertTrue(each.getText().contains("@"),"failed");
        }
    }
    /*
    step1. click on "last name" column name
    step2. get all values from "last name " column
    step3. verify that column is sorted in alphabetic order
     */
    @Test(description = "verify that after click on last name values will be sorted in alphabetic order")
    public void test8(){
      WebElement lastNameElement=driver.findElement(By.xpath("//table[@id='table1']//*[text()='Last Name']"));
      lastNameElement.click();
      List<WebElement> lastNames=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
      for(int index=0;index<lastNames.size()-1;index++){
          String lastName=lastNames.get(index).getText();
          String followingLastName=lastNames.get(index+1).getText();
          Assert.assertTrue(lastName.compareTo(followingLastName)<0);
      }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}