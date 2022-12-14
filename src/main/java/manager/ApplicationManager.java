package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);


    //   WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;
    String browser;
    HelperFindCar findCar;




    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {

        //      wd = new ChromeDriver();
        if (browser.contains(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info(("Test on FIREFOX"));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test on CHROME");

        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.register(new MyListener());
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        findCar=new HelperFindCar(wd);

    }

    public HelperCar getCar() {
        return car;
    }

    public HelperUser getUser() {
        return user;
    }
    public HelperFindCar getFindCar() {
        return findCar;
    }

    public void stop() {
    }


}

