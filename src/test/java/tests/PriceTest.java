package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.driver;


public class PriceTest extends TestBase{
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        logger.info("Price from Low to High");

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        driver.findElement(By.id("searchval")).sendKeys("Smallwares", Keys.ENTER);

        driver.findElement(By.xpath("//option[@value='price_asc']")).click();
Thread.sleep(1000);
   Assert.assertTrue(driver.findElements(By.xpath("//option[@value='price_asc']")).size() > 0);
        }
    }


