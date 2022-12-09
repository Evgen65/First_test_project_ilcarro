package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar  extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
    }

    public boolean isCarFormPresent() {
        return new WebDriverWait(wd,10)
                .until(ExpectedConditions.textToBePresentInElement
                        (wd.findElement(By.xpath("//h1[.=' Let the car work ']"))
                                ," Let the car work "));


    }
}
