package april7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.rmi.CORBA.Util;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Arrays;

public class DataDrivenTestingWithDataProvider {


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


    @Test (dataProvider = "getData")
    public void verifySearchTerm(String searchTerm) {

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains(searchTerm));
    }

    @Test (dataProvider = "getDataFromCSV")
    public void verifySignUp(String username, String firstName, String lastName, String email, String password) {

        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        driver.findElement(By.id("hideLogin")).click();



        driver.findElement(By.id("userName")).sendKeys(username );


        driver.findElement(By.id("firstName")).sendKeys(firstName);
       ;

        driver.findElement(By.id("lastName")).sendKeys(lastName);



        driver.findElement(By.id("email")).sendKeys(email);


        driver.findElement(By.id("email2")).sendKeys(email );

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("password2")).sendKeys(password);

        driver.findElement(By.name("registerButton")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?");

    }


    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"old spice",},
                {"Анатолий"},
                {"陈"},
                {"dsahsadhsahdhsaghvdghvasghdvgasvvxasbcxvbnvavasbnvxbvcansvbcxvabsvbcxvvsn"},
                {""},
                {"Ω≈ç√∫˜µ≤≥÷"},
                {"NaN"},
                {"ЁЂЃЄЅІЇЈЉЊЋЌЍЎЏАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя"},
                {"⁰⁴⁵₀₁₂"}

        };

    }

    @DataProvider
    public Object[][] getDataFromCSV(){
        return Utility.readFromCSV("MOCK_DATA.csv");

    }




}
