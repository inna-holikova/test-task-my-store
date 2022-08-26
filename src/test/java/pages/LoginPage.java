package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    protected WebDriver driver;

    private By btn_logOut = By.cssSelector("a.logout");
    private By btn_signIn = By.cssSelector("a.login");
    private By txt_userEmail = By.id("email");
    private By txt_userPassword = By.id(("passwd"));
    private By btn_submit = By.id("SubmitLogin");
    private By txt_accountName = By.cssSelector("a.account");
    private By txt_authError = By.cssSelector(".alert.alert-danger");
    private By login_Step = By.cssSelector(".step_current.second");
    private By search_bar = By.id("search_query_top");
    private By btn_search = By.cssSelector(".button-search");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignIn() {
        driver.findElement(btn_signIn).click();
    }

    public void enterUserEmail(String email) {
        driver.findElement(txt_userEmail).sendKeys(email);
    }

    public void enterUserPassword(String password) {
        driver.findElement(txt_userPassword).sendKeys(password);
    }

    public void logInToTheAccount() {
        driver.findElement(btn_submit).click();
    }

    public void checkLogOutButtonIsVisible(){
        driver.findElement(btn_logOut).isDisplayed();
    }

    public String getAccountName(){
        return driver.findElement(txt_accountName).getText();
    }

    public String getAuthErrorText(){
        return driver.findElement(txt_authError).getText();
    }

    public void checkUserIsOnLoginPage(){
        driver.findElement(login_Step).isDisplayed();
    }

    public void searchForItem(String item) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(search_bar));
        driver.findElement(search_bar).sendKeys(item);
        clickSearch();
    }

    public void clickSearch() {
        driver.findElement(btn_search).click();
    }
}
