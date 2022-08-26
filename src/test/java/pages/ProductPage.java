package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductPage {
    protected WebDriver driver;

    private By btn_addToCart = By.id("add_to_cart");
    private By btn_increaseQuantity = By.cssSelector(".product_quantity_up");
    private By txt_successMsg = By.cssSelector(".layer_cart_product");
    private By txt_quantity = By.id("layer_cart_product_quantity");
    private By txt_unitPrice = By.cssSelector(".price.special-price");
    private By btn_checkout = By.cssSelector(".standard-checkout");
    private By btn_goToCheckout = By.cssSelector("a[title='Proceed to checkout']");
    private By txt_productPrice = By.cssSelector(".our_price_display");
    private By link_item = By.className("product_img_link");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(btn_addToCart).click();
    }

    public void increaseQuantity() {
        driver.findElement(btn_increaseQuantity).click();
    }

    public String getSuccessMessageText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_successMsg));
        return driver.findElement(txt_successMsg).getText();
    }

    public String getItemQuantity(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_quantity));
        return driver.findElement(txt_quantity).getText();
    }

    public void goToCheckout() {
        driver.findElement(btn_goToCheckout).click();
    }

    public String getUnitPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_unitPrice));
        return driver.findElement(txt_unitPrice).getText();
    }

    public void clickOnItem() {
        List<WebElement> items = driver.findElements(link_item);
        items.get(0).click();
    }

    public String getProductPrice() {
        return driver.findElement(txt_productPrice).getText();
    }

    public void proceedToCheckout() {
        driver.findElement(btn_checkout).click();
    }
}
