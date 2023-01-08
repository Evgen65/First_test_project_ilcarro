import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase {


    @BeforeMethod(alwaysRun = true)
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
        logger.info("Metod addNewCarPositive started");

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Car car = Car.builder()
                .address("Tel Aviv")
                .make("KIA"+i)
                .model("Sportage"+i)
                .year("2001")
                .fuel("Petrol")
                .seats("4")
                .carClass("5")
                .carRegNumber(i+"-200-"+i)
                .price("150")
                .build();

        app.getUser().pause(3000);
        app.getCar().openCarForm();
      //  Assert.assertTrue((app.getCar().isCarFormPresent()));
        app.getUser().pause(3000);
        app.getCar().fillCarForm(car);
        app.getCar().submitForm();
        app.getUser().pause(5000);
      //  Assert.assertTrue(app.getUser().getText(By.xpath("//h2[contains(.,'KIA Sportage added successful')]"))
       //         .contains("KIA Sportage"));
        logger.info("Metod addNewCarPositive stopped with: \n" + car.toString());
    }
    @Test
    public void addNewCarNegative() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        Car car = Car.builder()
                .address("2002")
                .make("KIA"+i)
                .model("Sportage"+i)
                .year("2001")
                .fuel("Petrol")
                .seats("4")
                .carClass("5")
                .carRegNumber(i+"-200-"+i)
                .price("150")
                .build();

        app.getUser().pause(3000);
        app.getCar().openCarForm();
        //  Assert.assertTrue((app.getCar().isCarFormPresent()));
        app.getUser().pause(3000);
        app.getCar().fillCarForm(car);
        app.getCar().submitForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[text()='Car adding failed']")));
        app.getUser().clickOkButton();
    }




}

