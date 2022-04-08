package april7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ParametrizationBasic {






    @Test
    @Parameters ({"SEARCH_WORD", "BROWSER_TYPE"})
    public void verifySearchTerm(String searchTerm, String browserType) throws InterruptedException {
        WebDriver driver = null;

        if(browserType.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browserType.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserType.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Thread.sleep(1000);

        Assert.assertTrue(driver.getTitle().contains(searchTerm));
        driver.quit();
    }




}
