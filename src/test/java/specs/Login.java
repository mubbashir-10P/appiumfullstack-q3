package specs;

import base.AppFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class Login extends AppFactory {
    @Test
    public void TestingDriverInitialize() throws InterruptedException {

        String username = "standard_user";
        String password = "secret_sauce";
        LoginPage loginPage = new LoginPage();

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);

        ProductPage productPage = loginPage.clickLoginButton();

        String actualProductTitle = productPage.getTitle();
        String expectedProductTitle = "PRODUCTS";

        System.out.println("Actual Product page title is - " + actualProductTitle + "\n" + "Expected Product page title is - " + expectedProductTitle);
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }
}
