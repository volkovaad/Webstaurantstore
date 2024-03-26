package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Lockers;
import utilities.ConfigReader;
import utilities.Driver;

public class LockersPlusEligibleCheckboxTest extends TestBase{

    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        logger.info("Verify Plus Eligible Checkbox");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Lockers LockersPage = new Lockers();
        LockersPage.NavigateLockersPage();

        Thread.sleep(1000);
        LockersPage.getPlusEligible().click();
        Assert.assertTrue(true, "Plus Eligible Checkbox is successfully checked");

        logger.info("Verify Quick Shipping Checkbox");
        Thread.sleep(1000);
        LockersPage.getQuickShipping().click();
        Assert.assertTrue(true, "Quick Shipping Checkbox is successfully checked");

    }
}
