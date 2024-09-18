import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionStringWithDesiredCapabilities {
    AppiumDriver driver;

    @BeforeTest
    public void initializer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");
        capabilities.setCapability("noReset", false);
        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
        System.out.println("Session ID:" + driver.getSessionId());
        System.out.println("Opening Appium Server");
    }

    @Test
    public void sampleTest() {
        System.out.print("This is a 1st Sample Test");
    }

    // @AfterTest
    public void teaDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
