package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;

public class LogInTest extends TestBase {

    @Test(groups = "smoke")
    public void testValidCredentials() throws  InterruptedException {

        logger.info("Signing in with valid Credentials");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Account Dashboard"));
    }
    @Test
    public void testInvalidCredentialsNoUsername() throws InterruptedException {

        logger.info("Signing in with invalid Credentials");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login("", "invalid");
        Thread.sleep(1000);
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Account Dashboard"));
    }

    @Test
    public void testInvalidCredentialsNoPassword() throws InterruptedException {

        logger.info("Signing in with invalid Credentials");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login("somename", "");
        Thread.sleep(1000);
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Account Dashboard"));
    }

    @Test
    public void testInvalidCredentialsNoCred() throws InterruptedException {

        logger.info("Signing in with invalid Credentials");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login("", "");
        Thread.sleep(1000);
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("Account Dashboard"));
    }


}
