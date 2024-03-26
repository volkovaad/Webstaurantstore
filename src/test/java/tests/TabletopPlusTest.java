package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.driver;

public class TabletopPlusTest extends TestBase{
    @Test(groups = "regression")
    public void test() throws  InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Plus leads URL check");

        WebElement tabletopLink = driver.findElement(By.linkText("Tabletop"));
        tabletopLink.click();
        WebElement plusLink = driver.findElement(By.cssSelector("[clip-rule='evenodd']"));
        plusLink.click();
        String currentURL = driver.getCurrentUrl();
        Thread.sleep(1000);
        Assert.assertEquals(currentURL, "https://www.webstaurantstore.com/plus/", "URL mismatch");
    }


    }
