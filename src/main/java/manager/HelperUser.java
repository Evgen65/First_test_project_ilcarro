package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public void submitRegistration() {
        click(By.xpath("(//button[contains(text(),'Y’alla!')])[1]"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void openRegistrationForm() {click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName,String email,String password) {
        type(By.xpath("//input[@id='name']"),name);
        type(By.xpath("//input[@id='lastName']"),lastName);
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void checkBox() {
        click(By.xpath("//(//label[contains(text(),'I agree to the')])[1]"));

    }
}
