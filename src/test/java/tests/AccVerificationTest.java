package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn;
import utilities.ConfigReader;
import utilities.Driver;

public class AccVerificationTest extends TestBase {

    @Test
    public void accountVerification() throws  InterruptedException {

        logger.info("Account's holder Name Verification");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Thread.sleep(10000);
        Assert.assertTrue(loginPage.getDashboardName().contains(loginPage.getLogoName()));

    }



}
