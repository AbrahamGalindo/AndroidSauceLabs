package Modules;

import Helpers.Helper;
import org.openqa.selenium.By;

public class CtgOverviewModule extends Base {
    By lblOverview = By.xpath("//android.widget.TextView[@text=\"CHECKOUT: OVERVIEW\"]");
    By btnFinish = By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");

    public boolean validateOverviewModule() {
        waitForElement(lblOverview);
        return hasElement(lblOverview);
    }

    public void clickFinish() {
        swipeDown(driverApp);
        click(btnFinish);
    }
}
