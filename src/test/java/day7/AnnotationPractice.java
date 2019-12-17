package day7;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.transform.sax.SAXSource;

public class AnnotationPractice {
    @BeforeClass
    //runs only ones before all methods
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    //runs only ones after all methods and tests
    public void afterClass(){
        System.out.println("After class");    }

@BeforeMethod
    public void setup(){
       //some code that will be runnung before every test method
       //we can use method with @beforemethod annotation
    System.out.println("Before Method");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }

    @Test
    public void test1(){
        System.out.println("Test1!");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("Test2!");
    }
    @Test
    public void test3(){
        System.out.println("Test3!");
    }
}
