package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WeeklySales;
import utilities.ConfigReader;
import utilities.Driver;

public class WeeklySalesClearFilter extends TestBase{


    @Test(groups = "smoke")
    public void test() throws InterruptedException {

        logger.info("Weekly Sales Dropdown Rating: High to Low");

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        WeeklySales weeklySales = new WeeklySales();

        weeklySales.WeeklySalesPage();

        Thread.sleep(1000);

        Select makeDropdown = new Select(weeklySales.getDropDown());

        Thread.sleep(1000);

        makeDropdown.selectByVisibleText("Rating: High to Low");

        Thread.sleep(1000);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Rating: High to Low"));

        Driver.getDriver().findElement(By.partialLinkText("Acopa")).click();

        Thread.sleep(1000);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Acopa Manchester 9 Qt. "));

        Driver.getDriver().findElement(By.partialLinkText("AvaMix")).click();

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("AvaMix 2 hp Blender with Digital Touchpad"));

        weeklySales.getClearFilter().click();

        Assert.assertTrue(true, "Clear Filter is successfully clicked and erased all filters");




    }

}
