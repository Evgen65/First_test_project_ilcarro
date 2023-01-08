import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
            app.getUser().pause(5000);
        }
    }

    @Test
    public void registrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User data = new User()
                .withName("Vasia")
                .withLastName("Pupkin")
                .withEmail("vasia" + i + "@mail.com")
                .withPassword("Abcd1234$");
        logger.info("registrationPositiveTest with Name :" + data.getName() + " Last Name " + data.getLastName() + " email: " + data.getEmail() + " pasword: " + data.getPassword());

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().submit();
        app.getUser().pause(2000);
      //  Assert.assertTrue(app.getUser().isLogged());


    }

    @Test
    public void registrationNegativeTest1() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User data = new User()
                .withName("Vasia")
                .withLastName("Pupkin")
                .withEmail("vasia" + i + "@mail.com")
                .withPassword("Abcd1234$");
        logger.info("registrationPositiveTest with  Name :" + data.getName() + " Last Name " + data.getLastName() + " email: " + data.getEmail() + " pasword: " + data.getPassword());

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().submit();
        app.getUser().pause(2000);
        app.getUser().clickOkButton();
        app.getUser().pause(1500);
        app.getUser().logout();
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().submit();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getUser().isUserExist());
        app.getUser().clickOkButton();
        app.getUser().returnToHome();
    }

    @Test
    public void registrationNegativeTest2() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User data = new User()
                .withName("Vasia")
                .withLastName("Pupkin")
                .withEmail("vasia" + i + "@mail.com")
                .withPassword("Abcd");
        logger.info("registrationPositiveTest with Name :" + data.getName() + " Last Name " + data.getLastName() + " email: " + data.getEmail() + " pasword: " + data.getPassword());

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
      //  app.getUser().pause(3000);
        app.getUser().submit();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text()," +
                "'Password must contain 1 uppercase letter, 1 lowerc')]")));
        app.getUser().returnToHome();

    }
}


