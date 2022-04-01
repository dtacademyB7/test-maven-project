package demotests;

import org.testng.annotations.Test;

public class OrderOfExecution {


    @Test (priority = 0)
    public void login(){
        System.out.println("Log in");
    }

    @Test (priority = 5)
    public void enterPass(){
        System.out.println("Enter pass");
    }

    @Test (priority = -8)
    public void verifyusername(){
        System.out.println("verify username");
    }

    @Test
    public void exit(){
        System.out.println("exit");
    }

    @Test (priority = 5)
    public void zoomIn(){
        System.out.println("Zoom in");
    }




}
