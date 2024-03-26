package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.Driver.driver;

public class VintageGlassesTest extends TestBase {
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Check Beverage Glasses filter");

        WebElement tabletopLink = driver.findElement(By.linkText("Tabletop"));
        tabletopLink.click();
        Thread.sleep(1000);

        WebElement vintageelement = driver.findElement(By.cssSelector("[href='/50141/vintage-glasses.html']"));
        vintageelement.click();
       Thread.sleep(1000);

        WebElement imageLink = driver.findElement(By.cssSelector("img[src='/uploads/seo_category_toppers/2019/8/7_mixing.png']"));
        imageLink.click();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("vintage-glasses.html?filter=type:beverage-glasses"),
                "URL does not match the expected pattern");
    }
}