package Modules;

import Helpers.Helper;
import org.openqa.selenium.By;

public class YourCartModule extends Base {
    By lblYourCart = By.xpath("//android.widget.TextView[@text=\"YOUR CART\"]");
    By btnCheckOut = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]");

    public boolean validateYourCartModule() {
        waitForElement(lblYourCart);
        return hasElement(lblYourCart);
    }

    public void clickCheckOutButton() {
        click(btnCheckOut);
    }
}
