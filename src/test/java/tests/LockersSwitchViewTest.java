package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Lockers;
import utilities.ConfigReader;
import utilities.Driver;

public class LockersSwitchViewTest extends TestBase{
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        logger.info("Verify Grid View and List View");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Lockers LockersPage = new Lockers();
        LockersPage.NavigateLockersPage();

        Thread.sleep(1000);
        LockersPage.getListView().click();
        Assert.assertTrue(true, "List View is successfully switched.");

        Thread.sleep(1000);

        LockersPage.getGridView().click();
        Thread.sleep(1000);
        Assert.assertTrue(true, "Grid View is successfully switched back.");
    }
}
