package april5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class MultipleParameters {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }



    @Test (priority = 0, enabled = false)
    public void loginTest(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders");



    }

    @Test (priority = 1)
    public void negativelLoginTest() {

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "incorrectPass", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");


    }
    @Ignore
    @Test (priority = 2)
    public void negativelLoginTest2(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_status")).isDisplayed());



    }






}
