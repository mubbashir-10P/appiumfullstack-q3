package session_2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionStringUiAutomator {
    AppiumDriver app_driver;

    public AppiumDriver initializeAppiumDriverViaUiAutomator() throws MalformedURLException {
        System.out.println("Initializing Appium Driver using UiAutomator");
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();


        uiAutomator2Options.setCapability("platformName", "Android");
        uiAutomator2Options.setCapability("deviceName", "emulator-5554");
        uiAutomator2Options.setCapability("automationName", "UiAutomator2");
        uiAutomator2Options.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");
        uiAutomator2Options.setCapability("noReset", false);
        app_driver = new AndroidDriver(new URL("http://localhost:4723"), uiAutomator2Options);

        System.out.println("Session ID:" + app_driver.getSessionId());
        System.out.println("Opening Appium Server");

        return app_driver;
    }

    @Test
    public void sampleTest() {
        System.out.print("This is a 1st Sample Test");
    }

}
