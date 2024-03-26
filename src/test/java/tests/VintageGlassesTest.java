package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;


public class VintageGlassesTest extends TestBase {
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Check Beverage Glasses filter");

        WebElement tabletopLink = Driver.getDriver().findElement(By.linkText("Tabletop"));
        tabletopLink.click();
        Thread.sleep(1000);

        WebElement vintageelement = Driver.getDriver().findElement(By.cssSelector("[href='/50141/vintage-glasses.html']"));
        vintageelement.click();
       Thread.sleep(1000);

        WebElement imageLink = Driver.getDriver().findElement(By.cssSelector("img[src='/uploads/seo_category_toppers/2019/8/7_mixing.png']"));
        imageLink.click();
        Thread.sleep(2000);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("vintage-glasses.html?filter=type:beverage-glasses"),
                "URL does not match the expected pattern");
    }
}