import models.Find;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindCarTest extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (!app.getUser().isElementPresent(By.xpath("//h1[.='Find your car now!']"))) {
            app.getFindCar().openHomePage();
        }
    }
    @Test(invocationCount = 1,groups = {"positivegroup","smokegroup"})
    public void findCarFirstWay() {
      //  int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Find inform=Find.builder()
                .city("Tel Aviv")
                .dates("1/08/2023-1/11/2023")
                .build();
        app.getFindCar().fillFindCarForm(inform);
        app.getFindCar().submitFindForm();
        Assert.assertTrue(app.getFindCar().isElementPresent(By.xpath("//div[@class='search-results']")));
        app.getUser().returnToHome();
    }
    @Test(invocationCount = 1,groups = {"positivegroup","smokegroup"})
    public void findSecondWay(){
        Find inform=Find.builder()
                .city("Tel Aviv")
                .firstDates("8")
                .lastDates("11")
                .build();
        app.getFindCar().fillFindCarForm2(inform);
        app.getFindCar().submitFindForm();
        Assert.assertTrue(app.getFindCar().isElementPresent(By.xpath("//div[@class='search-results']")));
        app.getUser().returnToHome();
    }
    @Test(invocationCount = 1,groups = {"positivegroup","smokegroup"})
    public void findThirdWay(){
        Find inform=Find.builder()
                .city("Tel Aviv")
                .firstDates("1")
                .lastDates("5")
                .firstMonth("JAN")
                .firstYear("2024")
                .build();
        app.getFindCar().fillFindCarForm3(inform);
        app.getFindCar().submitFindForm();
        Assert.assertTrue(app.getFindCar().isElementPresent(By.xpath("//div[@class='search-results']")));
    }


}
