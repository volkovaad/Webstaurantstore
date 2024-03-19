package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class SignUpEmailTest extends TestBase{

    @Test (groups = "smoke")
    public void testSignUpEmail() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("emailaddress")).sendKeys((ConfigReader.getProperty("username")), Keys.TAB, Keys.ENTER);

        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Thanks for Joining!"));
    }
}
