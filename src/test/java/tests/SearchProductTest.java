package tests;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;


public class SearchProductTest extends TestBase {

    @Test(groups = "smoke")
    public void test() throws InterruptedException {

        logger.info("Search Product");
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        Driver.getDriver().findElement(By.id("searchval")).sendKeys("Smallwares", Keys.ENTER);

        Assert.assertTrue(Driver.getDriver().findElement(By.className("search__wrap")).getText().contains("smallwares"));

        Thread.sleep(1000);
    }}