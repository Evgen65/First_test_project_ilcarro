package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;
    public void  init() {
        wd = new ChromeDriver();
         wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
    }

    public void stop() {
    }
}

