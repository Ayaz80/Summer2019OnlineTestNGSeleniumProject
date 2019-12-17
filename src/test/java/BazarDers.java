import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserFactory;

public class BazarDers {
    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        driver.findElement(By.linkText("This is a link")).click();




        // driver.quit();


    }
}
