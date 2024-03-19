package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class AddToCartTest extends TestBase{

    @Test(groups = "regression")


    public void test(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        WebElement searchInput = Driver.getDriver().findElement(By.id("searchval"));
        searchInput.clear();
        searchInput.sendKeys("table", Keys.ENTER);
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//button[text()='Accept']")));

        Driver.getDriver().findElement(By.xpath("//input[@name='addToCartButton'][1]")).click();
        SeleniumUtils.waitFor(10);
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//a[@aria-label='Your cart has 1 items. View your cart.']")));
        Driver.getDriver().findElement(By.xpath("//button[@aria-label='Increase Quantity']")).click();

        String originalPrice = Driver.getDriver().findElement(By.xpath("//div[text()='$1,499.00']")).getText();
        String increasedPrice = Driver.getDriver().findElement(By.xpath("//strong[text()='$2,998.00']")).getText();
        Assert.assertNotEquals(originalPrice, increasedPrice);

    }
}
