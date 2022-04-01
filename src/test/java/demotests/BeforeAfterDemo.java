package demotests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAfterDemo {

    WebDriver driver;

    @BeforeClass
    public void setupClass(){
        WebDriverManager.firefoxdriver().setup();

    }

    @BeforeMethod
    public void setupMethod(){
        driver = new FirefoxDriver();
        driver.get("https://mvnrepository.com/");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }





//    @BeforeTest
//    public void beforeTest(){
//
//    }

    @Test
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
