package Modules;

import org.openqa.selenium.By;

public class CtgCompleteModule extends Base {
    By lblOrderComplete = By.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]");
    By btnBackHome = By.xpath("//android.widget.TextView[@text=\"BACK HOME\"]");

    public boolean validateTheOrderCompleted() {
        waitForElement(lblOrderComplete);
        return hasElement(lblOrderComplete);
    }

    public void backToHome() {
        click(btnBackHome);
    }
}
