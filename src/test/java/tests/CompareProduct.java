package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import org.testng.Assert;

import static utilities.Driver.driver;

public class CompareProduct extends TestBase {
    @Test(groups = "smoke")
    public void signOut() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
      logger.info("Check Capacity filter");

        WebElement tabletopLink = driver.findElement(By.linkText("Tabletop"));
        tabletopLink.click();
        Thread.sleep(1000);

        WebElement vintageelement = driver.findElement(By.cssSelector("[href='/50141/vintage-glasses.html']"));
        vintageelement.click();
        Thread.sleep(1000);

        WebElement comparebutton = driver.findElement(By.cssSelector("button[data-original-title='Compare up to 4 products']"));
        comparebutton.click();

        Thread.sleep(2000);


    }

}