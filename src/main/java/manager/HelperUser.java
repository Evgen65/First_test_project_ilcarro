package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


//    public void submitLogin() {
//
//        click(By.xpath("//button[@type='submit']"));
//    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

// //   public void submitRegistration() {
//        click(By.cssSelector("button[type='submit']"));
//    }

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
        type(By.id(email), email);
        type(By.id(password), password);
    }

    public void fillLoginForm(User data) {
        fillEmail(data.getEmail());
        fillPassword(data.getPassword());
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.xpath("//input[@id='name']"), name);
        type(By.xpath("//input[@id='lastName']"), lastName);
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);

    }

    public void fillRegistrationForm(User data) {
        fillName(data.getName());
        //fillName(null);
        fillLastName(data.getLastName());
        fillEmail(data.getEmail());
        fillPassword(data.getPassword());
        pause(3000);
       //  click(By.cssSelector("label[for='terms-of-use']"));
        //checkPolicy();
        JavascriptExecutor js = (JavascriptExecutor) wd;
       js.executeScript("document.querySelector('#terms-of-use').click();");

    }

    public void fillRegistrationVar2(User data) {
        fillName(data.getName());
        fillLastName(data.getLastName());
        fillEmail(data.getEmail());
        fillPassword(data.getPassword());

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }


    public void fillLoginNegativeForm(User data) {
        fillEmail(data.getEmail());
        fillPassword(data.getPassword());
    }

    private void fillName(String name) {
        type(By.xpath("//input[@id='name']"), name);
    }

    private void fillLastName(String lastName) {
        type(By.xpath("//input[@id='lastName']"), lastName);

    }

    private void fillEmail(String email) {
        pause(3000);
        type(By.xpath("//input[@id='email']"), email);
    }

    private void fillPassword(String password) {

        type(By.xpath("//input[@id='password']"), password);

    }


//    public boolean isLoggedSuccess(){
//        WebDriverWait wait=new WebDriverWait(wd,5);
//        WebElement element=wd.findElement((By.xpath("(//h2[text()='Logged in success'])[1]"))));
//        wait.until(ExpectedConditions.visibilityOf(element));
//
//
//        return element.getText().contains("success");
//
//    }


    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        // pause(5);
        // clickOkButton();

    }


    public boolean isUserExist() {
        WebDriverWait wait = new WebDriverWait(wd, 2000);
        WebElement element = wd.findElement((By.xpath("//div/h2[contains(.,'User already exists')]")));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().contains("User already exists");
    }

    public boolean isRegistred() {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[text()='Registered']"))));
        return wd.findElement(By.xpath(".//h1[text()='Registered']")).getText().contains("Registered");
    }
    //  click(By.cssSelector("label[for='terms-of-use']"));//var1
    // JavascriptExecutor js = (JavascriptExecutor) wd;//var2
    //js.executeScript("document.querySelector('#terms-of-use').click();");

    public void checkPolicy() {
        Rectangle rect = wd.findElement(By.cssSelector(".checkbox-container")).getRect();
        int x = rect.getX() + 5;
        int y = rect.getY() + 1 / 4 * rect.getHeight();
        Actions actions = new Actions(wd);
        //actions.moveByOffset(x, y).click().perform();
        actions.moveToElement((WebElement) rect,x,y);
    }
    public void returnToHome() {
        click(By.xpath(("//img[@alt='logo'][1]")));

    }

}