package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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

    @AfterTest
    public  void quitDriver(){
        appiumDriver.quit();
    }
}
