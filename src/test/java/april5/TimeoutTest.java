package april5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TimeoutTest {

    WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod (alwaysRun = true)
    public void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod() {
        driver.quit();
    }


    @Test (timeOut = 10000)
    public void verifyHomepageURL() throws InterruptedException {

        Thread.sleep(11000);
        driver.get("https://mvnrepository.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://mvnrepository.com/");
    }

    @Test (groups = "smoke")
    public void verifyHomepageTitle() {

        driver.get("https://mvnrepository.com/");
        Assert.assertEquals(driver.getTitle(), "Maven Repository: Search/Browse/Explore");
    }





}