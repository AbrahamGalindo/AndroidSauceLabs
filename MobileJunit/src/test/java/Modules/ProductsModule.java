package Modules;

import Helpers.Helper;
import org.openqa.selenium.By;

public class ProductsModule extends Base {
    Helper helper = new Helper();
    By lblProducts = By.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    By iconCartProductAdded = By.xpath("//android.widget.TextView[@text=\"1\"]");
    By iconCart = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]");
    String btnAddToCart = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[";

    public boolean validateProductsModule() {
        waitForElement(lblProducts);
        return hasElement(lblProducts);
    }

    public void addARandomProductToCart() {
        int productNumber = helper.generateRandomNumber(1, 4);
        if (productNumber > 2) {
            swipeDown(driverApp);
        }
        click(By.xpath(btnAddToCart + productNumber + "]"));
    }

    public boolean theProductWasAdded() {
        return hasElement(iconCartProductAdded);
    }

    public void goToCart() {
        click(iconCart);
    }
}
