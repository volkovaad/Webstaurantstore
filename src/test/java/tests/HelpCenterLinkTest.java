package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class HelpCenterLinkTest extends TestBase{

   @Test
    public void testHelpCenterLink() throws InterruptedException {
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            Driver.getDriver().findElement(By.partialLinkText("Help Center")).click();

            Thread.sleep(1000);
            Assert.assertTrue(Driver.getDriver().getPageSource().contains("Need to email Customer Solutions?"));

    }

}
