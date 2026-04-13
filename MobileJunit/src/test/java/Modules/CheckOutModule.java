package Modules;

import Helpers.Helper;
import org.openqa.selenium.By;

public class CheckOutModule extends Base {
    Helper helper = new Helper();
    By txtFirstName = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    By txtLastName = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    By txtZipCode = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    By btnContinue = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]");

    public void enterCheckOutInformation() {
        enterFirstName();
        enterLastName();
        enterZip();
        clickContinueButton();
    }

    public void enterFirstName() {
        sendKeys(txtFirstName, "FName" + helper.generateRandomCharacters(5));
    }

    public void enterLastName() {
        sendKeys(txtLastName, "LName" + helper.generateRandomCharacters(5));
    }

    public void enterZip() {
        sendKeys(txtZipCode, String.valueOf(helper.generateRandomNumber(11111, 99999)));
    }

    public void clickContinueButton() {
        click(btnContinue);
    }
}
