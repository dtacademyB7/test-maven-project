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

public class DependencyTest {

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }


    @Test
    public void verifyHomepageURL() {

        driver.get("https://mvnrepository.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://mvnrepositori.com/");
    }

    @Test
    public void verifyHomepageTitle() {

        driver.get("https://mvnrepository.com/");
        Assert.assertEquals(driver.getTitle(), "Maven Repository: Search/Browse/Explore");
    }

    @Test(dependsOnMethods = {"verifyHomepageURL", "verifyHomepageTitle"}) // String array
    public void verifySearchFunctionality() {
        driver.get("https://mvnrepository.com/");
        String searchTerm = "selenium";
        driver.findElement(By.id("query")).sendKeys(searchTerm, Keys.ENTER);
        List<WebElement> links = driver.findElements(By.xpath("//h2[@class='im-title']//a[not(@class)]"));

        for (WebElement link : links) {
            Assert.assertTrue(link.getText().contains(searchTerm));
        }


    }

    @Test(dependsOnMethods = "verifySearchFunctionality")
    public void verifyLinks() {
        driver.get("https://mvnrepository.com/");
        String searchTerm = "selenium";
        driver.findElement(By.id("query")).sendKeys(searchTerm, Keys.ENTER);
        List<WebElement> links = driver.findElements(By.xpath("//h2[@class='im-title']//a[not(@class)]"));

        for (WebElement link : links) {
            Assert.assertTrue(link.getText().contains(searchTerm));
        }


    }

}