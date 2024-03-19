package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class KeywordAppears extends TestBase{
    @Test(groups = "regression")
    public void test() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        WebElement searchInput = Driver.getDriver().findElement(By.id("searchval"));
        searchInput.clear();
        searchInput.sendKeys("table", Keys.ENTER);

        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//button[text()='Accept']")));



        List<WebElement> descriptions = Driver.getDriver().findElements(By.xpath("//span[@data-testid='itemDescription']"));


        int count = 0;


        for (WebElement description : descriptions) {
            String text = description.getText().toLowerCase();
            if (text.contains("table")) {
                count++;
            }

        }


        Assert.assertEquals(count, 60, "Expected keyword 'table' to appear 60 times in the search results");}



}
