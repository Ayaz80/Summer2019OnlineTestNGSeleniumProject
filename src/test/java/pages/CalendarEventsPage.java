package pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;

public class CalendarEventsPage extends TestBase {

    @Test(description = "Verify that page subtitle is equals to 'All Calendar events'")
    public void test1(){
       LoginPage loginPage=new LoginPage();

       loginPage.login("storemanager85","UserUser123");
       loginPage.navigateTo("Activities","Calendar Events");

       String expectedSubtitle="All Calendar Events";
        String actualSubTitle = loginPage.getPageSubTitle();
        Assert.assertEquals(actualSubTitle, expectedSubtitle);


    }
}
