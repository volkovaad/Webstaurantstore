package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class DifferentBrowsers extends TestBase{
    @Test(groups = "regression")
    public void test(){


        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
}
