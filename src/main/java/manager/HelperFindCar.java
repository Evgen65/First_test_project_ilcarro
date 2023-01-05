package manager;

import models.Find;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperFindCar extends HelperBase {


    public HelperFindCar(WebDriver wd) {
        super(wd);
    }

    public void openHomePage() {
        click(By.xpath("(//img[@alt='logo'])[1])"));
        new WebDriverWait(wd, 5)
                .until(ExpectedConditions.visibilityOf
                        (wd.findElement(By.xpath("(//img[@alt='logo'])[1])"))));
    }

    public void fillFindCarForm(Find inform) {
        selectCity(inform.getCity());
        selectDates(inform.getDates());
    }

    private void selectDates(String dates) {
        WebElement al = wd.findElement(By.xpath("//input[@id='dates']"));
        al.click();
        pause(2000);
        al.sendKeys(dates);
        al.click();

        //  type(By.xpath("//input[@id='dates']"), dates);
    }

    private void selectCity(String city) {
        type(By.xpath("//input[@id='city']"), city);

    }

    public void submitFindForm() {
        click(By.cssSelector("button[type='submit']"));
    }
}
