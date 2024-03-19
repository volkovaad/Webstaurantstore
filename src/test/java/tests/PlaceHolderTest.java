package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class PlaceHolderTest extends TestBase{


    @Test(groups = "regression")
    public void testPlaceHolder(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        String placeholderActual = Driver.getDriver().findElement(By.id("searchval")).getAttribute("placeholder");
        String placeHolderExpected = "Search 430,000+ products";
        Assert.assertEquals(placeholderActual, placeHolderExpected);


    }
}
