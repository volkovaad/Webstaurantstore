package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class Disposables extends TestBase{
    @Test(groups = "regression")
    public void test1(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//button[text()='Accept']")));
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.clickCategoryLink();
        categoryPage.hoverOverCategoryLink("Disposables");
        categoryPage.clickShopAllLink();
    }
    @Test(groups = "regression")
    public void test2(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//button[text()='Accept']")));
        CategoryPage categoryPage = new CategoryPage();

        categoryPage.clickCategoryLink();

        categoryPage.topProductsQuantity("2");

        categoryPage.addToCartTopProduct();
    }
    @Test(groups = "regression")
    public void test3() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//button[text()='Accept']")));
        CategoryPage categoryPage = new CategoryPage();

        categoryPage.clickCategoryLink();

        Assert.assertEquals(categoryPage.getGlovesDropdownFirstSelectedOptionText(), "Size");


        List<String > expectedSizes = List.of("Size", "Small - $19.99", "Medium - $19.99", "Large - $19.99", "Extra Large - $19.99");
        List<String> actualSizes = categoryPage.getGlovesDropdownOptionsText();

        Assert.assertEquals(actualSizes, expectedSizes);



    }




}
