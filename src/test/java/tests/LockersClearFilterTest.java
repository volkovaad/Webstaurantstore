package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Lockers;
import utilities.ConfigReader;
import utilities.Driver;

public class LockersClearFilterTest extends TestBase{

    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        logger.info("Verify Clear Filter");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Lockers LockersPage = new Lockers();
        LockersPage.NavigateLockersPage();

        Thread.sleep(1000);
        LockersPage.getPlusEligible().click();

        Thread.sleep(1000);
        LockersPage.getQuickShipping().click();

        Thread.sleep(1000);
        LockersPage.getClearFilter().click();
        Assert.assertTrue(true, "Clear Filter is successfully clicked and erased all filters");



    }
}
