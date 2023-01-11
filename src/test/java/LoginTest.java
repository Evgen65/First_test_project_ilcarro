import manager.DataProviderForFindCar;
import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NGListener.class)
public class LoginTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
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
        app.getUser().submit();
        // Assert.assertTrue((app.getUser().isLoggedSuccess()));
    }

    @Test(invocationCount = 1,groups = {"positivegroup", "smokegroup"}, dataProvider = "loginModelDto", dataProviderClass = ProviderData.class)
    public void loginSuccessModels(User user) {
        logger.info(("User; " + user.toString()));
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submit();
    }
    // Assert.assertTrue((app.getUser().isLoggedSuccess()));


    @Test(priority = 3)
    public void loginNegativeMail() {
        User data = new User()
                .withEmail("abcd@mail.org")
                .withPassword("Abcd1234$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("abcd65@mail.org", "Abcd1234$");
        app.getUser().submit();
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
        app.getUser().submit();
       // Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button[text()='Ok']")));
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getUser().pause(1000);
        app.getUser().clickOkButton();
    }
}
