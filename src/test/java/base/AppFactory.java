package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static AppiumDriver appiumDriver;
    public static  ConfigReader configReader;

    @BeforeTest
    @Parameters({"platformName","platformVersion","deviceName"})
    public void initializer(String platformName, String platformVersion, String deviceName) throws MalformedURLException {
        try{
            configReader = new ConfigReader();
            System.out.println("Initializing Appium Driver");

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("automationName", configReader.getAutomationName());
            capabilities.setCapability("app", System.getProperty("user.dir") + configReader.getApkPath());
            capabilities.setCapability("noReset", configReader.getNoReset());
            capabilities.setCapability("appPackage",configReader.getAppPackage());
            capabilities.setCapability("appActivity",configReader.getAppActivity());
            capabilities.setCapability("newCommandTimeout", configReader.getCommandTimeoutValue());

            appiumDriver = new AppiumDriver(new URL(configReader.appiumServerEndpointURL()), capabilities);

            AppDriver.setDriver(appiumDriver);
            System.out.println("Appium Driver Is Initialized Successfully!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to initialize Appium Driver!");
        }
    }

    @AfterTest
    public  void quitDriver(){
        appiumDriver.quit();
    }
}
