import models.Car;
import models.User;
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


        }
    }

    @Test
    public void addNewCarPositive() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Car car = Car.builder()
                .address("Tel Aviv")
                .make("KIA")
                .model("Sportage")
                .year("2002")
                .fuel("Petrol")
                .seats("4")
                .carClass("5")
                .carRegNumber("400-200-+i")
                .price("150")
                .build();

        app.getCar().pause(3);
        app.getCar().openCarForm();
        Assert.assertTrue((app.getCar().isCarFormPresent()));
//        app.getCar().fillCarForm();
//        app.getCar().submitForm();


    }

//    body > app-root:nth-child(1) > app-navigator:nth-child(1) > div:nth-child(1) > a:nth-child(3)
}