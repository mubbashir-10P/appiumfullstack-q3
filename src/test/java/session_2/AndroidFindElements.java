package session_2;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidFindElements {

    @Test
    public void androidFindElements() throws MalformedURLException {
        ConnectionStringUiAutomator uiAutomator = new ConnectionStringUiAutomator();
        AppiumDriver driver = uiAutomator.initializeAppiumDriverViaUiAutomator();

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility Id: "+element.getText());

        element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("ClassName: "+element.getText());

        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("Absolute Xpath: "+element.getText());

        element = driver.findElement(AppiumBy.xpath("//*[@text='Accessibility']"));
        System.out.println("Relative Xpath: "+ element.getText());
    }
}
