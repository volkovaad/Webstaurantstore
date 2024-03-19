package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class WeeklySalesTest extends TestBase{


    @Test(groups = "smoke")
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Driver.getDriver().findElement(By.partialLinkText("Weekly Sales")).click();

        Thread.sleep(1000);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Discounted Commercial Restaurant "));
    }

}
