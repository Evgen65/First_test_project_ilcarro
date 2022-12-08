import models.User;
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
    public void loginSuccess() {
        User data = new User()
                .withName("Vasia")
                .withLastName("Pupkin")
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm("Vasia", "Pupkin", "abcd@mail.com", "Abcd1234$");
       // app.getUser().checkBox();
        app.getUser().submitRegistration();

    }

}
