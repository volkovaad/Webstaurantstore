package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

@Data

public class CategoryPage {

    public CategoryPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(linkText = "Disposables")
    private WebElement categoryLink;

    @FindBy(linkText = "Shop All")
    private WebElement shopAllLink;

    @FindBy(xpath = "//input[@class='inline-block flex h-auto overflow-hidden py-2 z-20 add_qty quantity']")
    private List<WebElement> topProductsQuantities;

    @FindBy(name = "addToCartButton")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//select[@name='item_number'][1]")
    private WebElement glovesDropdown;



    public void clickCategoryLink(){
        categoryLink.click();

    }
    public void clickShopAllLink(){
        shopAllLink.click();
    }
    public void hoverOverCategoryLink(String textForHover) {
        SeleniumUtils.hover(categoryLink);
    }
    public void topProductsQuantity(String quantity){
        for (WebElement element : topProductsQuantities) {
            element.clear();
            element.sendKeys(quantity);
        }
    }
    public void addToCartTopProduct(){
        for (WebElement addToCart : addToCartButtons) {
            SeleniumUtils.jsClick(addToCart);
        }
    }
    public String getGlovesDropdownFirstSelectedOptionText() {
        return new Select(glovesDropdown).getFirstSelectedOption().getText();
    }

    public List<String> getGlovesDropdownOptionsText() {
        List<WebElement> options = new Select(glovesDropdown).getOptions();
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : options) {
            optionsText.add(option.getText());
        }
        return optionsText;
 }
}
