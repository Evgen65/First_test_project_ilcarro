package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

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

    public void fillFindCarForm(String city, String firstDates, String lastDates) {//1test(manual type all data)
        selectCity(city);
        inputDates(firstDates, lastDates);
    }

    private void inputDates(String firstDate, String lastDates) {//for 1test(manual type all data)
        WebElement al = wd.findElement(By.xpath("//input[@id='dates']"));
        al.click();
        pause(2000);
        al.sendKeys(Keys.ARROW_DOWN);
        pause(2000);
        al.sendKeys(firstDate + "-" + lastDates);
        al.sendKeys(Keys.ENTER);
    }

    private void selectCity(String city) {//for all tests
        clear(By.id("city"));
        type(By.id("city"), city);
        pause(3000);
        click(By.cssSelector("div.pac-item"));
        pause(1000);
    }

    public void fillFindCarForm2(String city, String firstDates, String lastDates) {//for 2 test click at current month)
        selectCity(city);
        WebElement al = wd.findElement(By.xpath("//input[@id='dates']"));
        al.click();
        pause(2000);
        selectFirstDates(firstDates);
        pause(2000);
        selectLastDates(lastDates);
    }

    private void selectFirstDates(String firstDates) {//for 2 test click at current month)
        String[] startDate = firstDates.split("/");
        String firstLocator = String.format("//div[text()=' %s ']", startDate[1]);
        click(By.xpath(firstLocator));
    }

    private void selectLastDates(String lastDates) {//for 2 test click at current month)
        String[] endDate = lastDates.split("/");
        String lastLocator = String.format("//div[text()=' %s ']", endDate[1]);
        click(By.xpath(lastLocator));
    }

    public void fillFindCarForm3(String city, String startDates, String endDates) {//for 3 tests Universal Purpose
        selectCity(city);
        selectStartDates(startDates);
        selectEndDates(endDates);
    }

    private void selectEndDates(String endDates) {//for 3 tests Universal Purpose
        int nowToEndtMonth = 0;
        String[] finDate = endDates.split("/");

        if (LocalDate.now().getYear() == Integer.parseInt(finDate[2])) {
            pause(3000);
            //  click(By.id("dates"));
            if (LocalDate.now().getMonthValue() != Integer.parseInt(finDate[0])) {
                nowToEndtMonth = Integer.parseInt(finDate[0]) - LocalDate.now().getMonthValue();
                System.out.println(nowToEndtMonth);
            }
            for (int i = 0; i < nowToEndtMonth; i++) {
                click(By.xpath(("//button[@aria-label='Next month']")));
            }
            String locatorEnd = String.format("//div[.=' %s ']", finDate[1]);
            click(By.xpath(locatorEnd));
        } else if (LocalDate.now().getYear() != Integer.parseInt(finDate[2])) {
            pause(1500);
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

    private void selectStartDates(String startDates) {//for 3 tests Universal Purpose
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
            pause(2000);
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

    public void clearFindForm() {//for postCondition
        clear(By.cssSelector("#city"));
        //pause(3000);
        click(By.id("dates"));
        wd.findElement(By.id("dates")).sendKeys(Keys.CONTROL, "a");
        wd.findElement(By.id("dates")).sendKeys(Keys.DELETE);
        wd.findElement(By.id("dates")).sendKeys(Keys.ESCAPE);
    }

    private void selectPeriodMonths(String dateFrom, String dateTo) {

        int nowToStartMonth = 0, startToEndMonth = 0;
        String[] startDate = dateFrom.split("/");
        String[] endDate = dateTo.split("/");
        startToEndMonth = Integer.parseInt(endDate[0]) - Integer.parseInt(startDate[0]);
        pause(3000);
        click(By.id("dates"));
        if (LocalDate.now().getMonthValue() != Integer.parseInt(startDate[0])) {
            nowToStartMonth = Integer.parseInt(startDate[0]) - LocalDate.now().getMonthValue();
        }
        for (int i = 0; i < nowToStartMonth; i++) {
            click(By.xpath(("//button[@aria-label='Next month']")));
        }

        String locatorStart = String.format("//div[.=' %s ']", startDate[1]);
        String locatorEnd = String.format("//div[.=' %s ']", endDate[1]);
        click(By.xpath(locatorStart));

        for (int i = 0; i < startToEndMonth; i++) {
            click(By.xpath(("//button[@aria-label='Next month']")));
        }
        click(By.xpath(locatorEnd));
    }

    public void fillSearchForm(String city, String dateFrom, String dateTo) {//for AndreyTest
        selectCity(city);
        selectPeriodMonths(dateFrom, dateTo);
    }
}


