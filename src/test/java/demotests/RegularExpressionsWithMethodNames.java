package demotests;

import org.testng.annotations.Test;

public class RegularExpressionsWithMethodNames {


    @Test
    public void CC_TC_001_UI_loginTest(){
        System.out.println("Log in");
    }

    @Test (groups = "smoke")
    public void TC_002_UI_linkTest(){
        System.out.println("Enter pass");
    }

    @Test
    public void CC_TC_003_UI_loginPositiveTest(){
        System.out.println("verify username");
    }

    @Test (groups = "smoke")
    public void TC_004_DB_signUpTest(){
        System.out.println("exit");
    }

    @Test
    public void TC_005_DB_loginPositiveTest(){
        System.out.println("Zoom in");
    }




}
