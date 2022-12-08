import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }

    }

    @Test
    public void loginSuccess() {
        User data = new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("abcd@mail.com", "Abcd1234$");
        app.getUser().submitLogin();

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().pause(5);
        app.getUser().clickOkButton();
    }
}
