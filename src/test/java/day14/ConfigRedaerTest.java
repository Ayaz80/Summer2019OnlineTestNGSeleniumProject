package day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigRedaerTest {
    @Test
    public  void test1(){
       String expectedBrowser="chrome" ;
       String  actualBrowser= ConfigurationReader.getProperty("browser");
        Assert.assertEquals(expectedBrowser,actualBrowser);
        System.out.println("URL "+ConfigurationReader.getProperty("url"));
        System.out.println("UserName: "+ConfigurationReader.getProperty("user_name"));
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));
    }
}
