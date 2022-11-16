import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartIlcarroTest {
    WebDriver wd;


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


    @AfterMethod
    public void postCondition() {
        System.out.println("Postcondition");
        //  wd.close();
        //  wd.quit();

    }
}