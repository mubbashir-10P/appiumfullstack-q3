package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static AppiumDriver appiumDriver;


    @BeforeTest
    public void initializer() throws MalformedURLException {
        System.out.println("Initializing Appium Driver");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability("appPackage","com.swaglabsmobileapp");
        capabilities.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
        capabilities.setCapability("newCommandTimeout", "300");

        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723"), capabilities);

        AppDriver.setDriver(appiumDriver);
        System.out.println("Appium Driver Is Initialized Successfully!");

    }

    @AfterTest
    public  void quitDriver(){
        appiumDriver.quit();
    }
}
