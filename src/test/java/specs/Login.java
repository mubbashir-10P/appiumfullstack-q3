package specs;

import base.AppFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class Login extends AppFactory {

    @Test(priority = 1)
    public void verifyInvalidUserName() throws InterruptedException {
        System.out.println("Verifying Valid credentials");
        LoginPage loginPage = new LoginPage();

        loginPage.enterUserName("invalidUser");
        loginPage.enterPassword("invalidPassword");

        loginPage.clickLoginButton();

        String expectedErrorMessage = "Username and password do not match any user in this service.";
        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Login not failed!");

        System.out.println("Login Failed");
        Thread.sleep(3000);
    }



    @Test(priority = 2)
    public void TestingWithValidUserName() throws InterruptedException {

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
