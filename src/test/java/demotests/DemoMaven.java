package demotests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoMaven {


    public static void main(String[] args) {


        System.out.println("Java code");

//        System.setProperty("webdriver.chrome.driver", "/Users/duotech/Documents/browserDrivers/chromedriver");


//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//
//        WebDriver driver = new FirefoxDriver();
//
//        driver.get("https://mvnrepository.com/");


        Faker faker = new Faker();

        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().firstName());
        System.out.println(faker.address().lastName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.chuckNorris().fact());






    }
}
