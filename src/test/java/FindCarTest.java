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
        app.getFindCar().fillFindCarForm("Tel-Aviv","1/08/2023-1/11/2023");
        app.getFindCar().submit();
        Assert.assertTrue(app.getFindCar().isElementPresent(By.xpath("//div[@class='search-results']")));
        app.getFindCar().openHomePage();
    }
    @Test(invocationCount = 1,groups = {"positivegroup","smokegroup"})
    public void findSecondWay(){
        app.getFindCar().fillFindCarForm2("Tel-Aviv","2/8/2023","4/15/2023");
        app.getFindCar().submit();
        Assert.assertTrue(app.getFindCar().isElementPresent(By.xpath("//div[@class='search-results']")));
      //  app.getFindCar().openHomePage();
    }
    @Test(invocationCount = 1,groups = {"positivegroup","smokegroup"})
    public void findThirdWay(){

        app.getFindCar().fillFindCarForm3("Tel-Aviv","12/1/2023","1/7/2023");
        app.getFindCar().submit();
        Assert.assertTrue(app.getFindCar().isElementPresent(By.xpath("//div[@class='search-results']")));
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        app.getFindCar().openHomePage();
        app.getFindCar().clearFindForm();
    }
}
