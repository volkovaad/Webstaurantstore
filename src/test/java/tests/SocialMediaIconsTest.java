package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class SocialMediaIconsTest extends TestBase{

    @Test(groups = "smoke")
    public void testInstagramIcon() throws InterruptedException {
        logger.info("Instagram IconLink Verification");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath("//a[@href='https://www.instagram.com/WebstaurantStore/']")).click();

        Thread.sleep(2000);
        String firstWindowsHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(firstWindowsHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Instagram"));
    }

    @Test(groups = "smoke")
    public void testYoutubeIcon() throws InterruptedException {
        logger.info("Youtube IconLink Verification");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath("//a[@href='https://www.youtube.com/user/WebstaurantStore']")).click();

        Thread.sleep(2000);
        String firstWindowsHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(firstWindowsHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Youtube"));
    }

    @Test(groups = "smoke")
    public void testFacebookIcon() throws InterruptedException {
        logger.info("Facebook IconLink Verification");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath("//a[@href='https://www.facebook.com/WebstaurantStore']")).click();

        Thread.sleep(2000);
        String firstWindowsHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(firstWindowsHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Facebook"));
    }

    @Test(groups = "smoke")
    public void testTiktokIcon() throws InterruptedException {
        logger.info("Tiktok IconLink Verification");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath("//a[@href='https://www.tiktok.com/@webstaurantstore']")).click();

        Thread.sleep(2000);
        String firstWindowsHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(firstWindowsHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("TikTok"));
    }

    @Test(groups = "smoke")
    public void testPinterestIcon() throws InterruptedException {
        logger.info("Pinterest IconLink Verification");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.xpath("//a[@href='https://www.pinterest.com/webstaurant/']")).click();

        Thread.sleep(2000);
        String firstWindowsHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(firstWindowsHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
            }
        }

        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Pinterest"));
    }
}
