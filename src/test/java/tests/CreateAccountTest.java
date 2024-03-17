package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreatingAcc;
import pages.LogIn;
import pages.LogOut;
import utilities.CSVReader;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;

public class CreateAccountTest extends TestBase {

    @Test(dataProvider = "customerData")
    public void createAccount(String address, String city, String state, String zip) throws InterruptedException {

        logger.info("Creating Account");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        CreatingAcc createNewAcc = new CreatingAcc();
        createNewAcc.creatingAcc();

        createNewAcc.generateInfo1();
        createNewAcc.getAddandZip(address,city, state, zip);
        createNewAcc.generateInfo2();

        Thread.sleep(1000);
        createNewAcc.finish();

        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Account Dashboard"));

    }

    @DataProvider(name = "customerData")
    public Object[][] getData() {
        Object[][] allData = CSVReader.readData("src/test/resources/testData/addresses.csv");
        Random random = new Random();
        int randomIndex = random.nextInt(allData.length);
        return new Object[][] { allData[randomIndex] };
    }
}
