package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;
import utilities.ConfigReader;
import utilities.Driver;



public class SwitchFrenchPressTest extends TestBase {
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
          logger.info("Check list and grid view");

        Driver.getDriver().findElement(By.linkText("Tabletop")).click();


        Driver.getDriver().findElement(By.xpath("//img[@alt='French Presses']")).click();

        Thread.sleep(1000);
        Driver.getDriver().findElement(By.cssSelector("[aria-label='Switch to Grid view']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.cssSelector("[aria-label='Switch to List view']")).click();
       Thread.sleep(1000);
        Assert.assertTrue(true, "Grid and List views are successfully switched.");
    }
    }
