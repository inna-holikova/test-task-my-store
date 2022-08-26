package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseTest {
    LoginPage loginPage;
    String expectedName = "Test Test";
    String expectedError = "Authentication failed.";

    @When("User clicks Sign In")
    public void user_clicks_sign_in() {
        loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
    }

    @When("^User enters (.*) and (.*)$")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.enterUserEmail(email);
        loginPage.enterUserPassword(password);
    }

    @When("clicks Sign In")
    public void clicks_sign_in() {
        loginPage.logInToTheAccount();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String actualName = loginPage.getAccountName();
        Assert.assertEquals(actualName, expectedName);
        loginPage.checkLogOutButtonIsVisible();
    }

    @Then("User should see an error Authentication failed")
    public void user_should_see_an_error() {
        String authError = loginPage.getAuthErrorText();
        Assertions.assertThat(authError).contains(expectedError);
    }

    @Then("User should be on the login page")
    public void user_should_be_on_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.checkUserIsOnLoginPage();
    }
}
