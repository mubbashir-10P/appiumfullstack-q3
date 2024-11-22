package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppFactory {

    public static AppiumDriver appiumDriver;
    public static  ConfigReader configReader;
    protected Utilities utilities = new Utilities();
    protected static AppiumDriverLocalService service;

    @BeforeSuite
    public void upAndRunningAppiumServer(){
        service = getAppiumServerDefault();
        if(!utilities.checkIfAppiumServerIsRunning(4723)){
            service.start();
            service.clearOutPutStreams();
            System.out.println("Starting appium server...");
            utilities.log().info("Starting appium server...");
        }else {
            System.out.println("Appium Server is already up and running...");
            utilities.log().info("Appium Server is already up and running...");
        }
    }

    @AfterSuite
    public void shutDownServer(){
        service.stop();
        System.out.println("Appium server shutdown...");
        utilities.log().info("Shutting down Appium server.");
    }

    @BeforeTest
    @Parameters({"platformName","platformVersion","deviceName"})
    public void initializer(String platformName, String platformVersion, String deviceName) throws MalformedURLException {
        try{
            configReader = new ConfigReader();
            System.out.println("Initializing Appium Driver");
            utilities.log().info("Initializing appium driver");

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
            utilities.log().info("Appium Driver Is Initialized Successfully!");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to initialize Appium Driver!");
            utilities.log().error("Failed to initialize Appium Driver!");
        }
    }

    public AppiumDriverLocalService getAppiumServerDefault(){
        return AppiumDriverLocalService.buildDefaultService();
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public String getAttribute(WebElement element, String attribute) {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public  String getText(WebElement element, String message){
        String elementText = null;
        elementText = getAttribute(element,"text");
        return  elementText;
    }

    @AfterTest
    public  void quitDriver(){
        appiumDriver.quit();
    }
}
