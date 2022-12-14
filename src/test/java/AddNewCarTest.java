import models.Car;
import models.User;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged() == false) {
            app.getUser()
                    .login(new User()
                            .withEmail("abcd@mail.com")
                            .withPassword("Abcd1234$"));
            app.getUser().pause(3000);
            app.getUser().clickOkButton();
        }
    }

    @Test
    public void addNewCarPositive() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Car car = Car.builder()
                .address("Tel Aviv")
                .make("KIA"+i)
                .model("Sportage"+i)
                .year("20"+i)
                .fuel("Petrol")
                .seats("4")
                .carClass("5")
                .carRegNumber(i+"-200-+i")
                .price("150")
                .build();

        app.getUser().pause(3000);
        app.getCar().openCarForm();
       // Assert.assertTrue((app.getCar().isCarFormPresent()));
        app.getUser().pause(3000);
        app.getCar().fillCarForm(car);
        app.getCar().submitForm();
    }

}

