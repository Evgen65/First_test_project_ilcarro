import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.security.auth.login.LoginContext;
import javax.sound.sampled.SourceDataLine;

public class StartIlcarroTest {
    WebDriver wd;
    LoginContext log;


    @BeforeMethod
    public void preCondition() {
        wd = new ChromeDriver();
        wd.get("https://ilcarro-1578153671498.web.app/search");
        System.out.println("Precondition");

    }

    @Test
    public void testName() {
        System.out.println("Test started");

    }
    @BeforeTest
    public void addLogin(){
        System.out.println("Login");

    }
    @Test
    public void testadLogin() {
        System.out.println("Test started");

    }


    @AfterMethod
    public void postCondition() {
        System.out.println("Postcondition");
        //  wd.close();
        //  wd.quit();

    }
}