import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
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
        // Assert.assertTrue((app.getUser().isLoggedSuccess()));
    }
    @Test
    public void loginSuccessModels() {
        User data = new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        // Assert.assertTrue((app.getUser().isLoggedSuccess()));

    }

    @Test
    public void loginNegativeMail() {
        User data = new User()
                .withEmail("abcd@mail.org")
                .withPassword("Abcd1234$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("abcd@mail.org", "Abcd1234$");
        app.getUser().submitLogin();
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button[text()='Ok']")));
    }

    @Test
    public void loginNegativePass() {
        User data = new User()
                .withEmail("abcd@mail.com")
                .withPassword("Abc");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("abcd@mail.com", "Abc");
        app.getUser().submitLogin();
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button[text()='Ok']")));
    }

    @AfterMethod
    public void postCondition() {
        app.getUser().pause(5);
        app.getUser().clickOkButton();
    }
}
