package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class SavingWithPlusTest extends TestBase{

    @Test(groups = "smoke")
    public void test() throws InterruptedException{

        logger.info("Savings with Plus Link Verification");

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Driver.getDriver().findElement(By.partialLinkText("Start saving with Plus")).click();

        Thread.sleep(1000);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Guaranteed Savings"));



    }


}
