package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.driver;

public class SourceCodeTest extends TestBase {


    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
      logger.info("Checking Plus page source");

        WebElement tabletopLink = driver.findElement(By.linkText("Tabletop"));
        tabletopLink.click();
        WebElement plusLink = driver.findElement(By.cssSelector("[clip-rule='evenodd']"));
        plusLink.click();
        Thread.sleep(1000);
        String pageSource = (String)((JavascriptExecutor)driver).executeScript("return document.documentElement.outerHTML");

        Assert.assertTrue(pageSource.contains("Free shipping on orders over $29"));
        Assert.assertTrue(pageSource.contains("Expedited order processing"));
        Assert.assertTrue(pageSource.contains("No commitment, cancel at anytime"));



        }

}