package april7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;

public class ITestResultListener {


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
    public void tearDownMethod(ITestResult testResult) throws IOException {

         if(testResult.getStatus() == ITestResult.SUCCESS){
             System.out.println("Test PASSED: " + testResult.getName() );
         }else if(testResult.getStatus() == ITestResult.SKIP){
             System.out.println("Test SKIPPED: " + testResult.getName() );
         }else if(testResult.getStatus() == ITestResult.FAILURE){
             System.out.println("Test FAILED: " + testResult.getName() );
             System.out.println("The exception message: " + testResult.getThrowable());

             File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(screenshotAs, new File("failureScreenshot" +System.currentTimeMillis()+ ".png"));
         }


        driver.quit();
    }

    @Test
    public void verifySearchTerm() {

        //to explicitly skip a test


        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        driver.findElement(By.id("hideLogin")).click();



        driver.findElement(By.id("userName")).sendKeys("cdsvbvdsdsbv" );


        driver.findElement(By.id("firstName")).sendKeys("Ziya");


        driver.findElement(By.id("lastName")).sendKeys("cvdscvdsdvg");



        driver.findElement(By.id("email")).sendKeys("vcdf@gmail.com");


        driver.findElement(By.id("email2")).sendKeys("vcdf@gmail.com" );

        driver.findElement(By.id("password")).sendKeys("cbdvgcds");

        driver.findElement(By.id("password2")).sendKeys("cbdvgcds");

        driver.findElement(By.name("registerButton")).click();

//        throw new SkipException("Test is skipped because it is not ready");
   // to skip the test explicitly

        Assert.assertEquals(driver.getCurrentUrl(), "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?");


    }



}
