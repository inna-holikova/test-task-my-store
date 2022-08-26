package StepDefinitions;

import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.ProductPage;

public class PurchaseSteps extends BaseTest {
    ProductPage productPage;
    String expectedMessage = "Product successfully added to your shopping cart";
    String expectedQuantity = "2";
    String itemPrice = null;

    @When("User increases item quantity by one")
    public void user_increases_item_quantity_by_one() {
        productPage.increaseQuantity();
    }

    @When("User adds the item to cart")
    public void user_adds_the_item_to_cart() {
        productPage.addToCart();
        String successMessage = productPage.getSuccessMessageText();
        Assertions.assertThat(successMessage).contains(expectedMessage);
    }

    @When("User sees the expected item quantity")
    public void user_sees_the_expected_item_quantity() {
        String quantity = productPage.getItemQuantity();
        Assertions.assertThat(quantity).contains(expectedQuantity);
    }

    @When("User goes to checkout")
    public void user_goes_to_checkout() {
        productPage.goToCheckout();
    }

    @When("User sees the expected unit price")
    public void user_sees_the_expected_unit_price() {
        String price = productPage.getUnitPrice();
        Assertions.assertThat(price).contains(itemPrice);
    }

    @When("User clicks Proceed to checkout")
    public void user_clicks_proceed_to_checkout() {
        productPage.proceedToCheckout();
    }

    @When("User checks item price")
    public String user_checks_item_price() {
        productPage = new ProductPage(driver);
        itemPrice = productPage.getProductPrice();
        return itemPrice;
    }

    @When("User clicks on item")
    public void user_clicks_on_item() {
        productPage = new ProductPage(driver);
        productPage.clickOnItem();
    }
}
