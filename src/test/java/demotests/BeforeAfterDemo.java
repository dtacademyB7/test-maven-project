package demotests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAfterDemo {

    WebDriver driver;

    @BeforeClass (alwaysRun = true)
    public void setupClass(){
        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeMethod (alwaysRun = true)
    public void setupMethod(){
        driver = new FirefoxDriver();
        driver.get("https://mvnrepository.com/");

    }

    @AfterMethod (alwaysRun = true)
    public void tearDownMethod(){
        driver.quit();
    }





//    @BeforeTest
//    public void beforeTest(){
//
//    }

    @Test (groups = "smoke")
    public void testCase1(){


        Assert.assertTrue(driver.getTitle().equals("Maven Repository: Search/Browse/Explor"));



    }

    @Test
    public void testCase2() {

        //


        Assert.assertTrue(driver.getCurrentUrl().equals("https://mvnrepository.com/"));



    }

    @Test
    public void testCase3(){



        Assert.assertTrue(driver.getPageSource().contains("Contact Us"));



    }






}
