package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class SharedSteps extends BaseTest {
    LoginPage loginPage;
    String searchItem = "Printed Chiffon Dress";

    @Before
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        dispose();
    }

    @Given("User is on home page")
    public void user_is_on_home_page() {
        driver.get("http://automationpractice.com/index.php");
    }

    @When("User enters an item into the search bar")
    public void user_enters_an_item_into_the_search_bar() {
        loginPage = new LoginPage(driver);
        loginPage.searchForItem(searchItem);
    }
}
