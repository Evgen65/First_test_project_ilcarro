import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged() == false) {
            app.getUser()
                    .login(new User()
                            .withEmail("abcd@mail.com")
                            .withPassword("Abcd1234$"));
            app.getUser().pause(10);
            app.getUser().clickOkButton();

        }
    }

    @Test
    public void addNewCarPositive() {
        int i =(int)( (System.currentTimeMillis()/1000)%3600);
        Car car= Car.builder()
        .address("Kia")
                .make("Sportge")
                .year("2002")
                .fuel("Petrol")
                .seats("4")
                .carClass("5")
                .regNumber("100-200"+i)
                .price("140")
                .build();
        app.getCar().openCarForm();
        Assert.assertTrue((app.getCar().isCarFormPresent()));
//        app.getCar().fillCarForm();
//        app.getCar().submitForm();

    }
}