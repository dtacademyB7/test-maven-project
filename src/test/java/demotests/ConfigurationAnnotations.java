package demotests;

import org.testng.annotations.*;

public class ConfigurationAnnotations {



    @Test
    public void testCase1(){
        System.out.println("Test case 1");
    }

    @Test
    public void testCase2(){
        System.out.println("Test case 2");
    }

    @BeforeSuite
    public void setupSuite(){
        System.out.println("Before Suite");
    }


    @AfterSuite
    public void tearDownSuite(){
        System.out.println("After Suite ");
    }


    @BeforeTest
    public void setupTestGroup(){
        System.out.println("Before group of tests under suite");
    }

    @AfterTest
    public void tearDownTestGroup(){
        System.out.println("After group of tests under suite");

    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before all the methods of the clas");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After all the methods of the class");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before each method of the class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After each method of the class");
    }



}
