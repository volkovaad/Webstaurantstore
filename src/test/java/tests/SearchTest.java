package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchTest extends TestBase{

    @Test(groups = "regression")
    public void test() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        WebElement searchInput = Driver.getDriver().findElement(By.id("searchval"));
        searchInput.clear();
        searchInput.sendKeys("table", Keys.ENTER);


        WebElement sortDropdown = Driver.getDriver().findElement(By.id("sort_options"));

        SeleniumUtils.jsClick(sortDropdown);

        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//button[text()='Accept']")));

        Select sortOptions = new Select(sortDropdown);
        sortOptions.selectByVisibleText("Price: High to Low");

        List<WebElement> priceElements = Driver.getDriver().findElements(By.xpath("//div[@data-testid='price']"));

        List<Double> prices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replaceAll("[^\\d.]", "");
            prices.add(Double.parseDouble(priceText));
        }

        List<Double> pricesCopy = new ArrayList<>(prices);

        pricesCopy.sort(Comparator.reverseOrder());

        System.out.println("Original: " + prices);
        System.out.println("Copy: " + pricesCopy);

        Assert.assertEquals(pricesCopy, prices);
    }
}
