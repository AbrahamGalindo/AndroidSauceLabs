package Modules;

import org.openqa.selenium.By;

public class LoginModule extends Base {
    By lnkStandaUser = By.xpath("//android.widget.TextView[@text=\"standard_user\"]");
    By lnkLockedUser = By.xpath("//android.widget.TextView[@text=\"locked_out_user\"]");
    By lnkProblemUser = By.xpath("//android.widget.TextView[@text=\"problem_user\"]");
    By btnLogin = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    By msgUserLocked = By.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]");

    public void login(String user) {
        selectUser(user);
        clickLogin();
    }

    public void selectUser(String user) {
        switch (user) {
            case "Standard":
                click(lnkStandaUser);
                break;
            case "Locked":
                swipeDown(driverApp);
                click(lnkLockedUser);
                break;
            case "Problem":
                swipeDown(driverApp);
                click(lnkProblemUser);
                break;
            default:
                break;
        }

    }

    public void clickLogin() {
        click(btnLogin);
    }

    public boolean msgUserIsLocked() {
        return hasElement(msgUserLocked);
    }
}
