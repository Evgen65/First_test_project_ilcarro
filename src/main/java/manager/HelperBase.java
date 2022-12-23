package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int time) {
//          wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        time = time / 1000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getText(By locator){
        return wd.findElement(locator).getText();
    }

    public void takeScreenShot(String link){
        File tmt = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot=new File(link);

        try {
            Files.copy(tmt,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

