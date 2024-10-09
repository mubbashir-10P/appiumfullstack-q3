package session_2;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidFindElementUiAutomator {

    //https://chatgpt.com/share/66f40eb4-4474-8011-af47-a29c224e9829
    @Test
    public void findElementByUiAutomatorSelector() throws MalformedURLException {
        ConnectionStringUiAutomator uiAutomator = new ConnectionStringUiAutomator();
        AppiumDriver driver = uiAutomator.initializeAppiumDriverViaUiAutomator();

        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("Accessibility Id: " + element.getText());

        element = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println("ClassName: " + element.getText());

        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println("Description: " + element.getText());
    }
}
