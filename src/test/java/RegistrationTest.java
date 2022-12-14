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
    public void registrationPositiveTest() {
        int i =(int)( (System.currentTimeMillis()/1000)%3600);
        User data = new User()
                .withName("Vasia")
                .withLastName("Pupkin")
                .withEmail("vasia"+i+"@mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(data);
        app.getUser().pause(10);
        app.getUser().submitRegistration();
        app.getUser().clickOkButton();

    }

}
