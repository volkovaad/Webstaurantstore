package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Lockers;
import utilities.ConfigReader;
import utilities.Driver;

public class LockersSortByDropDownTest extends TestBase{

    @Test(groups = "smoke")
    public void test() throws InterruptedException {


        Driver.getDriver().get(ConfigReader.getProperty("url"));

        Lockers LockersPage = new Lockers();
        LockersPage.NavigateLockersPage();

        Thread.sleep(1000);


        logger.info("Lockers Dropdown Price: Low to High Verification");
        Select makeDropdown1 = new Select(LockersPage.getDropDown());
        Thread.sleep(1000);
        makeDropdown1.selectByVisibleText("Price: Low to High");
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Price: Low to High"));


        logger.info("Lockers Dropdown Price: High to Low Verification");
        Select makeDropdown2 = new Select(LockersPage.getDropDown());
        Thread.sleep(1000);
        makeDropdown2.selectByVisibleText("Price: High to Low");
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Price: High to Low"));

        logger.info("Lockers Dropdown Rating: Low to High Verification");
        Select makeDropdown3 = new Select(LockersPage.getDropDown());
        Thread.sleep(1000);
        makeDropdown3.selectByVisibleText("Rating: Low to High");
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Rating: Low to High"));

        logger.info("Lockers Dropdown Rating: High to Low Verification");
        Select makeDropdown4 = new Select(LockersPage.getDropDown());
        Thread.sleep(1000);
        makeDropdown4.selectByVisibleText("Rating: High to Low");
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Rating: High to Low"));

        logger.info("Lockers Dropdown Date Added: Newest first Verification");
        Select makeDropdown5 = new Select(LockersPage.getDropDown());
        Thread.sleep(1000);
        makeDropdown5.selectByVisibleText("Date Added: Newest first");
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Date Added: Newest first"));

        logger.info("Lockers Dropdown Date Added: Oldest first Verification");
        Select makeDropdown6 =new Select(LockersPage.getDropDown());
        Thread.sleep(1000);
        makeDropdown6.selectByVisibleText("Date Added: Oldest first");
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Date Added: Oldest first"));

        logger.info("Lockers Dropdown Most Popular Verification");
        Select makeDropdown7 = new Select(LockersPage.getDropDown());
        Thread.sleep(1000);
        makeDropdown7.selectByVisibleText("Most Popular");
        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Most Popular"));


    }
}
