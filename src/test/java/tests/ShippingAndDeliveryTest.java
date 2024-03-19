package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class ShippingAndDeliveryTest extends TestBase{

    @Test (groups = "smoke")
    public void testShippingAndDeliveryLink() throws InterruptedException {
        logger.info("Shipping & Delivery TextLink Verification");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.partialLinkText("Shipping & Delivery")).click();

        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Ground Estimated Shipping Times"));



    }
}
