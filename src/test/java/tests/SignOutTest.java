package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn;
import pages.LogOut;
import utilities.ConfigReader;
import utilities.Driver;

public class SignOutTest extends TestBase {

    @Test(groups = "smoke")
    public void signOut() throws  InterruptedException {

        logger.info("Signing out");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Thread.sleep(2000);
        LogOut logout = new LogOut();
        logout.signOut();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Sign In or Create an Account!");

    }



}
