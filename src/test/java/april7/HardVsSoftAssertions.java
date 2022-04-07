package april7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class HardVsSoftAssertions {





    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod() {
        driver.quit();
    }


    @Test
    public void basicVerificationHomepageHardAssert() throws InterruptedException {



        driver.get("https://www.duotech.io/");

        System.out.println("First Assertion");
        // Hard assertions: they fail immediately and stop the execution
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.duotek.io/");
        // When assert methods fail, they throw java.lang.AssertionError:

        System.out.println("Second Assertion");
        Assert.assertEquals(driver.getTitle(), "Software QA Automation Engineer program | SDET | QA School | Software Testing");

        List<WebElement> links = driver.findElements(By.xpath("//nav//a"));

        System.out.println("Third Assertion");
        for (WebElement link : links) {
            Assert.assertFalse(link.getAttribute("href").isEmpty());
        }


    }

    @Test
    public void basicVerificationHomepageSoftAssert() throws InterruptedException {


       // What is the diffrenece between assert vs verify (Hard Assert vs Soft Assert)

        driver.get("https://www.duotech.io/");

        System.out.println("First Assertion");
        // Soft assertions: they continue the execution even though assert method fails and deliver the result at the end

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.duotek.io/");

        System.out.println("Second Assertion");
        softAssert.assertEquals(driver.getTitle(), "Software QA Automation Engineer program | SDET | QA School | Software TEST");

        List<WebElement> links = driver.findElements(By.xpath("//nav//a"));

        System.out.println("Third Assertion");
        for (WebElement link : links) {
            softAssert.assertFalse(link.getAttribute("href").isEmpty());
        }


        softAssert.assertAll();
    }


}
