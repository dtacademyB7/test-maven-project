package demotests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo {


    @Test
    public void testCase1(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        driver.get("https://mvnrepository.com/");

        Assert.assertTrue(driver.getTitle().equals("Maven Repository: Search/Browse/Explor"));

        driver.quit();

    }

    @Test (groups = "smoke")
    public void testCase2() {
        WebDriverManager.chromedriver().setup();
        //
        WebDriver driver = new ChromeDriver();


        driver.get("https://mvnrepository.com/");

        Assert.assertTrue(driver.getCurrentUrl().equals("https://mvnrepository.com/"));

        driver.quit();

    }

    @Test
    public void testCase3() {
        WebDriverManager.chromedriver().setup();
        //
        WebDriver driver = new ChromeDriver();


        driver.get("https://mvnrepository.com/");

        Assert.assertTrue(driver.getCurrentUrl().equals("https://mvnrepository.com/"));

        driver.quit();

    }






}
