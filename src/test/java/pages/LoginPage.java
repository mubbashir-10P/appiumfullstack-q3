package pages;

import base.AppDriver;
import base.AppFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AppFactory {
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @AndroidFindBy(accessibility = "test-Username")
    public WebElement userNameTextBox;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passwordTextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    public WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    private WebElement errorMessage;


    public void enterUserName(String userName){
        sendKeys(userNameTextBox, userName, "User name is: "+ userName);
    }

    public void enterPassword(String password){
        sendKeys(passwordTextBox, password, "entered password in field!");
    }

    public ProductPage clickLoginButton(){
        clickElement(loginButton, "Login button clicked!");
        return new ProductPage();
    }

    public String getErrorMessage(){
        return  getText(errorMessage,"Error text is: ");
    }
}