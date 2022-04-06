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


//@Ignore   these annotations can be applied at class level which is applied to all methods of the class
//@Test
public class MultipleParameters {

    WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setupClass(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod (alwaysRun = true)
    public void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

    }

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }



    @Test (priority = 0, enabled = false)
    public void loginTest(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders");



    }
     // with group tests @Before and @After methods are not going to run by default
    @Test (priority = 1, groups = "smoke")
    public void negativelLoginTest() {

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "incorrectPass", Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");


    }
//    @Ignore
    @Test (priority = 2, groups = "smoke")
    public void negativelLoginTest2(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_status")).isDisplayed());



    }






}
