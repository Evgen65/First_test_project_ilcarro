import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }

    }

    @Test(priority = 1)
    public void loginSuccess() {
        User data = new User()

                .withEmail("abc@dmail.com")
                .withPassword("Abcd1234$");
        app.getUser().openLoginForm();
        app.getUser().pause(3000);
        app.getUser().fillLoginForm("abcd@mail.com", "Abcd1234$");
        app.getUser().submitLogin();
        // Assert.assertTrue((app.getUser().isLoggedSuccess()));
    }

    @Test(priority = 2)
    public void loginSuccessModels() {
        User data = new User()
               // .withEmail("abcd@mail.com")
                .withEmail("abcd@mail.com")
                .withPassword("Abcd1234$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(data);
        app.getUser().submitLogin();
        // Assert.assertTrue((app.getUser().isLoggedSuccess()));

    }

    @Test(priority = 3)
    public void loginNegativeMail() {
        User data = new User()
                .withEmail("abcd@mail.org")
                .withPassword("Abcd1234$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("abcd65@mail.org", "Abcd1234$");
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[.='Login failed']")));
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
        app.getUser().pause(1000);
        app.getUser().clickOkButton();
    }
}
