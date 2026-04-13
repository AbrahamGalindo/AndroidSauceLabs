package Modules;

import Hooks.InitialHooks;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base extends InitialHooks {

    public WebElement waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driverApp, Duration.ofSeconds(300));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driverApp, Duration.ofSeconds(300));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(By element) {
        waitForElementClickable(element).click();
    }

    public void sendKeys(By element, String text) {
        clear(element);
        waitForElement(element).sendKeys(text);
    }

    public void clear(By element) {
        waitForElement(element).clear();
    }

    public boolean hasElement(By element) {
        return driverApp.findElement(element).isDisplayed();
    }

    public void swipeDown(AppiumDriver driver) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollForward()"
        ));
    }


}


