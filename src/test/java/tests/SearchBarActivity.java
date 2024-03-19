package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import org.testng.annotations.Test;

public class SearchBarActivity extends TestBase {
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Search Bar Status");

       Driver.getDriver().findElement(By.id("searchval")).sendKeys("Product");

        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Product"));
    }
    }
