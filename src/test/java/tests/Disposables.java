package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.CategoryPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class Disposables extends TestBase{
    @Test(groups = "regression")
    public void test1(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//button[text()='Accept']")));
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.clickCategoryLink("Disposables");
        categoryPage.hoverOverCategoryLink("Disposables");
        categoryPage.clickCategoryLink("Shop All");

    }



}
