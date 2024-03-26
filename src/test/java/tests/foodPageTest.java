package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FoodPage;
import pages.LogIn;
import utilities.CSVReader;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;
import java.util.*;

import static utilities.SeleniumUtils.jsClick;

public class foodPageTest extends TestBase {

   // @Test(groups = "advanced")

        @Test(groups = "advanced", dataProvider = "customerData")
        public void fillingForm(String email,
                                String name,
                                String company,
                                String address,
                                String state,
                                String city,
                                String zip,
                                String phone) throws InterruptedException {
        guestCheckout();
        logger.info("Filling checkout form");
        FoodPage info = new FoodPage();
        info.checkoutForm(email, name, company, address, state, city, zip, phone);

        info.state();
        info.getContinueToPayment().click();

            Thread.sleep(1000);
           info.getUseSelected().click();
            Thread.sleep(2000);
            System.out.println(Driver.getDriver().getTitle());
           Assert.assertTrue(Driver.getDriver().getTitle().contains("Review & Payment | WebstaurantStore"));
    }

    @Test(groups = "advanced")
    public void wishList() throws InterruptedException {
        logger.info("Navigating to Food&Beverage/macaroons");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        FoodPage wishlist = new FoodPage();
        wishlist.navigatingtoProduct();
        logger.info("Adding item to a wish list");
        wishlist.getFirstElement().click();
        wishlist.getAddToWish().click();
        logger.info("Log in");
       LogIn signin = new LogIn();
        signin.signIn();
        signin.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        Thread.sleep(1000);
        wishlist.getWishListLeft().click();
        logger.info("Switching window and creating a wishlist");
        SeleniumUtils.switchToWindowByURL("https://www.webstaurantstore.com/wishlist.html");
        Thread.sleep(2000);
        wishlist.getCreateNewList().click();
        wishlist.getGo().click();
        wishlist.getAddAllItemsToCart().click();

        wishlist.navigatingtoProduct();
        logger.info("Adding item to a wish list");
        wishlist.getFirstElement().click();
        wishlist.getAddToWishNew().click();
        jsClick(wishlist.getAddToMyList());
        jsClick(wishlist.getPopUpWishList());

        Thread.sleep(1000);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Wish List"));

    }

    @Test(groups = "advanced")
    public void sorting() {
        logger.info("Navigating to Food&Beverage/macaroons");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        FoodPage sorting = new FoodPage();
        sorting.getSearchLine().sendKeys("macaroons", Keys.ENTER);
        logger.info("Using filter");
        jsClick(sorting.getFilter());
        String filter = sorting.getFilterOnTop().getText().trim().toLowerCase();
        System.out.println(filter);
        List<WebElement> text = sorting.getExtractedText();
        List<String> extractedtext = new ArrayList<>();
        for (WebElement description : text) {
            extractedtext.add(description.getText().trim().toLowerCase());
        }
       System.out.println(extractedtext);
        Assert.assertTrue(extractedtext.toString().contains(filter));
        logger.info("Sorting");
        sorting.sortMacaroons();
        logger.info("Extracting prices");
        List<String> extracted = new ArrayList<>();
        List<WebElement> prices = sorting.getExtractedPrice();
        for (WebElement price : prices) {
            extracted.add(price.getText().replace("$", ""));
        }
        Collections.sort(extracted);
        List<String> expectedPrices = new ArrayList<>();
        for (WebElement price : prices) {
            expectedPrices.add(price.getText().replace("$", ""));
        }
        logger.info("Verifying the correctness of sorting");
        Assert.assertEquals(extracted, expectedPrices);
    }


    @Test(groups = "advanced")
    public void comparing() throws InterruptedException {
        logger.info("Navigating to Food&Beverage/macaroons");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        FoodPage comparing = new FoodPage();
        comparing.navigatingtoProduct();
        comparing.compareItem();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Compare Products"));


    }

        public void guestCheckout () {
            logger.info("Navigating to Food&Beverage/macaroons");
            Driver.getDriver().get(ConfigReader.getProperty("url"));
            FoodPage foodtest = new FoodPage();
            foodtest.navigatingtoProduct();

            logger.info("Adding second item to card");
            foodtest.addingtoCard();
        }

        @DataProvider(name = "customerData")
        public Object[][] getData () {
            Object[][] allData = CSVReader.readData("src/test/resources/testData/checkoutData.csv");
            Random random = new Random();
            int randomIndex = random.nextInt(allData.length);
            return new Object[][]{allData[randomIndex]};
        }

    }
