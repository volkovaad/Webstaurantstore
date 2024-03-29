package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;


public class ClickableBanners extends TestBase{
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        logger.info("Promo Banner Click");

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Driver.getDriver().findElement(By.cssSelector("div.gtm-promo.mini-advertisements.group"));

        Assert.assertTrue(Driver.getDriver().findElement(By.cssSelector("div.gtm-promo.mini-advertisements.group")).findElements(By.tagName("a")).size() > 0);

        Thread.sleep(1000);

        }

}
