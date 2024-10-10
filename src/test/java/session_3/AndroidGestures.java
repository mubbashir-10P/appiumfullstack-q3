package session_3;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import session_2.ConnectionStringUiAutomator;

import java.net.MalformedURLException;
import java.time.Duration;

public class AndroidGestures {
    AppiumDriver driver;

    @BeforeTest
    public void initializer() throws MalformedURLException {
        ConnectionStringUiAutomator uiAutomator = new ConnectionStringUiAutomator();
        driver = uiAutomator.initializeAppiumDriverViaUiAutomator();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void longClickGestureById(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));
    }

    @Test
    public void longClickGestureByCoordinates(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        //WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 217,
                "y", 659,
                "duration", 1000
        ));
    }

    @Test
    public void testSwipeGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 433, "height", 1043,
                "direction", "up",
                "percent", 0.75
        ));
    }

    @AfterTest
    public void closeWebDriver(){
        driver.quit();
    }
}
