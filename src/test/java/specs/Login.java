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
    public void TestingWithValidPassword() throws InterruptedException {

        String username = "standard_user";
        String password = "invalidPassword";
        LoginPage loginPage = new LoginPage();

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);

        loginPage.clickLoginButton();

        String expectedErrorMessage = "Username and password do not match any user in this service.";
        String actualErrorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Login not failed!");

        System.out.println("Login Failed");
    }

    @Test(priority = 3)
    public void verifyingValidCredentials() throws InterruptedException {

        String username = "standard_user";
        String password = "secret_sauce";
        LoginPage loginPage = new LoginPage();

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);


        ProductPage productPage = loginPage.clickLoginButton();

        String actualTile = productPage.getTitle();
        String expectedTitle = "PRODUCTS";

        System.out.println("Actual Product Title is - "+ actualTile + "\n" + "Expected Product Title is: " + expectedTitle);
        Assert.assertEquals(actualTile, expectedTitle);
    }
}
