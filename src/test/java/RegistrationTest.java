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
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().submitRegistration();
        app.getUser().pause(3000);
        app.getUser().clickOkButton();

    }

    @Test
    public void registrationNegativeTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User data = new User()
                .withName("Jonh")
                .withLastName("Snow")
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isUserExist());
        app.getUser().clickOkButton();
    }

    @Test
    public void registrationNegativeTest1() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User data = new User()
                .withName("Vasia")
                .withLastName("Pupkin")
                .withEmail("vasia" + i + "@mail.com")
                .withPassword("Abcd");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().pause(10);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'Password must contain 1 uppercase letter, 1 lowerc')]")));

    }

}
