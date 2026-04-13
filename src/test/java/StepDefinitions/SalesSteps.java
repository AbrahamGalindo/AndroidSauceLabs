package StepDefinitions;

import Hooks.InitialHooks;
import Modules.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.net.MalformedURLException;

public class SalesSteps extends InitialHooks {

    LoginModule loginModule = new LoginModule();
    ProductsModule productsModule = new ProductsModule();
    YourCartModule yourCartModule = new YourCartModule();
    CheckOutModule checkOutModule = new CheckOutModule();
    CtgOverviewModule overviewModule = new CtgOverviewModule();
    CtgCompleteModule completeModule = new CtgCompleteModule();

    @Given("Open application on android device")
    public void openApplicationOnAndroidDevice() throws MalformedURLException {
        createDriver();
    }

    @And("Login on the app as {string}")
    public void loginOnTheAppAs(String user) {
        loginModule.login(user);
    }

    @Then("Validate products module")
    public void validateProductsModule() {
        Assert.assertTrue(productsModule.validateProductsModule());
    }

    @And("Add to cart some random product")
    public void addToCartSomeRandomProduct() {
        productsModule.addARandomProductToCart();
    }

    @Then("Validate the product was added to cart")
    public void validateTheProductWasAddedToCart() {
        Assert.assertTrue(productsModule.theProductWasAdded());
    }

    @And("Go to cart")
    public void goToCart() {
        productsModule.goToCart();
    }

    @Then("Validate your cart module")
    public void validateYourCartModule() {
        Assert.assertTrue(yourCartModule.validateYourCartModule());
    }

    @And("Checkout the cart")
    public void checkoutTheCart() {
        yourCartModule.clickCheckOutButton();
    }

    @And("Enter the checkout information")
    public void enterTheCheckoutInformation() {
        checkOutModule.enterCheckOutInformation();
    }

    @And("Finish the buy")
    public void finishTheBuy() {
        Assert.assertTrue(overviewModule.validateOverviewModule());
        overviewModule.clickFinish();
    }

    @Then("Validate the order was created")
    public void validateTheOrderWasCreated() {
        Assert.assertTrue(completeModule.validateTheOrderCompleted());
    }

    @Then("Finish test")
    public void finishTest() {
        clearDriver();
    }

    @Then("Validate the user is locked")
    public void validateTheUserIsLocked() {
        Assert.assertTrue(loginModule.msgUserIsLocked());
    }

    @And("Back to home")
    public void backToHome() {
        completeModule.backToHome();
    }
}
