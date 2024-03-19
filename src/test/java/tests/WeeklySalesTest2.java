package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class WeeklySalesTest2 extends TestBase{


    @Test(groups = "smoke")
    public void test() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Driver.getDriver().findElement(By.partialLinkText("Weekly Sales")).click();

        Thread.sleep(1000);

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Discounted Commercial Restaurant "));

        Select makeDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@class='appearance-none bg-none border-gray-400 rounded border-solid border box-border p-0 pl-2 pr-10 relative inset-0']")));

        Thread.sleep(1000);

        makeDropdown.selectByVisibleText("Price: Low to High");

        Thread.sleep(1000);

    }

}
