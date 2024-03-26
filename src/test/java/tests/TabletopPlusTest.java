package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class TabletopPlusTest extends TestBase{
    @Test(groups = "regression")
    public void test() throws  InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Plus leads URL check");

        WebElement tabletopLink = Driver.getDriver().findElement(By.linkText("Tabletop"));
        tabletopLink.click();
        WebElement plusLink = Driver.getDriver().findElement(By.cssSelector("[clip-rule='evenodd']"));
        plusLink.click();
        String currentURL = Driver.getDriver().getCurrentUrl();
        Thread.sleep(1000);
        Assert.assertEquals(currentURL, "https://www.webstaurantstore.com/plus/", "URL mismatch");
    }


    }
