package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn;
import pages.LogOut;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class SignOutTest extends TestBase {

    @Test
    public void signOut() throws  InterruptedException {

        logger.info("Signing out");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Thread.sleep(2000);
        LogOut logout = new LogOut();
        Thread.sleep(2000);
        logout.signOut();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Sign In or Create an Account!");

    }



}
