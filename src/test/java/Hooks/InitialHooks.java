package Hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class InitialHooks {
    public static AndroidDriver driverApp;
    private Properties configuration;
    private String platform;

    public void createDriver() throws MalformedURLException {
        configuration = new Properties();
        try {
            InputStream is = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config/config.properties");
            configuration.load(is);
            platform = configuration.getProperty("platform");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (platform.equals("local")) {
            UiAutomator2Options optionsAdmin = new UiAutomator2Options();
            optionsAdmin.setDeviceName("Pixel9").setPlatformVersion("15.0").setAppActivity("com.swaglabsmobileapp.MainActivity").setApp("C:\\Users\\a_gal\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk").setPlatformName("Android").setAutomationName("UiAutomator2").autoGrantPermissions();
            try {
                driverApp = new AndroidDriver(new URL("http://0.0.0.0:4723"), optionsAdmin);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (platform.equals("sauceLabs")) {
            try {
                MutableCapabilities caps = new MutableCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");  // The filename of the mobile app
                caps.setCapability("appium:deviceName", "Google Pixel 9 Emulator");
                caps.setCapability("appium:platformVersion", "15.0");
                caps.setCapability("appium:automationName", "UiAutomator2");
                MutableCapabilities sauceOptions = new MutableCapabilities();
                sauceOptions.setCapability("appiumVersion", "2.11.0");
                sauceOptions.setCapability("username", "oauth-agalindoba-61f8c");
                sauceOptions.setCapability("accessKey", "bcc6225a-fdec-4404-af82-eaab41ce7145");
                sauceOptions.setCapability("build", "appium-build-xxxxxx");
                sauceOptions.setCapability("name", "challenge test");
                sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
                caps.setCapability("sauce:options", sauceOptions);

                driverApp = new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void clearDriver() {
        driverApp.quit();
    }

}
