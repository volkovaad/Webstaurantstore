package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class LogoTest extends TestBase{
    @Test(groups = "smoke")
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Click Logo for Home Page");

    Driver.getDriver().findElement(By.cssSelector("a[aria-label='Homepage, WebstaurantStore']")).click();

    Thread.sleep(1000);

    Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://www.webstaurantstore.com/" );
}
}
