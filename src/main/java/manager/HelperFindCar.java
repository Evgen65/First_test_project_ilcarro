package manager;

import models.Find;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HelperFindCar extends HelperBase {


    public HelperFindCar(WebDriver wd) {
        super(wd);
    }

    public void openHomePage() {
        click(By.xpath("//a[.=' Search ']"));
        new WebDriverWait(wd, 5)
                .until(ExpectedConditions.visibilityOf
                        (wd.findElement(By.xpath("//h1[.='Find your car now!']"))));
    }

    public void fillFindCarForm(String city, String dates) {
        selectCity(city);
        WebElement al = wd.findElement(By.id("dates"));
        //   al.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        selectDates(dates);
    }

    private void selectDates(String dates) {
        WebElement al = wd.findElement(By.xpath("//input[@id='dates']"));
        al.click();
        pause(2000);
        al.sendKeys(Keys.ARROW_DOWN);
        pause(2000);
        al.sendKeys(dates);
        al.sendKeys(Keys.ENTER);
    }

    private void selectCity(String city) {
        clear(By.id("city"));
        type(By.id("city"), city);
        pause(3000);
        click(By.cssSelector("div.pac-item"));
        pause(3000);
    }

    public void fillFindCarForm2(String city, String firstDates, String lastDates) {
        selectCity(city);
        WebElement al = wd.findElement(By.id("dates"));
        al.click();
        //   al.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        pause(500);
        selectFirstDates(firstDates);
        selectLastDates(lastDates);
    }

    private void selectFirstDates(String firstDates) {
        String[] startDate = firstDates.split("/");
        String firstLocator = String.format("//div[text()=' %s ']", startDate[1]);
        click(By.xpath(firstLocator));
    }

    private void selectLastDates(String lastDates) {
        String[] endDate = lastDates.split("/");
        String lastLocator = String.format("//div[text()=' %s ']", endDate[1]);
        click(By.xpath(lastLocator));

    }

    public void fillFindCarForm3(String city, String startDates, String endDates) {
        selectCity(city);
        WebElement al = wd.findElement(By.id("dates"));
        // al.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        selectStartDate(startDates);
        selectFinishDate(endDates);
    }

    private void selectFinishDate(String endDates) {
        int nowToEndtMonth = 0;
        String[] finDate = endDates.split("/");

        if (LocalDate.now().getYear() == Integer.parseInt(finDate[2])) {
            pause(3000);
            //  click(By.id("dates"));
            if (LocalDate.now().getMonthValue() != Integer.parseInt(finDate[0])) {
                nowToEndtMonth = Integer.parseInt(finDate[0]) - LocalDate.now().getMonthValue();
            }
            for (int i = 0; i < nowToEndtMonth; i++) {
                click(By.xpath(("//button[@aria-label='Next month']")));
            }
            String locatorEnd = String.format("//div[.=' %s ']", finDate[1]);
            click(By.xpath(locatorEnd));
        } else if (LocalDate.now().getYear() != Integer.parseInt(finDate[2])) {
            pause(1000);
            //  click(By.id("dates"));
            click(By.xpath("//button[@aria-label='Choose month and year']"));
            String locatorEnd = String.format("//div[.=' %s ']", finDate[2]);
            click(By.xpath(locatorEnd));
            locatorEnd = String.format("(//td[@tabindex])[%s]", finDate[0]);
            click(By.xpath(locatorEnd));
            locatorEnd = String.format("//div[.=' %s ']", finDate[1]);
            click(By.xpath(locatorEnd));
        }
    }

    private void selectStartDate(String startDates) {
        int nowToStartMonth = 0;
        String[] beginDate = startDates.split("/");
        // String[] endDate = dateTo.split("/");
        if (LocalDate.now().getYear() == Integer.parseInt(beginDate[2])) {
            pause(3000);
            click(By.id("dates"));
            if (LocalDate.now().getMonthValue() != Integer.parseInt(beginDate[0])) {
                nowToStartMonth = Integer.parseInt(beginDate[0]) - LocalDate.now().getMonthValue();
            }
            for (int i = 0; i < nowToStartMonth; i++) {
                click(By.xpath(("//button[@aria-label='Next month']")));
            }
            String locatorStart = String.format("//div[.=' %s ']", beginDate[1]);
            click(By.xpath(locatorStart));
        } else if (LocalDate.now().getYear() != Integer.parseInt(beginDate[2])) {
            pause(1000);
            click(By.id("dates"));
            click(By.xpath("//button[@aria-label='Choose month and year']"));
            String locatorStart = String.format("//div[.=' %s ']", beginDate[2]);
            click(By.xpath(locatorStart));
            locatorStart = String.format("(//td[@tabindex])[%s]", beginDate[0]);
            click(By.xpath(locatorStart));
            locatorStart = String.format("//div[.=' %s ']", beginDate[1]);
            click(By.xpath(locatorStart));
        }
    }

    public void clearFindForm() {
        clear(By.cssSelector("#city"));
        //pause(3000);
        click(By.id("dates"));
        wd.findElement(By.id("dates")).sendKeys(Keys.CONTROL, "a");
        wd.findElement(By.id("dates")).sendKeys(Keys.DELETE);
        wd.findElement(By.id("dates")).sendKeys(Keys.ESCAPE);

    }


}


