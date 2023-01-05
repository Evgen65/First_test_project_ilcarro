import models.Find;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindCarTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isElementPresent(By.xpath("//h1[.='Find your car now!']"))) {
            app.getFindCar().openHomePage();
        }
    }
    @Test
    public void findCarFirstWay() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Find inform=Find.builder()
                .city("Tel Aviv")
                .dates("1/08/2023-1/11/2023")
                .build();
        app.getFindCar().fillFindCarForm(inform);
        app.getFindCar().submitFindForm();
    }
}
