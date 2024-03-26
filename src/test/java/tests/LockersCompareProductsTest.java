package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Lockers;
import utilities.ConfigReader;
import utilities.Driver;

public class LockersCompareProductsTest extends TestBase{
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
    logger.info("Verify Compare Products");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    Lockers LockersPage = new Lockers();
        LockersPage.NavigateLockersPage();

        Thread.sleep(1000);
        LockersPage.getCompareProducts().click();

        LockersPage.getCompareProduct1().click();
        LockersPage.getCompareProduct2().click();
        LockersPage.getCompareProductsResult().click();

        Thread.sleep(1000);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Compare Products"));
}
}
