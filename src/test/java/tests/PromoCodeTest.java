package tests;

import org.testng.annotations.Test;
import pages.LogIn;
import pages.Promo;
import utilities.ConfigReader;
import utilities.Driver;

public class PromoCodeTest extends TestBase {

    @Test(groups = "smoke")
    public void promo() throws  InterruptedException {

        logger.info("SignIn into My Account");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LogIn loginPage = new LogIn();
        loginPage.signIn();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Thread.sleep(1000);
        logger.info("Finding elements eligible for promo code");
        Promo promo = new Promo();
        promo.promotion();
        logger.info("Using promo code");
        promo.usingCode();


    }



}
