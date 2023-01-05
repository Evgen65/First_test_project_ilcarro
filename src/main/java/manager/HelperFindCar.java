package manager;

import models.Find;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

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
        al.sendKeys(Keys.ARROW_DOWN);
        pause(2000);
        al.sendKeys(dates);
        al.sendKeys(Keys.ENTER);
        //type(By.xpath("//input[@id='dates']"), dates);


        //  type(By.xpath("//input[@id='dates']"), dates);
    }

    private void selectCity(String city) {
        type(By.xpath("//input[@id='city']"), city);
        pause(3000);
        click(By.cssSelector("div.pac-item"));
        pause(3000);

    }

    public void submitFindForm() {
        click(By.cssSelector("button[type='submit']"));
    }

    public void fillFindCarForm2(Find inform) {
        selectCity(inform.getCity());
        WebElement al = wd.findElement(By.xpath("//input[@id='dates']"));
        al.click();
        pause(1500);
        selectFirstDates(inform.getFirstDates());
        pause(1500);
        selectLastDates(inform.getLastDates());
    }
    private void selectLastDates(String lastDates) {
        String locator = String.format("//div[text()= %s ]", lastDates);
        click(By.xpath(locator));

    }
    private void selectFirstDates(String firstDates) {
        String locator = String.format("//div[text()= %s ]", firstDates);
        click(By.xpath(locator));
    }

    private void selectDatesCurrentMonth(String dates) {
        WebElement al = wd.findElement(By.xpath("//input[@id='dates']"));
        al.click();
        pause(2000);
        click(By.xpath("//div[text()= 8]"));
        pause(2000);
        click(By.xpath("//div[text()= 11]"));


    }

    public void fillFindCarForm3(Find inform) {
        selectCity(inform.getCity());
        WebElement al = wd.findElement(By.xpath("//input[@id='dates']"));
        al.click();
        pause(1500);
        click(By.xpath("(//button[@aria-label='Choose month and year'])[1]"));
        pause(1500);
        selectYear(inform.getFirstYear());
        pause(1400);
        selectMonth(inform.getFirstMonth());
        pause(1700);
        selectDay(inform.getFirstDates());
        pause(1500);
        selectLastDay(inform.getLastDates());


    }

    private void selectLastDay(String lastDates) {
        String locator = String.format("//div[text()= %s ]", lastDates);
        click(By.xpath(locator));
    }

    private void selectDay(String firstDates) {
        String locator = String.format("//div[text()= %s ]", firstDates);
        click(By.xpath(locator));
    }

    private void selectMonth(String firstMonth) {
        String locator = String.format("//div[.=' %s ']", firstMonth);
        click(By.xpath(locator));
    }

    private void selectYear(String firstYear) {
        String locator = String.format("//div[text()= %s ]", firstYear);
        click(By.xpath(locator));
    }
}
