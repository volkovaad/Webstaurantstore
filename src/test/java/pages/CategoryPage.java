package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

@Data

public class CategoryPage {
    public void clickCategoryLink(String textOfTheLink){
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();
    }
    public void hoverOverCategoryLink(String textForHover) {
        SeleniumUtils.hover(Driver.getDriver().findElement(By.linkText(textForHover)));
    }
    public void topProductsQuantity(String quantity){
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//input[@class='inline-block flex h-auto overflow-hidden py-2 z-20 add_qty quantity']"));
        for (WebElement element : elements) {
            element.clear();
            element.sendKeys(quantity);
        }
    }
    public void addToCartTopProduct(){
        List<WebElement> addToCartButtons = Driver.getDriver().findElements(By.name("addToCartButton"));
        for (WebElement addToCart : addToCartButtons) {
            SeleniumUtils.jsClick(addToCart);
        }
    }
}
